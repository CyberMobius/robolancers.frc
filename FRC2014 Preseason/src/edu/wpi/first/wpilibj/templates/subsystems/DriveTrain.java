/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveLoop;

/**
 * @author Armond
 */

public class DriveTrain extends Subsystem{
    private RobotDrive drive;
    private double x, y, leftDrive, rightDrive;
    
    public static SpeedController leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor;
    public static DoubleSolenoid sonicShifterPair;
    
    public DriveTrain(){
        super("Drive Train");
        
       leftFrontMotor = new Victor(RobotMap.LEFT_MOTOR_FRONT);
       leftRearMotor = new Victor(RobotMap.LEFT_MOTOR_REAR);
       rightFrontMotor = new Victor(RobotMap.RIGHT_MOTOR_FRONT);
       rightRearMotor = new Victor(RobotMap.RIGHT_MOTOR_REAR);
        
       sonicShifterPair = new DoubleSolenoid(1,2);
       
       drive = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
       drive.setSafetyEnabled(false); //have this so compiler wont show "Robot Drive not outputting enough data"
       
       sonicShifterPair.set(Value.kForward);
    }
    
    public void initDefaultCommand(){
        setDefaultCommand(new DriveLoop());
    }
    
    public void moveWithJoystick(double moveValue, double rotateValue, double speed){
        if (RobotMap.ARCADE_DRIVE || RobotMap.RC_DRIVE || RobotMap.WHEEL){
            y = (moveValue * moveValue * moveValue) *speed;
            x = (rotateValue *rotateValue *rotateValue) *speed;
            drive.arcadeDrive(y,x);
        }
        else if(RobotMap.TANK_DRIVE){
            leftDrive = moveValue*speed;
            rightDrive = rotateValue*speed;
            drive.tankDrive(leftDrive,rightDrive);
        }
    }
}
