/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.Camera;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */

public class ImageProcStandard extends CommandBase {
    boolean hasFinished;
    //public AxisCamera axisCamera;
    
    protected void initialize() {
     // axisCamera = AxisCamera.getInstance(); 
    }

    protected void execute() {
        
    }

    protected boolean isFinished() { return true; }

    protected void end() { }

    protected void interrupted() { }
    
}
