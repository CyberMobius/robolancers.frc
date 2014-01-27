package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //PWM Ports on Digital Sidecar 1
    public static final int 
            MOTOR_DRIVE_RIGHT = 1,
            MOTOR_DRIVE_LEFT = 2, 
            MOTOR_HAMMER = 3,
            MOTOR_CONVEYOR = 5,
            MOTOR_ROLLER = 6, 
            MOTOR_SHOOTER_UPPER = 7,
            MOTOR_FINGER = 8,
            MOTOR_YAW = 9;
    
    //Relay Ports on Digital Sidecar 1
    public static final int
            RELAY_LED_RED = 1,
            RELAY_LED_BLUE = 2;
    
    //GPIO Ports on Digital Sidecar 1
    public static final int 
            ENCODER_A_SHOOTER = 1,
            ENCODER_B_SHOOTER = 2,
            PHOTO_SENSOR_LEFT = 3,
            PHOTO_SENSOR_RIGHT = 4,
            LIMIT_FINGER = 5;
    
    //Ports on Analog Breakout
    public static final int          
            GYRO_YAW = 2;
    
    //Basketball hoop heights from ground (in inches)
    public static final double 
            HOOP_TOP_HEIGHT = 98,
            HOOP_MID_HEIGHT = 61,
            HOOP_BOT_HEIGHT = 21;
}