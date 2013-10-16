package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Eric
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static Hammer hammer = new Hammer();
    public static Conveyor conveyor = new Conveyor();
    public static Roller roller = new Roller();
    public static Shooter shooter = new Shooter();
    public static ShooterYaw shooterYaw = new ShooterYaw();
    public static Finger finger = new Finger();
    public static DriveTrain drivetrain = new DriveTrain();
    public static LEDs LEDs = new LEDs();

    public static void init() {
        oi = new OI();
        
//        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(hammer);
//        SmartDashboard.putData(conveyor);
        SmartDashboard.putData(roller);
//        SmartDashboard.putData(finger);
//        SmartDashboard.putData(shooter);
//        SmartDashboard.putData(shooterYaw);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
