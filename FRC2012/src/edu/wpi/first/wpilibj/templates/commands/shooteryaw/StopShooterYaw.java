/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooteryaw;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Eric
 */
public class StopShooterYaw extends CommandBase {

    public StopShooterYaw() {
        super("Not Moving");
        requires(shooterYaw);
    }

    protected void initialize() {
    }

    protected void execute() {
        shooterYaw.stopMoving();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
