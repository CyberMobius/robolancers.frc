/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.Ramp;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class RampUp extends CommandBase{

    
    public RampUp(){
        requires(ramp);
    }
    
    protected void initialize(){}

    protected void execute() {
        ramp.rampMotor.set(0.25);
    }

    protected boolean isFinished(){
        return ramp.potentiometer.get() > 1.2;
    }

    protected void end() {
        ramp.rampMotor.set(0.0);
    }

    protected void interrupted() {}
    
}
