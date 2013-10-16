/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.conveyor;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Conveyor;

/**
 *
 * @author Eric
 */
public class ConveyorUp extends CommandBase {
    
    public ConveyorUp() {
        requires(conveyor);
    }

    protected void initialize() {
    }

    protected void execute() {
        conveyor.conveyorUp();
        Conveyor.conveyorAction = "Moving Up";
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
