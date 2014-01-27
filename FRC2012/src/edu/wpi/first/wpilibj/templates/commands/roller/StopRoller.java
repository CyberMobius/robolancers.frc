/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.roller;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Eric
 */
public class StopRoller extends CommandBase {

    public StopRoller() {
        super("Not Moving");
        requires(roller);
    }

    protected void initialize() {
    }

    protected void execute() {
        roller.stopMoving();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
