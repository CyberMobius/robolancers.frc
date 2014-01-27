/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Eric
 */
public class FireToggle extends CommandBase {

    public static int fireCheck;
    private boolean isDone;

    public FireToggle() {
        requires(shooter);
        isDone = false;
        fireCheck = 0;
    }

    protected void initialize() {
        isDone = false;

        fireCheck++;

        if (fireCheck > 1) {
            fireCheck = 0;
        }

        isDone = true;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}