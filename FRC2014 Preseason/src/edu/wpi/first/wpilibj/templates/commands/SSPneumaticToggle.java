/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Armond
 */
public class SSPneumaticToggle extends CommandBase{
    DoubleSolenoid ss;
    boolean hasFinished = false;
    
    public SSPneumaticToggle(DoubleSolenoid ss){
        this.ss = ss;
        requires(driveTrain); 
    }
    
    public void initialize(){}
    
    public void execute(){
        if(isHighGear()){ 
            RobotMap.HIGH_GEAR = false;
            RobotMap.LOW_GEAR = true;
            
            setGearType(RobotMap.TYPE_LOW_GEAR);
        }else{
            RobotMap.HIGH_GEAR = true;
            RobotMap.LOW_GEAR = false;
            
            setGearType(RobotMap.TYPE_HIGH_GEAR);
        }
        
        hasFinished = true;
    }
    
    public void setGearType(int type){
        if(type == RobotMap.TYPE_HIGH_GEAR){
            ss.set(Value.kForward);
        }
        if(type == RobotMap.TYPE_LOW_GEAR){
            ss.set(Value.kReverse);
        }
    }
        
    protected boolean isFinished(){ return hasFinished; }
    
    protected void end(){}
            
    protected void interrupted(){}
    
    public boolean isHighGear(){ return RobotMap.HIGH_GEAR; }
    
}
