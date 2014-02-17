/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.Roller;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class RegulateRoller extends CommandBase{

    private boolean hasFinished;
    
    public RegulateRoller(){
        requires(roller);
    }
    protected void initialize() { }

    protected void execute() { 
        roller.regulate();
    }

    protected boolean isFinished() { return false; }

    protected void end() { }

    protected void interrupted() { }
    
}