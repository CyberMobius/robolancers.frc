/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.conveyor.StopConveyor;

/**
 *
 * @author Eric
 */
public class Conveyor extends Subsystem {

    private static Victor conveyor;
    public static String conveyorAction = "Pending";

    public Conveyor() {
        super("Conveyor");
        conveyor = new Victor(RobotMap.MOTOR_CONVEYOR);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new StopConveyor());
    }

    public static void conveyorUp() {
        conveyor.set(1);
    }

    public static void conveyorDown() {
        conveyor.set(-1);
    }

    public static void stopMoving() {
        conveyor.set(0);
    }
}
