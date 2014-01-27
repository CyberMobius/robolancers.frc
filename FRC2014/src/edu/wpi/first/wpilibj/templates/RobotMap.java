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
    
    //Joystick Type
    public static final boolean MONO_JOYSTICK = false;
    public static final boolean DUAL_JOYSTICK = false;
    public static final boolean WHEEL = false;
    public static final boolean GAME_PAD = true;
    
    //Drive Type
    public static final boolean ARCADE_DRIVE = false;
    public static final boolean TANK_DRIVE = false;
    public static final boolean RC_DRIVE = true;
    
    //Chassis Type
    public static final boolean SLIDE_DRIVE = false;
    //Motor Values
    public static final int LEFT_MOTOR_FRONT = 1;
    public static final int LEFT_MOTOR_REAR = 4;
    public static final int RIGHT_MOTOR_FRONT = 2;
    public static final int RIGHT_MOTOR_REAR = 3;
    public static final int SLIDER_MOTOR_1 = 5;
    public static final int SLIDER_MOTOR_2 = 6;
    
    //Drive Type
    public static boolean FORWARD = false;
    public static boolean REVERSE = false;
    
    //
    public static boolean HIGH_GEAR = false;
    //Compressor Ports
    public static final int PRESSURE_SWITCH = 14;
    public static final int SPIKE_PORT = 1;
}
