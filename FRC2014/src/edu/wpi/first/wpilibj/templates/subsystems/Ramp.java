/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * @author RoboLancers
 */

public class Ramp extends Subsystem{
    
    public SpeedController rampMotor;
    public AnalogPotentiometer potentiometer;

    protected void initDefaultCommand() {
        //setDefaultCommand(new RegulateRamp());
    }
    
    public Ramp(){
        super("Ramp");
        
        rampMotor = new Victor(RobotMap.RAMP_MOTOR);
        potentiometer = new AnalogPotentiometer(RobotMap.POTENTIOMETER_PORT);
    }
    
    public void regulate(){ //not used unless varaible ramp
        
        if(OI.maniStick.getRawButton(11)){
            rampMotor.set(0.25);
        }
        else if(OI.maniStick.getRawButton(10)){
            rampMotor.set(-0.25);
        }else{
            rampMotor.set(0.0);
        }
    }
    
    public String getRampStatus(){
        if(potentiometer.get() < 0.2) return "Low";
        else if(potentiometer.get() > 0.45 && potentiometer.get() < 0.55) return "Mid";
        else if( potentiometer.get() > 0.90) return "High";
        else return "??? OVER CLOCK ???";
    }
}
