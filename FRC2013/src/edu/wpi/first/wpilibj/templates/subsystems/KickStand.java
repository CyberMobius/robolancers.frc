/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.kickstand.KickerDoNothing;

public class KickStand extends Subsystem {
    SpeedController kicker;
    
    public KickStand(){
        super("Kick Stand");
        kicker = new Talon(RobotMap.KICKSTAND);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new KickerDoNothing());
    }
    
    public void kickerDoNothing(){
        kicker.set(0);
    }
    
    public void kickerExtend(){
        kicker.set(1);
    }
    
    public void kickerRetract(){
        kicker.set(-1);
    }
}
