/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.commands.drivetrain;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

public class DriveWithJoystick extends CommandBase {
    private double moveValue, rotateValue;
    
    public DriveWithJoystick() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Math.abs(OI.driveStick.getX()) > .02){
            rotateValue = OI.driveStick.getX();
        }else{
            rotateValue = 0;
        }
        if(Math.abs(OI.driveStick.getY()) > .02){
            moveValue = OI.driveStick.getY();
        }else{
            moveValue = 0;
        }
        driveTrain.moveWithJoystick(moveValue, rotateValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
