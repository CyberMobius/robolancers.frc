/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooteryaw;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class MoveShooterYawWithJoystick extends CommandBase {

    public MoveShooterYawWithJoystick() {
        super("Move Shooter With Joystick");
        requires(shooterYaw);
    }

    protected void initialize() {
    }

    protected void execute() {
        shooterYaw.moveYawWithJoystick(OI.manipStick.getX()/3);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
