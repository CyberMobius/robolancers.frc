/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.hammer;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * Command may be unneeded now due to the use of the button.whileHeld() feature
 * 
 * @author Eric
 */
public class StopHammer extends CommandBase {

    public StopHammer() {
        super("Not Moving");
        requires(hammer);
    }

    protected void initialize() {
    }

    protected void execute() {
        hammer.stopMoving();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
