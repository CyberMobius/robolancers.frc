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
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Roller.PivotArm;

/**
 *
 * @author RoboLancers
 */
public class Roller extends Subsystem{
    
    public SpeedController rollerMotor;
    public static DoubleSolenoid pivotArmPistons;
            
    protected void initDefaultCommand() { }
    
    public Roller(){
        super("Roller");
        
        rollerMotor = new Victor(RobotMap.ROLLER_MOTOR);
        pivotArmPistons = new DoubleSolenoid(1,2); //TODO: get DS Module Numbers?
        
        pivotArmPistons.set(Value.kOff); //Default Off 
    }
    
    
}
