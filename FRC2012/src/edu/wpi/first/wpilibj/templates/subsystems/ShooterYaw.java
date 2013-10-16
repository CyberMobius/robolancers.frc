/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.shooteryaw.StopShooterYaw;

/**
 *
 * @author RoboLancers
 */
public class ShooterYaw extends Subsystem {

    public static final double TARGET_HEIGHT_TO_DISTANCE = 0.0; //Proportionality constant to convert height to distance
    private static Victor yaw;

    public ShooterYaw() {
        super("Shooter Yaw");
        yaw = new Victor(RobotMap.MOTOR_YAW);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new StopShooterYaw());
    }

    public void spinYawClockwise() {
        yaw.set(-1);
    }

    public void spinYawCounterclockwise() {
        yaw.set(1);
    }

    public void stopMoving() {
        yaw.set(0);
    }

    public void moveYawWithJoystick(double input) {
        yaw.set(-input);
    }
}
