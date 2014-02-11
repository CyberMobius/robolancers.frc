/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.templates.commands.Camera.ImageProcStandard;

/**
 *
 * @author RoboLancers
 */
public class Camera extends Subsystem{

    public static AxisCamera axisCamera;
    
    public Camera() {
        super("Camera");
       
        axisCamera = AxisCamera.getInstance();
    }

    protected void initDefaultCommand() {
       //setDefaultCommand(new ImageProcStandard());
    }
    
}
