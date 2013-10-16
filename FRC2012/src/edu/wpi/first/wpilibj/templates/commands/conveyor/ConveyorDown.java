/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.conveyor;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Conveyor;

/**
 *
 * @author RoboLancers
 */
public class ConveyorDown extends CommandBase {

    public ConveyorDown() {
        requires(conveyor);
    }
    protected void initialize() {
    }

    protected void execute() {
        conveyor.conveyorDown();
        Conveyor.conveyorAction = "Moving Down";
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
