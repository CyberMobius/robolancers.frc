/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Ramp.ExtendRamp;

/**
 * @author RoboLancers
 */

public class Ramp extends Subsystem{
    
    public SpeedController rampMotor;
    public DigitalInput rampLimitSwitch;

    protected void initDefaultCommand() {
        setDefaultCommand(new ExtendRamp());
    }
    
    public Ramp(){
        super("Ramp");
        
        rampMotor = new Victor(RobotMap.RAMP_MOTOR);
        rampLimitSwitch = new DigitalInput(RobotMap.RAMP_LIMIT_SWITCH);
    }
    
    public void extend(){
        rampMotor.set(0.2); //set the motor to 20% power
    }
}
