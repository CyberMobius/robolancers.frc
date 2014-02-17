/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author RoboLancers
 */
public class AutoDeadRecon extends CommandBase{

    private boolean hasFinished;
    private long timer = 4000; //4 seconds initial timer
    private long startTime;
    private int state;
    
    public AutoDeadRecon(){
        requires(driveTrain);
        requires(kicker);
    }
    
    protected void initialize() {
        hasFinished = false;
        startTime = System.currentTimeMillis();
        state = 1;
        
    } 

    protected void execute() {
       
        long elapsedTime = System.currentTimeMillis() - startTime;
        
        if(state == 1){
            if(elapsedTime <= timer){
                driveTrain.driveStandard.arcadeDrive(100, 0); //drive full speed striaght
                kicker.kickerSolenoids.set(DoubleSolenoid.Value.kReverse); //draw back the kicker
                kicker.isExtended = false;
            }else{
                driveTrain.driveStandard.arcadeDrive(0, 0);
                startTime = System.currentTimeMillis(); //re instate the start timer
                timer = 2000; //second state timer 2 seconds
                state = 2;
            }
        }
        else if(state == 2){
            if(elapsedTime <= timer){
                driveTrain.driveStandard.arcadeDrive(0, 25); //turn left at 25%
            }else{
                driveTrain.driveStandard.arcadeDrive(0, 0);
                state = 3;
            }
        }
        else if(state == 3){
            kicker.kickerSolenoids.set(DoubleSolenoid.Value.kForward); //shoot the ball
            kicker.isExtended = true;
            hasFinished = true;
        }
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
        driveTrain.driveStandard.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    
    }
    
}
