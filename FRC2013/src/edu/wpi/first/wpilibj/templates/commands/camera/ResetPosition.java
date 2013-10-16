/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.camera;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class ResetPosition extends CommandBase {
    boolean isDone;
    
    public ResetPosition() {
        requires(camera);
        isDone = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isDone = false;
        camera.reset();
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
