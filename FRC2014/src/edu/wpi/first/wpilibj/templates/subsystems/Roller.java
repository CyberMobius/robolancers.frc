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

/**
 *
 * @author RoboLancers
 */
public class Roller extends Subsystem{
    
    public SpeedController rollerMotor;
    public static DoubleSolenoid pivotArmPistons;
    public static boolean isExtended = false;
            
    protected void initDefaultCommand() { }
    
    public Roller(){
        super("Roller");
        
        rollerMotor = new Victor(RobotMap.ROLLER_MOTOR);
        pivotArmPistons = new DoubleSolenoid(3,4);
        
        pivotArmPistons.set(Value.kReverse); //Default retracted
    }
    
    
}
