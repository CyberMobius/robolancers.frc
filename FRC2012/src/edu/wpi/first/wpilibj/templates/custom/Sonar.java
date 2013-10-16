/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.custom;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author Eric Lam 
 * 
 * Accepts sonar properties including channel and scaling factor and converts 
 * them into real world measurements
 */

public class Sonar extends AnalogChannel {
    
    private double scaleFactorCm;
    private double scaleFactorIn;
    
    /**Create a new instance of a sonar
     *
     * @param channel the channel the sonar is plugged into on the Analog Breakout
     * @param scaleFactor the scaling factor used to convert voltage to real world measurements (mV/cm)
     */
    
    public Sonar (int channel, double scaleFactorCm) {
        super(channel);
        
        this.scaleFactorCm = scaleFactorCm;
        this.scaleFactorIn = scaleFactorCm*2.54; //Converts scale factor that is in units of mV/cm into mV/in
    }
    
    //Rewrite code so that scaling factor in units of mV/cm can be used
    //This code here uses a scaling factor assumed to be in mV/in
    
    public double getIn() { //Gets distance of ultrasonic in inches
        
        double in;
        
        in = (getVoltage()*1000)/scaleFactorIn; //Converts voltage into millivolts and then into inches
        
        return in;
    }
    
    public double getAvgIn () {
        
        double in;
        
        in = (getAverageVoltage()*1000)/scaleFactorIn; //Converts average voltage into millivolts and then into inches
                
        return in;
    }   
    
    public double getCm() {
        
        double cm;
        
        cm = (getVoltage()*1000)/scaleFactorCm; //Coverts voltage into millivolts and then into centimeters
        
        return cm;
    }
    
    public double getAvgCm () {
        
        double cm;
        
        cm = (getAverageVoltage()*1000)/scaleFactorCm; //Converts voltage into millivolts and then into centimeters
        
        return cm;
    }
    
}
