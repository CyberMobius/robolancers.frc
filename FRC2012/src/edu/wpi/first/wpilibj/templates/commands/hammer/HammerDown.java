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
public class HammerDown extends CommandBase {

    public HammerDown() {
        super("HAMMERING DOWN ON THAT RAMP");
        requires(hammer);
    }

    protected void initialize() {
    }

    protected void execute() {
        hammer.pushRampDown();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
