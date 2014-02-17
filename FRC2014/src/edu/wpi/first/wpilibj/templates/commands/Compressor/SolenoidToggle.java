/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.Compressor;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class SolenoidToggle extends CommandBase {
    private Subsystem subsystem;
    private DoubleSolenoid ds;
    private boolean state;
    private boolean hasFinished = false;
    
    public SolenoidToggle(Subsystem subsystem, DoubleSolenoid ds, boolean state) {
        this.subsystem = subsystem;
        this.ds = ds;
        this.state = state;
        requires(subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        hasFinished = false;
        if(ds.get() == DoubleSolenoid.Value.kForward){
            ds.set(DoubleSolenoid.Value.kReverse);
        }else{
            ds.set(DoubleSolenoid.Value.kForward);
        }
        state = !state;
        if(ds.equals(driveTrain.sonicShifterPair)) driveTrain.isHighGear = state;
        if(ds.equals(kicker.kickerSolenoids)) kicker.isExtended = state;
        if(ds.equals(roller.pivotArmPistons)) roller.isExtended = state;
        hasFinished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hasFinished;
    }

    // Called once after isFinished returns true
    protected void end() { }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { }
    
}
