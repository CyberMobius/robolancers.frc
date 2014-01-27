/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.commands.shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class SpeedUpShooter extends CommandBase {
    boolean isDone;
    
    public SpeedUpShooter() {
        requires(shooter);
        isDone = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isDone = false;
        shooter.shooterSpeedUp();
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
