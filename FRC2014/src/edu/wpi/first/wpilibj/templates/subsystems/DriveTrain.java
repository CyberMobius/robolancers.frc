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
    private RobotDrive driveStandard, driveSlide;
    private double x, y, leftDrive, rightDrive, rotateValue;
    
    public static SpeedController leftFrontMotor, rightFrontMotor, leftRearMotor, rightRearMotor; //Standard Drive Motors
    public static SpeedController sliderMotor1, sliderMotor2; //Standard Drive Motors
    public static DoubleSolenoid sonicShifterPair;
    
    public DriveTrain(){
        super("Drive Train");
        
       leftFrontMotor = new Victor(RobotMap.LEFT_MOTOR_FRONT);
       leftRearMotor = new Victor(RobotMap.LEFT_MOTOR_REAR);
       rightFrontMotor = new Victor(RobotMap.RIGHT_MOTOR_FRONT);
       rightRearMotor = new Victor(RobotMap.RIGHT_MOTOR_REAR);
       if(RobotMap.SLIDE_DRIVE){
           sliderMotor1 = new Victor(RobotMap.SLIDER_MOTOR_1);
           sliderMotor2 = new Victor(RobotMap.SLIDER_MOTOR_2);
       }
       
       sonicShifterPair = new DoubleSolenoid(1,2);
       
       driveStandard = new RobotDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
       driveStandard.setSafetyEnabled(false); //have this so compiler wont show "Robot Drive not outputting enough data"
       
       if(RobotMap.SLIDE_DRIVE){ 
       driveSlide = new RobotDrive(sliderMotor1, sliderMotor2, null, null);
       driveSlide.setSafetyEnabled(false);
       }
       
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
    
     public void moveWithJoystickSlide(double moveValueX, double moveValueY, double rotateValue, double speed){
        if (RobotMap.ARCADE_DRIVE){
            y = (moveValueY * moveValueY * moveValueY) *speed;
            x = (moveValueX * moveValueX * moveValueX) *speed;
            rotateValue = (rotateValue * rotateValue * rotateValue) *speed;
            driveStandard.arcadeDrive(y, rotateValue);
            driveSlide.arcadeDrive(x, 0);
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