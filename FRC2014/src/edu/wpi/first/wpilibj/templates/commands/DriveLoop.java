/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Armond
 */
public class DriveLoop extends CommandBase{
    private double moveValue, rotateValue, speed; //standard drives
    private double leftDrive, rightDrive; //wheel based drive
    private double moveValueX, moveValueY; //Slide Drive 
    
    public DriveLoop(){ requires(driveTrain); }
    
    public void initialize(){}
    
    public void execute(){
        setSpeedFactor(1.0); //set the speed to a certain value Currently: 100%
        
        if(RobotMap.MONO_JOYSTICK && RobotMap.ARCADE_DRIVE && !RobotMap.SLIDE_DRIVE){
            if((Math.abs(OI.joystick1.getRawAxis(1)) > .1) || (Math.abs(OI.joystick1.getRawAxis(2)) > .1)){
                rotateValue = OI.joystick1.getRawAxis(1);
                moveValue = OI.joystick1.getRawAxis(2);
            }else{
                moveValue = 0;
                rotateValue = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);
        }
        
        if(RobotMap.DUAL_JOYSTICK && RobotMap.TANK_DRIVE && !RobotMap.SLIDE_DRIVE){
            if((Math.abs(OI.joystick1.getRawAxis(2)) > .1)){
                leftDrive = OI.joystick1.getRawAxis(2);
            }else{
                leftDrive = 0;
            }
            if((Math.abs(OI.joystick2.getRawAxis(2)) > .1)){
                rightDrive = OI.joystick2.getRawAxis(2);
            }else{
                rightDrive = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);
        }
        
        if(RobotMap.DUAL_JOYSTICK && RobotMap.RC_DRIVE && !RobotMap.SLIDE_DRIVE){
            if((Math.abs(OI.joystick1.getRawAxis(2)) > .1)){
                moveValue = OI.joystick1.getRawAxis(2);
            }else{
                moveValue = 0;
            }
            if((Math.abs(OI.joystick2.getRawAxis(1)) > .1)){
                rotateValue = OI.joystick2.getRawAxis(1);
            }else{
                rotateValue = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);
        }
        
        if(RobotMap.GAME_PAD && RobotMap.ARCADE_DRIVE && !RobotMap.SLIDE_DRIVE){
            if((Math.abs(OI.joystick1.getRawAxis(1)) > .1) || (Math.abs(OI.joystick1.getRawAxis(2)) > .1)){
                rotateValue = OI.joystick1.getRawAxis(1);
                moveValue = OI.joystick1.getRawAxis(2);
            }else{
                moveValue = 0;
                rotateValue = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);   
        }
        
        if(RobotMap.GAME_PAD && RobotMap.TANK_DRIVE && !RobotMap.SLIDE_DRIVE){
            if((Math.abs(OI.joystick1.getRawAxis(2)) > .1)){
                leftDrive = OI.joystick1.getRawAxis(2);
            }else{
                leftDrive = 0;
            }
            if((Math.abs(OI.joystick1.getRawAxis(4)) > .1)){
                rightDrive = OI.joystick1.getRawAxis(4);
            }else{
                rightDrive = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);
        }
        
        if(RobotMap.GAME_PAD && RobotMap.RC_DRIVE && !RobotMap.SLIDE_DRIVE){
            if((Math.abs(OI.joystick1.getRawAxis(2)) > .1)){
                moveValue = OI.joystick1.getRawAxis(2);
            }else{
                moveValue = 0;
            }
            if((Math.abs(OI.joystick1.getRawAxis(4)) > .1)){
                rotateValue = OI.joystick1.getRawAxis(4);
            }else{
                rotateValue = 0;
            }
            driveTrain.moveWithJoystick(moveValue, rotateValue, speed);
        }
        
        if(RobotMap.WHEEL && !RobotMap.SLIDE_DRIVE){ //TODO: Check axis loctations
            if(Math.abs(OI.joystick1.getRawAxis(1)) > .1){ //The wheel itself
                rotateValue = OI.joystick1.getRawAxis(1);
            }else{
                rotateValue = 0;
            }
            if(Math.abs(OI.joystick1.getRawAxis(2)) > .1){ //The Pedal
                if(RobotMap.FORWARD){
                    moveValue = OI.joystick1.getRawAxis(2);
                }
                else if(RobotMap.REVERSE){
                    moveValue = -OI.joystick1.getRawAxis(2);
                }
            }else{
                moveValue = 0;
            }
        }
        
        if(RobotMap.GAME_PAD && RobotMap.ARCADE_DRIVE && RobotMap.SLIDE_DRIVE){
            if((Math.abs(OI.joystick1.getRawAxis(1)) > .1) || (Math.abs(OI.joystick1.getRawAxis(2)) > .1)){
                moveValueX = OI.joystick1.getRawAxis(1);
                moveValueY = OI.joystick1.getRawAxis(2);
            }else{
                moveValueX = 0;
                moveValueY = 0;
            }
            if(Math.abs(OI.joystick1.getRawAxis(3)) > .1){
                rotateValue = OI.joystick1.getRawAxis(3);
            }else{
                rotateValue = 0;
            }
            driveTrain.moveWithJoystickSlide(moveValueX, moveValueY, rotateValue, speed);   
        }
    }
    
    
    
    protected boolean isFinished(){ return false; }
    protected void end(){}
    protected void interrupted(){}
    
    public void setSpeedFactor(double s){ this.speed = s; }
    
}
