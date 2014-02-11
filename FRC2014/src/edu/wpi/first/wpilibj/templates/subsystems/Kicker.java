/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author RoboLancers
 */
public class Kicker extends Subsystem{

    public static DoubleSolenoid kickerSolenoids;
    public static boolean isExtended = false;
    
    protected void initDefaultCommand() { }
    
    public Kicker(){
        super("Kicker");
        
        kickerSolenoids = new DoubleSolenoid(5,6);
        kickerSolenoids.set(DoubleSolenoid.Value.kReverse);
    }
    
}
