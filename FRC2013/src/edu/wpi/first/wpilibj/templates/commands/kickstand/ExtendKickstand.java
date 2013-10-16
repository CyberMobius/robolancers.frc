/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.commands.kickstand;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class ExtendKickstand extends CommandBase {
    
    public ExtendKickstand() {
        requires(kickStand);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        kickStand.kickerExtend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
