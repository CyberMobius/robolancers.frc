/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.Camera;
import edu.wpi.first.wpilibj.templates.subsystems.Climber;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Hopper;
import edu.wpi.first.wpilibj.templates.subsystems.KickStand;
import edu.wpi.first.wpilibj.templates.subsystems.RobotCompressor;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static Camera camera = new Camera();
    public static Climber climber = new Climber();
    public static DriveTrain driveTrain = new DriveTrain();
    public static Hopper hopper = new Hopper();
    public static KickStand kickStand = new KickStand();
    public static RobotCompressor robotCompressor = new RobotCompressor();
    public static Shooter shooter = new Shooter();
    
    public static void init() {
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
//        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
