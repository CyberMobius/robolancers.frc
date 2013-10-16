/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Shooter extends Subsystem {
    PIDController pidController;
    SpeedController shooterMotor;
    public static Encoder shooterEncoder;
    public static double Kp, Ki, Kd, setpoint;
    public static String shooterStatus;
    
    public Shooter(){
        super("Shooter");
        Kp = 0;
        Ki = .321;
        Kd = 0;
        setpoint = .75;
        shooterStatus = "Stopped";
        shooterMotor = new Talon(RobotMap.SHOOTER_MOTOR);
        shooterEncoder = new Encoder(RobotMap.SHOOTER_ENCODER_A, RobotMap.SHOOTER_ENCODER_B);
        shooterEncoder.setDistancePerPulse(1 / 360);
        shooterEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        pidController = new PIDController(Kp, Ki, Kd, shooterEncoder, shooterMotor);
        shooterEncoder.start();
    }
    
    public void initDefaultCommand() {}
    
    public void shooterSpeedUp(){
        setpoint += .05;
    }
    
    public void shooterSpeedDown(){
        setpoint -= .05;
    }
    
    public void shooterSpin(){
        pidController.setSetpoint(setpoint);
        pidController.enable();
        shooterStatus = "PEW PEW PEW";
    }

    public void shooterStop(){
        pidController.disable();
        shooterMotor.set(0);
        shooterEncoder.reset();
        pidController.reset();
        shooterStatus = "Stopped";
    }
}
