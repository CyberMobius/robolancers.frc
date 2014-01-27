/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.conveyor;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Eric
 */
public class StopConveyor extends CommandBase {
    
    public StopConveyor() {
        requires(conveyor);
    }

    protected void initialize() {
    }

    protected void execute() {
        conveyor.stopMoving();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
