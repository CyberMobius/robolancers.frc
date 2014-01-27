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
public class FingerDown extends CommandBase {

    public FingerDown() {
        requires(finger);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (Finger.fingerDownLimit.get()) { //If the limit switch is not pressed...
            finger.fingerDown();
            Finger.fingerAction = "Finger Moving Down";
        } else {
            finger.stopMoving();
            Finger.fingerAction = "Finger Down Limit Pressed";
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
