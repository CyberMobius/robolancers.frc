/*
 * FRC 2013 Java Code
 * Made by Steven Duong (272)
 * Team 0321 - Robolancers
 */
package edu.wpi.first.wpilibj.templates;

public class RobotMap {
    //Analog
    public static final int GYRO = 1;
    
    //Digital Output
    public static final int LEFT_MOTOR = 1;//Victor
    public static final int RIGHT_MOTOR = 2;//Victor
    public static final int SHOOTER_MOTOR = 3;//Talon
    public static final int KICKSTAND = 4;//Talon
    public static final int DUMPER_MOTOR = 5;//Victor
    public static final int FEEDER_MOTOR = 6;//Victor
    
    public static final int RAMP_SERVO = 8;
    public static final int YAW_SERVO = 9;
    public static final int TILT_SERVO = 10;
    
    //Digital Input
    public static final int SHOOTER_ENCODER_A = 1;
    public static final int SHOOTER_ENCODER_B = 2;
    public static final int PRESSURE_SWITCH = 3;
    
    //Relay
    public static final int CAMERA_LEDS = 1;
    public static final int COMPRESSOR = 2;
    
    //Solenoid
    public static final int SUPPLY_TO_LONG = 1;
    public static final int SUPPLY_TO_SHORT = 2;
    public static final int SHORT_FORWARD = 3;
    public static final int SHORT_REVERSE = 4;
    public static final int LONG_FORWARD = 5;
    public static final int LONG_REVERSE = 6;
}
