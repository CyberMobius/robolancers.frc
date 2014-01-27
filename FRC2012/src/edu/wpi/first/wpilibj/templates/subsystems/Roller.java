/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.roller.StopRoller;

/**
 *
 * @author Eric
 */
public class Roller extends Subsystem {

    public static Victor roller;

    public Roller() {
        super("Roller");
        roller = new Victor(RobotMap.MOTOR_ROLLER);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new StopRoller());
    }

    public static void pullBallsIn() {
        roller.set(-1);
    }

    public void pushBallsOut() {
        roller.set(1);
    }

    public static void stopMoving() {
        roller.set(0);
    }
}
