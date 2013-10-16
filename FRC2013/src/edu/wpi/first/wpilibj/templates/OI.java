/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.camera.ProcessImage;
import edu.wpi.first.wpilibj.templates.commands.camera.ResetPosition;
import edu.wpi.first.wpilibj.templates.commands.climber.LongExtend;
import edu.wpi.first.wpilibj.templates.commands.climber.LongRetract;
import edu.wpi.first.wpilibj.templates.commands.climber.ShortExtend;
import edu.wpi.first.wpilibj.templates.commands.climber.ShortRetract;
import edu.wpi.first.wpilibj.templates.commands.climber.SupplyToLong;
import edu.wpi.first.wpilibj.templates.commands.climber.SupplyToShort;
import edu.wpi.first.wpilibj.templates.commands.hopper.ToggleRamp;
import edu.wpi.first.wpilibj.templates.commands.kickstand.ExtendKickstand;
import edu.wpi.first.wpilibj.templates.commands.kickstand.RetractKickstand;
import edu.wpi.first.wpilibj.templates.commands.shooter.SpeedDownShooter;
import edu.wpi.first.wpilibj.templates.commands.shooter.SpeedUpShooter;
import edu.wpi.first.wpilibj.templates.commands.shooter.ToggleShooter;

public class OI {
    public static Joystick driveStick = new Joystick(1);
    Button driveButton1 = new JoystickButton(driveStick, 1),
            driveButton2 = new JoystickButton(driveStick, 2),
            driveButton3 = new JoystickButton(driveStick, 3),
            driveButton4 = new JoystickButton(driveStick, 4),
            driveButton5 = new JoystickButton(driveStick, 5),
            driveButton6 = new JoystickButton(driveStick, 6),
            driveButton7 = new JoystickButton(driveStick, 7),
            driveButton8 = new JoystickButton(driveStick, 8),
            driveButton9 = new JoystickButton(driveStick, 9),
            driveButton10 = new JoystickButton(driveStick, 10),
            driveButton11 = new JoystickButton(driveStick, 11);
    public static Joystick manipulatorStick = new Joystick(2);
    Button manipulatorButton1 = new JoystickButton(manipulatorStick, 1),
            manipulatorButton2 = new JoystickButton(manipulatorStick, 2),
            manipulatorButton3 = new JoystickButton(manipulatorStick, 3),
            manipulatorButton4 = new JoystickButton(manipulatorStick, 4),
            manipulatorButton5 = new JoystickButton(manipulatorStick, 5),
            manipulatorButton6 = new JoystickButton(manipulatorStick, 6),
            manipulatorButton7 = new JoystickButton(manipulatorStick, 7),
            manipulatorButton8 = new JoystickButton(manipulatorStick, 8),
            manipulatorButton9 = new JoystickButton(manipulatorStick, 9),
            manipulatorButton10 = new JoystickButton(manipulatorStick, 10),
            manipulatorButton11 = new JoystickButton(manipulatorStick, 11);
    
    public OI(){
        //Drive Joystick
        driveButton2.whileHeld(new ExtendKickstand());
        driveButton3.whileHeld(new RetractKickstand());
        
        driveButton6.whileHeld(new LongExtend());
        driveButton7.whileHeld(new LongRetract());
        driveButton8.whileHeld(new SupplyToLong());
        driveButton9.whileHeld(new SupplyToShort());
        driveButton10.whileHeld(new ShortRetract());
        driveButton11.whileHeld(new ShortExtend());
        
        //Manipulator Joystick
        manipulatorButton1.whenPressed(new ToggleShooter());
        manipulatorButton2.whenPressed(new SpeedDownShooter());
        manipulatorButton3.whenPressed(new SpeedUpShooter());
        
        manipulatorButton4.whenPressed(new ToggleRamp());
        
        manipulatorButton8.whenPressed(new ProcessImage());
        manipulatorButton9.whenPressed(new ResetPosition());
    }
}
