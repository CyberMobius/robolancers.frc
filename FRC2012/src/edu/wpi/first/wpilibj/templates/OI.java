package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Kinect;
import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.conveyor.ConveyorDown;
import edu.wpi.first.wpilibj.templates.commands.conveyor.ConveyorUp;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.ReverseCurrentDrive;
import edu.wpi.first.wpilibj.templates.commands.finger.FingerDown;
import edu.wpi.first.wpilibj.templates.commands.finger.FingerUp;
import edu.wpi.first.wpilibj.templates.commands.hammer.HammerDown;
import edu.wpi.first.wpilibj.templates.commands.hammer.HammerUp;
import edu.wpi.first.wpilibj.templates.commands.leds.ToggleLEDs;
import edu.wpi.first.wpilibj.templates.commands.roller.SweepBallsIn;
import edu.wpi.first.wpilibj.templates.commands.shooter.FireToggle;
import edu.wpi.first.wpilibj.templates.commands.shooter.ShooterVelocityDown;
import edu.wpi.first.wpilibj.templates.commands.shooter.ShooterVelocityUp;
import edu.wpi.first.wpilibj.templates.commands.shooteryaw.MoveShooterYawWithJoystick;

public class OI {

    public static Joystick driveStick = new Joystick(3);
    Button driveBtn1 = new JoystickButton(driveStick, 1),
            driveBtn2 = new JoystickButton(driveStick, 2),
            driveBtn3 = new JoystickButton(driveStick, 3),
            driveBtn4 = new JoystickButton(driveStick, 4),
            driveBtn5 = new JoystickButton(driveStick, 5),
            driveBtn6 = new JoystickButton(driveStick, 6),
            driveBtn7 = new JoystickButton(driveStick, 7),
            driveBtn8 = new JoystickButton(driveStick, 8),
            driveBtn9 = new JoystickButton(driveStick, 9),
            driveBtn10 = new JoystickButton(driveStick, 10),
            driveBtn11 = new JoystickButton(driveStick, 11);
    public static Joystick manipStick = new Joystick(4);
    Button manipBtn1 = new JoystickButton(manipStick, 1),
            manipBtn2 = new JoystickButton(manipStick, 2),
            manipBtn3 = new JoystickButton(manipStick, 3),
            manipBtn4 = new JoystickButton(manipStick, 4),
            manipBtn5 = new JoystickButton(manipStick, 5),
            manipBtn6 = new JoystickButton(manipStick, 6),
            manipBtn7 = new JoystickButton(manipStick, 7),
            manipBtn8 = new JoystickButton(manipStick, 8),
            manipBtn9 = new JoystickButton(manipStick, 9),
            manipBtn10 = new JoystickButton(manipStick, 10),
            manipBtn11 = new JoystickButton(manipStick, 11);
    public static Kinect kinect = Kinect.getInstance();
    public static KinectStick leftArm = new KinectStick(1);
    public static KinectStick rightArm = new KinectStick(2);

    /**
     * Bind the press of each button to a specific command or command group.
     */
    public OI() {
        driveBtn1.whileHeld(new SweepBallsIn());

        driveBtn3.whileHeld(new HammerUp());
        driveBtn2.whileHeld(new HammerDown());

        driveBtn8.whenPressed(new ReverseCurrentDrive());

        driveBtn4.whenPressed(new ToggleLEDs());

//        driveBtn9.whileHeld(new LineTrack());

        manipBtn1.whenPressed(new FireToggle());

        manipBtn6.whileHeld(new ConveyorUp());
        manipBtn7.whileHeld(new ConveyorDown());

        manipBtn11.whileHeld(new FingerUp());
        manipBtn10.whileHeld(new FingerDown());

        manipBtn8.whileHeld(new MoveShooterYawWithJoystick());

        manipBtn3.whenPressed(new ShooterVelocityUp());
        manipBtn2.whenPressed(new ShooterVelocityDown());
    }

    /**
     * Taken from the KinectGestures class:
     *
     * This method takes an input, an input range, and an output range, and uses
     * them to scale and constrain the input to the output range
     *
     * @param input The input value to be manipulated
     * @param inputMin The minimum value of the input range
     * @param inputMax The maximum value of the input range
     * @param outputMin The minimum value of the output range
     * @param outputMax The maximum value of the output range
     * @return The output value scaled and constrained to the output range
     */
    public static double CoerceToRange(double input, double inputMin, double inputMax, double outputMin, double outputMax) {
        /*
         * Determine the center of the input range and output range
         */
        double inputCenter = Math.abs(inputMax - inputMin) / 2 + inputMin;
        double outputCenter = Math.abs(outputMax - outputMin) / 2 + outputMin;

        /*
         * Scale the input range to the output range
         */
        double scale = (outputMax - outputMin) / (inputMax - inputMin);
        /*
         * Apply the transformation
         */
        double result = (input + -inputCenter) * scale + outputCenter;

        /*
         * Constrain to the output range
         */
        return Math.max(Math.min(result, outputMax), outputMin);
    }
}