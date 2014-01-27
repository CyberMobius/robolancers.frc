/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.drivetrain;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class ToggleLineTrack extends CommandBase {
    
    private boolean isDone;
    public static boolean lineTrack;
    
    public ToggleLineTrack() {
        requires(drivetrain);
        
        isDone = false;
    }

    protected void initialize() {
        isDone = false;
        
        if (lineTrack) {
            lineTrack = false;
        } else {
            lineTrack = true;
        }
        
        isDone = true;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
