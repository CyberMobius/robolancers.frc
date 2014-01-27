/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.DriveWithJoystick;

public class DriveTrain extends Subsystem {
    RobotDrive drive;
    SpeedController leftMotor, rightMotor;
    public static String driveDirection;
    public static double x, y;
    
    public DriveTrain(){
        super("Drive Train");
        driveDirection = "shooterForawrd";
        leftMotor = new Victor(RobotMap.LEFT_MOTOR);
        rightMotor = new Victor(RobotMap.RIGHT_MOTOR);
        drive = new RobotDrive(leftMotor, rightMotor);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void moveWithJoystick(double moveValue, double rotateValue){
        if(OI.driveStick.getRawAxis(3) > 0)
            driveDirection = "shooterForward";
        if(OI.driveStick.getRawAxis(3) < 0)
            driveDirection = "climberForward";
        y = -moveValue*Math.ceil(OI.driveStick.getRawAxis(3));
        x = rotateValue*Math.ceil(OI.driveStick.getRawAxis(3));
        drive.arcadeDrive(y,x);
    }
}
