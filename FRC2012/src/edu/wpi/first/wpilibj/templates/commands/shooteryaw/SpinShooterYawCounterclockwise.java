/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooteryaw;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class SpinShooterYawCounterclockwise extends CommandBase {

    public SpinShooterYawCounterclockwise() { //May be unused
        super("Spinning Yaw Counterclockwise...");
        requires(shooterYaw);
    }

    protected void initialize() {
//        ShooterYaw.yawGyro.reset();
//        shooterYaw.spinYawCounterclockwiseWithPID();
    }

    protected void execute() {
//        shooterYaw.updateYawHeading();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
