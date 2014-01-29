
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.DriveTrain.DriveWheelToggle;
import edu.wpi.first.wpilibj.templates.commands.Compressor.SSPneumaticToggle;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static Joystick joystick1 = new Joystick(1);
    JoystickButton joystick1Btn1 = new JoystickButton(joystick1, 1),
        joystick1Btn2 = new JoystickButton(joystick1, 2),
        joystick1Btn3 = new JoystickButton(joystick1, 3),
        joystick1Btn4 = new JoystickButton(joystick1, 4),
        joystick1Btn5 = new JoystickButton(joystick1, 5),
        joystick1Btn6 = new JoystickButton(joystick1, 6),
        joystick1Btn7 = new JoystickButton(joystick1, 7),
        joystick1Btn8 = new JoystickButton(joystick1, 8),
        joystick1Btn9 = new JoystickButton(joystick1, 9),
        joystick1Btn10 = new JoystickButton(joystick1, 10),
        joystick1Btn11 = new JoystickButton(joystick1, 11);
    
    public static Joystick joystick2 = new Joystick(2);
    JoystickButton joystick2Btn1 = new JoystickButton(joystick2, 1),
        joystick2Btn2 = new JoystickButton(joystick2, 2),
        joystick2Btn3 = new JoystickButton(joystick2, 3),
        joystick2Btn4 = new JoystickButton(joystick2, 4),
        joystick2Btn5 = new JoystickButton(joystick2, 5),
        joystick2Btn6 = new JoystickButton(joystick2, 6),
        joystick2Btn7 = new JoystickButton(joystick2, 7),
        joystick2Btn8 = new JoystickButton(joystick2, 8),
        joystick2Btn9 = new JoystickButton(joystick2, 9),
        joystick2Btn10 = new JoystickButton(joystick2, 10),
        joystick2Btn11 = new JoystickButton(joystick2, 11);
    
    public OI(){
        if(RobotMap.MONO_JOYSTICK){ //One Joystick Button Layouts
            joystick1Btn2.whenReleased(new SSPneumaticToggle(DriveTrain.sonicShifterPair));
        }
        else if(RobotMap.DUAL_JOYSTICK){ //One Joystick Button Layouts
            joystick1Btn2.whenReleased(new SSPneumaticToggle(DriveTrain.sonicShifterPair));
            joystick2Btn2.whenReleased(new SSPneumaticToggle(DriveTrain.sonicShifterPair));
        }
        else if(RobotMap.WHEEL){ //Wheel Control Drive Button Layouts
            joystick1Btn2.whenPressed(new DriveWheelToggle());
        }
        if(RobotMap.GAME_PAD){ //One Joystick Button Layouts
            joystick1Btn6.whenReleased(new SSPneumaticToggle(DriveTrain.sonicShifterPair));
        }
    }
}

