/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Armond
 */
public class DriveWheelToggle extends CommandBase{
    boolean hasFinished = false;
    
    protected void initialize() {
        
    }

    protected void execute() { //Switch drive states for Wheel-Based-Drive
        if(RobotMap.FORWARD == true){ 
            RobotMap.FORWARD = false;
            RobotMap.REVERSE = true;
        }else{
            RobotMap.FORWARD = true;
            RobotMap.REVERSE = false;
        }
        
        hasFinished = true;
    }

    protected boolean isFinished() { return hasFinished; }

    protected void end() {
       
    }

    protected void interrupted() {
       
    }
    
}
