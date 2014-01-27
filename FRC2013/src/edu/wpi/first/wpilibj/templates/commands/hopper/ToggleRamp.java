/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.hopper;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class ToggleRamp extends CommandBase {
    private boolean isDone, rampOut;
    
    public ToggleRamp() {
        requires(hopper);
        isDone = false;
        rampOut = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isDone = false;
        if(!rampOut)
            hopper.rampClosed();
        if(rampOut)
            hopper.rampOut();
        rampOut = !rampOut;
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
