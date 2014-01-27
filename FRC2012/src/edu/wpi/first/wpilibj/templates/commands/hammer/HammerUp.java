/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.hammer;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Eric
 */
public class HammerUp extends CommandBase {

    public HammerUp() {
        super("Readying for another blow");
        requires(hammer);
    }

    protected void initialize() {
    }

    protected void execute() {
        hammer.resetRampStompers();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
