/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Armond
 */
public class RegulateCompressor extends CommandBase{

    public RegulateCompressor(){
        requires(compressor);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        CommandBase.compressor.runCompressor();
    }

    protected boolean isFinished() { return false; }

    protected void end() {}

    protected void interrupted() {}
    
}
