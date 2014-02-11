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
public class ExtendRamp extends CommandBase{

    private boolean hasFinished;
    
    protected void initialize() { }

    protected void execute() { 
        //CommandBase.ramp.extend();
    }

    protected boolean isFinished() { return hasFinished; }

    protected void end() { }

    protected void interrupted() { }
    
}
