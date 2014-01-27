/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.DriveWithJoystick;

/**
 *
 * @author Eric
 */
public class DriveTrain extends Subsystem {

    private static final double Kp = 0.5, //Adjust this
            Ki = 0,
            Kd = 0;
    private static final boolean TRACKED = false,
            NOT_TRACKED = true;
    public static RobotDrive drive; //Used by Hybrid Kinect also
    public static Jaguar driveRt, driveLft; //Used by Hyrid Kinect also
    public static DigitalInput leftPhoto = new DigitalInput(RobotMap.PHOTO_SENSOR_LEFT), rightPhoto = new DigitalInput(RobotMap.PHOTO_SENSOR_RIGHT); //Photosensors.

    public DriveTrain() {
        super("Drive Train");

        driveRt = new Jaguar(RobotMap.MOTOR_DRIVE_RIGHT);
        driveLft = new Jaguar(RobotMap.MOTOR_DRIVE_LEFT);

        drive = new RobotDrive(driveRt, driveLft);
        drive.setSafetyEnabled(false);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }

    public void arcadeDrive(double moveValue, double rotateValue) {
        drive.arcadeDrive(moveValue, rotateValue);
    }
    
    public static void tankDrive(double leftValue, double rightValue) {
        drive.tankDrive(leftValue, rightValue);
    }

    public void lineTrack() {
        boolean leftTape = leftPhoto.get(); //False for on tape, true for off tape.
        boolean counter = false;

        //When tape not tracked, turn left.
        //When tape first gets tracked, turn right
        //When you get off the tape, turn left again
        //Repeat.


        //While counter is false, tape hasn't been tracked yet
        if (!counter) {
            if (leftTape == TRACKED) { //So when you track it, switch the counter to true indicating to go in the other direction.
                counter = true;
            } else { //However, when you don't track it, turn left
                DriveTrain.drive.arcadeDrive(0.4, -0.45);
            }
        }

        //While counter is true, tape has been tracked yet
        if (counter) {
            if (leftTape == NOT_TRACKED) { //So when you un-track it, switch the counter to false indicating to go in the other direction.
                counter = true;
            } else { //However, when you do track it, turn right
                DriveTrain.drive.arcadeDrive(0.4, 0.45);
            }
        }
    }
}
