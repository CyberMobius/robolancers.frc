/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.finger.StopFinger;

/**
 *
 * @author Eric
 */
public class Finger extends Subsystem {

    private static Victor finger;
    public static DigitalInput fingerDownLimit;
    
    public static String fingerAction = "Pending";

    public Finger() {
        super("Finger");
        finger = new Victor(RobotMap.MOTOR_FINGER);

        fingerDownLimit = new DigitalInput(RobotMap.LIMIT_FINGER); //Not Pressed = true
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new StopFinger());
    }

    public void fingerUp() {
        finger.set(-1);
    }

    public void fingerDown() {
        finger.set(1);
    }

    public static void stopMoving() {
        finger.set(0);
    }

    public static void moveFingerWithJoystick(double value) {
        finger.set(-value);
    }
}
