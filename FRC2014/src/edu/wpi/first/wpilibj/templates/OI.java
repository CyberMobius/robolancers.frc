
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.Compressor.SolenoidToggle;
import edu.wpi.first.wpilibj.templates.commands.Ramp.RampDown;
import edu.wpi.first.wpilibj.templates.commands.Ramp.RampMid;
import edu.wpi.first.wpilibj.templates.commands.Ramp.RampUp;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Kicker;
import edu.wpi.first.wpilibj.templates.subsystems.Roller;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static Joystick driveStick = new Joystick(1);
    public JoystickButton driveStickBtn1 = new JoystickButton(driveStick, 1),
        driveStickBtn2 = new JoystickButton(driveStick, 2),
        driveStickBtn3 = new JoystickButton(driveStick, 3),
        driveStickBtn4 = new JoystickButton(driveStick, 4),
        driveStickBtn5 = new JoystickButton(driveStick, 5),
        driveStickBtn6 = new JoystickButton(driveStick, 6),
        driveStickBtn7 = new JoystickButton(driveStick, 7),
        driveStickBtn8 = new JoystickButton(driveStick, 8),
        driveStickBtn9 = new JoystickButton(driveStick, 9),
        driveStickBtn10 = new JoystickButton(driveStick, 10),
        driveStickBtn11 = new JoystickButton(driveStick, 11);
    
    public static Joystick maniStick = new Joystick(2);
    public JoystickButton maniStickBtn1 = new JoystickButton(maniStick, 1),
        maniStickBtn2 = new JoystickButton(maniStick, 2),
        maniStickBtn3 = new JoystickButton(maniStick, 3),
        maniStickBtn4 = new JoystickButton(maniStick, 4),
        maniStickBtn5 = new JoystickButton(maniStick, 5),
        maniStickBtn6 = new JoystickButton(maniStick, 6),
        maniStickBtn7 = new JoystickButton(maniStick, 7),
        maniStickBtn8 = new JoystickButton(maniStick, 8),
        maniStickBtn9 = new JoystickButton(maniStick, 9),
        maniStickBtn10 = new JoystickButton(maniStick, 10),
        maniStickBtn11 = new JoystickButton(maniStick, 11);
    
    public OI(){
        driveStickBtn6.whenPressed(new SolenoidToggle(CommandBase.driveTrain, DriveTrain.sonicShifterPair, DriveTrain.isHighGear));
        driveStickBtn5.whenPressed(new SolenoidToggle(CommandBase.kicker, Kicker.kickerSolenoids, Kicker.isExtended));
        
        maniStickBtn3.whenReleased(new SolenoidToggle(CommandBase.roller, Roller.pivotArmPistons, Roller.isExtended)); 
        maniStickBtn11.whenReleased(new RampUp());
        maniStickBtn10.whenReleased(new RampMid());
        maniStickBtn9.whenReleased(new RampDown());
        //Mani Stick btn 4 and 5 for Flaps. See Flap class.
        
    }
}

