/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.camera;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Eric
 */
public class WriteRawImage extends CommandBase {

    private static AxisCamera camera;
    private static int count = 1;
    private static boolean isDone;

    public WriteRawImage() {
        camera = AxisCamera.getInstance();
    }

    protected void initialize() {
        isDone = false;
        
        ColorImage image = null;
        try {
            image = camera.getImage();
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        
        if (image != null) {
            try {
                image.write(count + "r.png");
                System.out.println ("Image: " + count + " was written");
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            }
        }
        
        isDone = true;
        
        count++;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
