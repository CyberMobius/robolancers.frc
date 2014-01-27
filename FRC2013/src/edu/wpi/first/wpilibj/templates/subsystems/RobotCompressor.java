/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.robotcompressor.RegulateCompressor;

public class RobotCompressor extends Subsystem {
    public static String compressorStatus;
    Relay compressor;
    
    public RobotCompressor(){
        super("Compressor");
        compressor = new Relay(RobotMap.COMPRESSOR);
        compressor.setDirection(Relay.Direction.kForward);
        compressor.set(Relay.Value.kOff);
        compressorStatus = "Off";
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RegulateCompressor());
    }
    
    
    public void compressor(){
            compressor.set(Relay.Value.kForward);
            compressorStatus = "On";
        
        /*if(!compressor.getPressureSwitchValue()){
            compressor.setRelayValue(Relay.Value.kForward);
            compressor.start();
            compressorStatus = "On";
        }else{
//            compressor.setRelayValue(Relay.Value.kOff);
//            compressor.stop();
//            compressorStatus = "Off";
        }*/
    }
}
