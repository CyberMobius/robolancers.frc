/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveTrain.DriveLoop;

/**
 * @author Armond
 */

public class DriveTrain extends Subsystem{
    private RobotDrive driveStandard, driveSlide;
    private double x, y, leftDrive, rightDrive, rotateValue;
    
    public static SpeedController leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor; //Standard Drive Motors
    public static SpeedController sliderMotor1, sliderMotor2; //Standard Drive Motors
    public static DoubleSolenoid sonicShifterPair;
    
    public DriveTrain(){
        super("Drive Train");
        
       leftFrontMotor = new Talon(RobotMap.LEFT_MOTOR_FRONT);
       leftRearMotor = new Talon(RobotMap.LEFT_MOTOR_REAR);
       rightFrontMotor = new Talon(RobotMap.RIGHT_MOTOR_FRONT);
       rightRearMotor = new Talon(RobotMap.RIGHT_MOTOR_REAR);
       
       sonicShifterPair = new DoubleSolenoid(1,2);
       
       driveStandard = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
       driveStandard.setSafetyEnabled(false); //have this so compiler wont show "Robot Drive not outputting enough data"
       
       sonicShifterPair.set(Value.kForward);
    }
    
    public void initDefaultCommand(){
        setDefaultCommand(new DriveLoop());
    }
    
    public void moveWithJoystick(double moveValue, double rotateValue, double speed){
        if (RobotMap.ARCADE_DRIVE || RobotMap.RC_DRIVE || RobotMap.WHEEL){
            y = (moveValue * moveValue * moveValue) *speed;
            x = (rotateValue *rotateValue *rotateValue) *speed;
            driveStandard.arcadeDrive(y,x);
        }
        else if(RobotMap.TANK_DRIVE){
            leftDrive = moveValue*speed;
            rightDrive = rotateValue*speed;
            driveStandard.tankDrive(leftDrive,rightDrive);
        }
    }
     
     public int getGearType(){
         if(RobotMap.HIGH_GEAR = false){ //in low gear
             return 1;
         }else{
             return 0;
         }
     }
}