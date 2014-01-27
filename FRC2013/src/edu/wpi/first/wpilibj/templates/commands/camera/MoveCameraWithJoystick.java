/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.camera;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Camera;

/**
 *
 * @author RoboLancers
 */
public class MoveCameraWithJoystick extends CommandBase {
    
    public MoveCameraWithJoystick() {
        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Math.abs(OI.manipulatorStick.getX()) > .1){
            Camera.yaw += OI.manipulatorStick.getX()/50;
            if(Camera.yaw > 1){
                Camera.yaw = 1;
            }else if(Camera.yaw < 0){
                Camera.yaw = 0;
            }
        }
        if(Math.abs(OI.manipulatorStick.getY()) > .1){
            Camera.tilt += OI.manipulatorStick.getY()/50;
            if(Camera.tilt > 1){
                Camera.tilt = 1;
            }else if(Camera.tilt < 0){
                Camera.tilt = 0;
            }
        }
        camera.moveCameraWithJoystick();
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
