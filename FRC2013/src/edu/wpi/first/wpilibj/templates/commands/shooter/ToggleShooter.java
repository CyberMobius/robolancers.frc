/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.commands.shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class ToggleShooter extends CommandBase {
    private boolean isDone, shooterOn;
    
    public ToggleShooter() {
        requires(shooter);
        isDone = false;
        shooterOn = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isDone = false;
        if(!shooterOn)
            shooter.shooterStop();
        if(shooterOn)
            shooter.shooterSpin();
        shooterOn = !shooterOn;
        isDone = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
