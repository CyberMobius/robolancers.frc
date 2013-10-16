/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.finger;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class StopFinger extends CommandBase {

    public StopFinger() {
        requires(finger);
    }

    protected void initialize() {
    }

    protected void execute() {
        finger.stopMoving();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
