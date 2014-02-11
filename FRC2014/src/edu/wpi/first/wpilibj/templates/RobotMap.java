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
    public static final boolean DEBUG_MODE = false;
    
    //Drive Type
    public static final boolean ARCADE_DRIVE = false;
    public static final boolean TANK_DRIVE = false;
    public static final boolean RC_DRIVE = true;
    
    //Motor Values
    public static final int LEFT_MOTOR_FRONT = 1;
    public static final int LEFT_MOTOR_REAR = 2;
    public static final int RIGHT_MOTOR_FRONT = 3;
    public static final int RIGHT_MOTOR_REAR = 4;
    public static final int ROLLER_MOTOR = 5;
    public static final int RAMP_MOTOR = 6;
    public static final int LEFT_FLAP_MOTOR = 7;
    public static final int RIGHT_FLAP_MOTOR = 8;

    
    
    //Drive Type(Wheel Based Drive)
    public static boolean FORWARD = false;
    public static boolean REVERSE = false;
    
    //Sonic Shifter
    public static boolean HIGH_GEAR = false;
    public static boolean KICKER_EXTENDED = false;
    public static boolean ARM_EXTENDED = false;
    
    //Compressor Ports
    public static final int PRESSURE_SWITCH = 14;
    public static final int SPIKE_PORT = 1;
    
    //Miscelaneous Digital Input
    public static final int RAMP_LIMIT_SWITCH = 1; //TODO: Get val
}
