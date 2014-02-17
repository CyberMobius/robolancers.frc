/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.flaps;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class ExtendFlaps extends CommandBase{

    private boolean hasFinished;
    
    public ExtendFlaps(){
        requires(flaps);
        
    }
    protected void initialize(){
    }

    protected void execute() {
        flaps.regulation();
    }

    protected boolean isFinished() { return false; }

    protected void end(){
    
    }

    protected void interrupted() {
    
    }
    
}
