/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.custom.SendablePIDController;
import edu.wpi.first.wpilibj.templates.commands.shooter.FireMode;

/**
 *
 * @author Eric
 */
public class Shooter extends Subsystem {
    //For every 4.67 rotations of the motor, the encoder spins 1 rotation

    public static final double Kp = 0.0,
            Ki = 0.001,
            Kd = 0.0,
            SHOOTER_WHEEL_CIRCUMFERENCE = 6.0 * Math.PI,
            SHOOTER_PITCH_ANGLE = 1,
            SHOOTER_VELOCITY_TO_BALL_VELOCITY = 1, //TODO - Find this
            BALL_VELOCITY_TO_SHOOTER_VELOCITY = 1, //TODO - Find this
            ENCODER_VELOCITY_TO_SHOOTER_VELOCITY = 4.67;
    public static final double SHOOTER_MAX_VELOCITY = 100; //TO DO - Find this //Max velocity Shooter will spin at 
    private static Jaguar shooter;
    public static Encoder encoderShooter; //Change to private later, public static to view in dashboard
    public static SendablePIDController shooterPID; //Change to PIDController after changing constants
    public static double distanceToHoops, velocitySetpoint;

    public Shooter() {
        super("Shooter");

        shooter = new Jaguar(RobotMap.MOTOR_SHOOTER_UPPER);

        encoderShooter = new Encoder(RobotMap.ENCODER_A_SHOOTER, RobotMap.ENCODER_B_SHOOTER);
        encoderShooter.setDistancePerPulse(8.0 / 360.0); //8 rotations of wheel per 1 rotation of encoder, 360 pulse
        encoderShooter.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        encoderShooter.start();

        shooterPID = new SendablePIDController(Kp, Ki, Kd, encoderShooter, shooter);

        distanceToHoops = 0;
        velocitySetpoint = 75;
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new FireMode());
    }

    public void fireBalls() {
        shooter.set(-1);
    }

    public static void fireBallsWithAnalog(double value) {
        shooter.set(value);
    }

    public static void fireBallsWithPID(double setpoint) {
        shooterPID.setSetpoint(-setpoint);
        shooterPID.enable();
    }

    public static void stopMoving() {
        shooter.set(0);
        encoderShooter.reset();
        shooterPID.reset();
        shooterPID.disable();
    }

    /*
     * Calculate velocity needed to fire the shooter at to hit the top
     * basketball hoop. This method first calculates the velocity a projectile
     * needs to fire at and then converts that to the velocity that the shooter
     * needs to spin at to achieve that projectile velocity
     *
     * @param distanceToHoops The distance from robot to the hoops calculated by
     * the Axis Camera
     */
    public static double calculateVelocitySetpoint(double distanceToHoops) {
        double desiredVelocitySetpoint = 0;

        if (distanceToHoops != 0) {
            double xDist = distanceToHoops;
            double yDist = RobotMap.HOOP_TOP_HEIGHT;
            double angleInDegrees = SHOOTER_PITCH_ANGLE;
            double angleInRadians = Math.PI * angleInDegrees / 180; //In Randians

            double numerator = 9.8 * MathUtils.pow(xDist, 2);
            double denominator = 2 * MathUtils.pow(((Math.cos(angleInRadians))), 2) * (xDist * ((Math.tan(angleInRadians))) - yDist);

            double underSqrt = numerator / denominator;

            double velocityPlus = Math.sqrt(underSqrt);
            double velocityMinus = -Math.sqrt(underSqrt);

            if (velocityMinus < 0) {
                desiredVelocitySetpoint = velocityPlus;
            } else if (velocityPlus < 0) {
                desiredVelocitySetpoint = velocityMinus;
            }
        }

        return desiredVelocitySetpoint * BALL_VELOCITY_TO_SHOOTER_VELOCITY;
    }

    public static double getShooterVelocity() { //UNEEDED NOW
        return encoderShooter.getRate() * ENCODER_VELOCITY_TO_SHOOTER_VELOCITY;
    }
}
