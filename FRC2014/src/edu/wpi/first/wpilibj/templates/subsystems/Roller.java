/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Roller.RegulateRoller;

/**
 *
 * @author RoboLancers
 */
public class Roller extends Subsystem{
    
    public SpeedController rollerMotor;
    public static DoubleSolenoid pivotArmPistons;
    public static boolean isExtended = false;
    //public LEDs leds = new LEDs(DigitalModule.getInstance(1) , 0, 40);
            
    protected void initDefaultCommand() { 
        setDefaultCommand(new RegulateRoller());
    }
    
    public Roller(){
        super("Roller");
        
        rollerMotor = new Victor(RobotMap.ROLLER_MOTOR);
        pivotArmPistons = new DoubleSolenoid(RobotMap.ROLL_FOR,RobotMap.ROLL_REV);
        
        pivotArmPistons.set(Value.kReverse); //Default retracted
    }
    
    public void regulate(){
        if(OI.maniStick.getRawButton(1))rollerMotor.set(-1.0); //forward
        else if(OI.maniStick.getRawButton(2))rollerMotor.set(1.0); //reverse
        else rollerMotor.set(0.0);
    }
    
}
