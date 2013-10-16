/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.drivetrain;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Eric
 */
public class ReverseCurrentDrive extends CommandBase {

    public static int reverseCheck;
    private boolean isDone;

    public ReverseCurrentDrive() {
        requires(drivetrain);
        isDone = false;
        reverseCheck = 0;
    }

    protected void initialize() {
        isDone = false;

        switch (reverseCheck) {
            case (0):
                reverseCheck = 1;
                break;

            case (1):
                reverseCheck = 0;
                break;
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