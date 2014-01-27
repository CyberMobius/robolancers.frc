/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.hammer.StopHammer;

/**
 *
 * @author Eric
 */
public class Hammer extends Subsystem {

    private static Victor hammer;

    public Hammer() {
        super("Ramp Stompers");
        hammer = new Victor(RobotMap.MOTOR_HAMMER);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new StopHammer());
    }

    public static void pushRampDown() {
        hammer.set(-1);
    }

    public static void resetRampStompers() {
        hammer.set(1);
    }

    public static void stopMoving() {
        hammer.set(0);
    }
}
