/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author RoboLancers
 */
public class Flaps extends Subsystem{

    public SpeedController leftFlapMotor, rightFlapMotor;
    
    protected void initDefaultCommand() {
    
    }
    
    public Flaps(){
        super("Flaps");
        
        leftFlapMotor = new Victor(RobotMap.LEFT_FLAP_MOTOR);
        rightFlapMotor = new Victor(RobotMap.RIGHT_FLAP_MOTOR);
    }
    
}
