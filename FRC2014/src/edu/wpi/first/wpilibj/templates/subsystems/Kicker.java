/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.Ramp.ExtendRamp;

/**
 *
 * @author RoboLancers
 */
public class Kicker extends Subsystem{

    public DoubleSolenoid kickerSolenoids;
    
    protected void initDefaultCommand() {
        setDefaultCommand(new ExtendRamp());
    }
    
    public Kicker(){
        super("Kicker");
        
        kickerSolenoids = new DoubleSolenoid(1,2);
    }
    
}
