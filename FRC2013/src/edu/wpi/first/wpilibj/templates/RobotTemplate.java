/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Camera;
import edu.wpi.first.wpilibj.templates.subsystems.Climber;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.RobotCompressor;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

public class RobotTemplate extends IterativeRobot {
    Command autonomousCommand;

    public void robotInit() {
        // instantiate the command used for the autonomous period
//        autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
        dashboardInit();
        dashboardUpdate();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
//        autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        dashboardUpdate();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void dashboardInit(){
        SmartDashboard.getNumber("Drive speed: ", 1);
    }
    
    public void dashboardUpdate(){
        SmartDashboard.putString("Current drive direction: ", DriveTrain.driveDirection);
        SmartDashboard.putNumber("Shooter velocity: ", Shooter.shooterEncoder.getRate());
        SmartDashboard.putNumber("Shooter setpoint: ", Shooter.setpoint);
        SmartDashboard.putString("Shooter status: ", Shooter.shooterStatus);
        SmartDashboard.putNumber("Camera X: ", Camera.yawServo.get());
        SmartDashboard.putNumber("Camera Y: ", Camera.yawServo.get());
        SmartDashboard.putString("Supply Valve: ", Climber.supplyStatus);
        SmartDashboard.putString("Short Valve: ", Climber.shortStatus);
        SmartDashboard.putString("Long Valve: ", Climber.longStatus);
        SmartDashboard.putString("Compressor state: ", RobotCompressor.compressorStatus);
//        SmartDashboard.putNumber("Speed: ", CommandBase.speed);
    }
    
    //This comment was made by Eric
    //This comment was made by Eric using Steve's account
}
