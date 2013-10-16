/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.climber.AllOff;

public class Climber extends Subsystem {
    DoubleSolenoid supplyValve, shortValve, longValve;
    public static String supplyStatus, shortStatus, longStatus;
    
    public Climber(){
        super("Climber");
        supplyValve = new DoubleSolenoid(RobotMap.SUPPLY_TO_LONG, RobotMap.SUPPLY_TO_SHORT);
        shortValve = new DoubleSolenoid(RobotMap.SHORT_FORWARD, RobotMap.SHORT_REVERSE);
        longValve = new DoubleSolenoid(RobotMap.LONG_FORWARD, RobotMap.LONG_REVERSE);
        supplyValve.set(DoubleSolenoid.Value.kOff);
        shortValve.set(DoubleSolenoid.Value.kOff);
        longValve.set(DoubleSolenoid.Value.kOff);
        supplyStatus = "Off";
        shortStatus = "Off";
        longStatus = "Off";
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new AllOff());
    }
    
    public void armExtend(){
        longStatus = "Long pistons extending";
        longValve.set(DoubleSolenoid.Value.kForward);
    }
    
    public void armRetract(){
        longStatus = "Long pistons retracting";
        longValve.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void legsExtend(){
        shortStatus = "Short pistons extending";
        shortValve.set(DoubleSolenoid.Value.kForward);
    }
    
    public void legsRetract(){
        shortStatus = "Short pistons retracting";
        shortValve.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void supplyToLong(){
        supplyStatus = "Air flowing to long pistons";
        supplyValve.set(DoubleSolenoid.Value.kForward);
    }
    
    public void supplyToShort(){
        supplyStatus = "Air flowing to short pistons";
        supplyValve.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void allDoNothing(){
        supplyStatus = "No air flowing";
        longStatus = "No air flowing";
        shortStatus = "No air flowing";
        longValve.set(DoubleSolenoid.Value.kOff);
        shortValve.set(DoubleSolenoid.Value.kOff);
        supplyValve.set(DoubleSolenoid.Value.kOff);
    }
}
