/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Hopper extends Subsystem {
    SpeedController dumper, feeder;
    Servo rampServo;
    
    public Hopper(){
        super("Hopper");
        rampServo = new Servo(RobotMap.RAMP_SERVO);
        dumper = new Victor(RobotMap.DUMPER_MOTOR);
        feeder = new Victor(RobotMap.FEEDER_MOTOR);
    }
    
    public void initDefaultCommand() {}
    
    public void rampOut(){
        rampServo.set(.4);
    }
    
    public void rampClosed(){
        rampServo.set(0);
    }
}
