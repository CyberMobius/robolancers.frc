/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.camera.MoveCameraWithJoystick;

public class Camera extends Subsystem {
    public static Servo yawServo, tiltServo;
    public static double yaw, tilt;
    public Relay leds;
    
    public Camera(){
        super("Camera");
        leds = new Relay(RobotMap.CAMERA_LEDS);
        leds.setDirection(Relay.Direction.kForward);
        leds.set(Relay.Value.kOff);
        yawServo = new Servo(RobotMap.YAW_SERVO);
        tiltServo = new Servo(RobotMap.TILT_SERVO);
        yaw = 0.5;
        tilt = 0.5;
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new MoveCameraWithJoystick());
    }
    
    public void moveCameraWithJoystick(){
        yawServo.set(yaw);
        tiltServo.set(tilt);
    }
    
    public void reset(){
        yaw = 0.5;
        tilt = 0.5;
    }
}
