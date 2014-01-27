/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.RegulateCompressor;

/**
 *
 * @author Armond
 */
public class RobotCompressor extends Subsystem{

    private Compressor compressor;
    
    public RobotCompressor(){
        super("Robot Compressor");
        compressor = new Compressor(RobotMap.PRESSURE_SWITCH, RobotMap.SPIKE_PORT);
        compressor.setRelayValue(Relay.Value.kOn);
        compressor.start();
                
    }
    
    public void compressor(){
        
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new RegulateCompressor());
    }
    
    public void runCompressor(){
        if(!compressor.getPressureSwitchValue()){
            compressor.start(); //start compressor if not enough air in tank
        }else{
            compressor.stop(); //stop compressor if we have over 60PSI
        }
    }
    
}
