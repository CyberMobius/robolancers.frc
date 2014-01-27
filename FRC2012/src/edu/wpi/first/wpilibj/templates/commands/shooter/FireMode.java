/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooter;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author RoboLancers
 */
public class FireMode extends CommandBase {

    public static final int STOP_SHOOTER = 0,
            FIRE_SHOOTER = 1;
    
    public static String firingStatus;

    public FireMode() {
        requires(shooter);

        firingStatus = "Pending";
    }

    protected void initialize() {
        switch (FireToggle.fireCheck) {
            case (STOP_SHOOTER):
                Shooter.stopMoving();
                firingStatus = "Not Moving";
                break;
                
            case (FIRE_SHOOTER):
                Shooter.fireBallsWithPID(Shooter.velocitySetpoint);
                firingStatus = "FIRING - PEW PEW PEW";
                break;
        }
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
