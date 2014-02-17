package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 
    //SETS ALL PORT VALUES
    
    //Run Mode
    public static final boolean DEBUG_MODE = true;
    
    //Drive Type
    public static final boolean ARCADE_DRIVE = false;
    public static final boolean TANK_DRIVE = false;
    public static final boolean RC_DRIVE = true;
    
    //Motor Values
    public static final int LEFT_MOTOR_FRONT = 4; //3
    public static final int LEFT_MOTOR_REAR = 3; //4
    public static final int RIGHT_MOTOR_FRONT = 9; //8
    public static final int RIGHT_MOTOR_REAR = 8; //9
    public static final int ROLLER_MOTOR = 6;
    public static final int RAMP_MOTOR = 7;
    public static final int LEFT_FLAP_MOTOR = 1;
    public static final int RIGHT_FLAP_MOTOR = 2;

    //Compressor Ports
    public static final int PRESSURE_SWITCH = 1;
    public static final int SPIKE_PORT = 8;
    
    public static final int KICK_FOR = 1;
    public static final int KICK_REV = 2;
    public static final int ROLL_FOR = 3;
    public static final int ROLL_REV = 4;
    public static final int SS_FOR = 5;
    public static final int SS_REV = 6;
    
    public static final int POTENTIOMETER_PORT = 2;
    
}
