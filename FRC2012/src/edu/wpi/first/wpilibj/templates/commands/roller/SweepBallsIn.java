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
public class SweepBallsIn extends CommandBase {

    public SweepBallsIn() {
        super("Sweeping Balls In");
        requires(roller);
    }

    protected void initialize() {
    }

    protected void execute() {
        roller.pullBallsIn();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
