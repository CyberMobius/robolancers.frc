/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class FireBallsWithoutPID extends CommandBase {

    public FireBallsWithoutPID() {
        requires(shooter);
    }
    protected void initialize() {
    }

    protected void execute() {
        shooter.fireBalls();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
