/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.finger;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Finger;

/**
 *
 * @author Eric
 */
public class FingerUp extends CommandBase {

    public FingerUp() {
        requires(finger);
    }

    protected void initialize() {
    }

    protected void execute() {
        finger.fingerUp();
        Finger.fingerAction = "Finger Moving Up";
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
