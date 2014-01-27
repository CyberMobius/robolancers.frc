/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ImageProcStandard;

/**
 *
 * @author RoboLancers
 */
public class Camera extends Subsystem{

    public Camera() {
        super("Camera");
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new ImageProcStandard());
    }
    
}
