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
public class ShooterVelocityDown extends CommandBase {

    private boolean isDone;
    
    public ShooterVelocityDown() {
        super("Velocity Down");
        requires(shooter);
        
        isDone = false;
    }

    protected void initialize() {
        isDone = false;
        //Decrease Shooter Velocity Setpoint by 5% of the max Shooter Velocity
        Shooter.velocitySetpoint = Shooter.velocitySetpoint - (0.05)*Shooter.SHOOTER_MAX_VELOCITY;
        
        if (Shooter.velocitySetpoint < 0) {
            Shooter.velocitySetpoint = 0;
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
