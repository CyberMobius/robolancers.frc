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
public class RegulateRamp extends CommandBase{
    
    public RegulateRamp(){
        requires(ramp);
    }
    protected void initialize() { }

    protected void execute() { 
        ramp.regulate();
    }

    protected boolean isFinished() { return false; }

    protected void end() { }

    protected void interrupted() { }
    
}
