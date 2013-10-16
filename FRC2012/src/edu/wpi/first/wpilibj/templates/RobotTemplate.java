/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.DriveWithJoystick;
import edu.wpi.first.wpilibj.templates.commands.shooter.FireMode;
import edu.wpi.first.wpilibj.templates.commands.shooteryaw.ShooterYawProcessTargets;
import edu.wpi.first.wpilibj.templates.kinect.HybridKinect;
import edu.wpi.first.wpilibj.templates.subsystems.Conveyor;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Finger;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 * FRC 2012 Season robot.
 * 
 * @author Eric
 */
public class RobotTemplate extends IterativeRobot {

    HybridKinect hybridKinect = new HybridKinect();
    
    public void robotInit() {
        CommandBase.init();
        dashboardInit();
    }

    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
        hybridKinect.start();
        updateDashboard();
    }

    public void autonomousContinuous() {
    }

    public void teleopInit() {
        hybridKinect.end();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateDashboard();
    }

    public void teleopContinuous() {
    }

    public void disabledInit() {
        hybridKinect.end();
    }

    public void disabledPeriodic() {
    }

    public void disabledContinuous() {
    }

    private void dashboardInit() {
        SmartDashboard.putData("Shooter PID", Shooter.shooterPID);
    }

    private void updateDashboard() { //Updates SmartDashboard
        SmartDashboard.putString("Conveyor Status", Conveyor.conveyorAction);
        SmartDashboard.putString("Finger Status", Finger.fingerAction);
        SmartDashboard.putString("Drive Train Status", DriveWithJoystick.driveStatus);
        SmartDashboard.putString("Firing Status", FireMode.firingStatus);

        SmartDashboard.putDouble("Shooter Velocity Setpoint", Shooter.velocitySetpoint);

        updateDashboardTemp();
    }

    private void updateDashboardTemp() { //All temporary SmarthDashboard updates into here        
        SmartDashboard.putDouble("Encoder Up getRate", Shooter.encoderShooter.getRate()); //TEMP (Represents Velocity)
        SmartDashboard.putDouble("Encoder Up get", Shooter.encoderShooter.get()); //TEMP
        SmartDashboard.putDouble("Encoder Distance", Shooter.encoderShooter.getDistance());

//        SmartDashboard.putDouble("Wheel Distance", Shooter.encoderShooter.getDistance()*Shooter.ENCODER_VELOCITY_TO_SHOOTER_VELOCITY);

        SmartDashboard.putDouble("m_result from ShooterPID", Shooter.shooterPID.m_result);
        SmartDashboard.putDouble("m_totalError from ShooterPID", Shooter.shooterPID.m_totalError);

        SmartDashboard.putDouble("Time Image Processing", ShooterYawProcessTargets.timeAfter);
        
        SmartDashboard.putBoolean("Left Photo", DriveTrain.leftPhoto.get());
        SmartDashboard.putBoolean("Right Photo", DriveTrain.rightPhoto.get());
        System.out.println (DriveTrain.leftPhoto.get());
    }
}
