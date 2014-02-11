/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.Roller;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class ActivateRoller extends CommandBase{

    private boolean hasFinished;
    
    public ActivateRoller(){
        requires(roller);
        roller.rollerMotor.set(0); //initially zero power
    }
    protected void initialize(){
        hasFinished = false;
    }

    protected void execute() {
        if(!OI.maniStick.getRawButton(1)) hasFinished = true; //If not pressing, end the command
        roller.rollerMotor.set(1.00); //100% power to the motor
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
        roller.rollerMotor.set(0); //set the motor to 0 if it is the end of the command
    }

    protected void interrupted() {
    
    }
    
}
