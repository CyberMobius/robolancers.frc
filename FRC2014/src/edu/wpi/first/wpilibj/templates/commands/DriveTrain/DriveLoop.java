/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.DriveTrain;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Armond
 */
public class DriveLoop extends CommandBase{
    private double moveValue, rotateValue, speed; //standard drives
    private double leftDrive, rightDrive;
    
    public DriveLoop(){ requires(driveTrain); }
    
    public void initialize(){}
    
    public void execute(){
        setSpeedFactor(1.0); //set the speed to a certain value Currently: 100%
        
        if(RobotMap.ARCADE_DRIVE){
            if((Math.abs(OI.driveStick.getRawAxis(1)) > .1) || (Math.abs(OI.driveStick.getRawAxis(2)) > .1)){
                rotateValue = OI.driveStick.getRawAxis(1);
                moveValue = OI.driveStick.getRawAxis(2);
            }else{
                moveValue = 0;
                rotateValue = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);   
        }
        
        if(RobotMap.TANK_DRIVE){
            if((Math.abs(OI.driveStick.getRawAxis(2)) > .1)){
                leftDrive = OI.driveStick.getRawAxis(2);
            }else{
                leftDrive = 0;
            }
            if((Math.abs(OI.driveStick.getRawAxis(4)) > .1)){
                rightDrive = OI.driveStick.getRawAxis(4);
            }else{
                rightDrive = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);
        }
        
        if(RobotMap.RC_DRIVE){
            if((Math.abs(OI.driveStick.getRawAxis(2)) > .1)){
                moveValue = OI.driveStick.getRawAxis(2);
            }else{
                moveValue = 0;
            }
            if((Math.abs(OI.driveStick.getRawAxis(4)) > .1)){
                rotateValue = OI.driveStick.getRawAxis(4);
            }else{
                rotateValue = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);
        }
    }
    
    
    
    protected boolean isFinished(){ return false; }
    protected void end(){}
    protected void interrupted(){}
    
    public void setSpeedFactor(double s){ this.speed = s; }
    
}
