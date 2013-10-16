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
public class SpinShooterYawClockwise extends CommandBase {

    public SpinShooterYawClockwise() { //May be unused
        super("Spinning Yaw Clockwise...");
        requires(shooterYaw);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
