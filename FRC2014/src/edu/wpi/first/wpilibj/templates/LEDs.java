package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.I2C;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author RoboLancers
 */
public class LEDs extends I2C{
    public int LEDAmount;
    
    public LEDs(DigitalModule dm, int deviceAddress, int LEDAmount){
        super(dm, deviceAddress);
        
        this.LEDAmount = LEDAmount;
    }
    
    public void burstColors(){
        
    }
    
    public void orgasmic(){
        for(int i = 0; i < LEDAmount; i++){
            
        }
    }
    
    public void induceSeizure(){
    
    }
    public void stop(){
    
    }
    
}
