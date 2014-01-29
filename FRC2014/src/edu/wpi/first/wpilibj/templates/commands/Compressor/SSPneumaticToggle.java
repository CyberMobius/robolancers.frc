/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Compressor;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Armond
 */
public class SSPneumaticToggle extends CommandBase{
    DoubleSolenoid ss;
    private boolean hasFinished = false;
    
    public SSPneumaticToggle(DoubleSolenoid ss){
        this.ss = ss;
        requires(driveTrain); 
    }
    
    public void initialize(){}
    
    public void execute(){
        if(isHighGear()){ 
            RobotMap.HIGH_GEAR = false;
            setGearType();
        }else{            
            RobotMap.HIGH_GEAR = true;
            setGearType();
        }
        SmartDashboard.putBoolean("Sonic Shifter", isHighGear());
        hasFinished = true;
    }
    
    public void setGearType(){
        if(isHighGear()){
            ss.set(Value.kForward);
        }else{
            ss.set(Value.kReverse);
        }
    }
        
    protected boolean isFinished(){ return hasFinished; }
    
    protected void end(){}
            
    protected void interrupted(){}
    
    public boolean isHighGear(){ return RobotMap.HIGH_GEAR; }
    
}