/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.kinect;

import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 *
 * @author Eric
 */
public class HybridKinect {

    private final int HEAD_RIGHT = 1,
            HEAD_LEFT = 2,
            LEG_RIGHT_RIGHT = 3,
            LEG_LEFT_LEFT = 4,
            LEG_RIGHT_FORWARD = 5,
            LEG_RIGHT_BACKWARD = 6,
            LEG_LEFT_FORWARD = 7,
            LEG_LEFT_BACKWARD = 8;
    private KinectStick leftArm;
    private KinectStick rightArm;

    public HybridKinect() {
        leftArm = OI.leftArm;
        rightArm = OI.rightArm;
    }

    public void start() {
        driveControlOn();
        rollerControlOn();
        conveyorControlOn();
        fingerControlOn();
        hammerControlOn();
        shooterControlOn();
    }

    public void end() {
        driveControlOff();
        rollerControlOff();
        conveyorControlOff();
        fingerControlOff();
        hammerControlOff();
        shooterControlOff();
    }

    private void driveControlOn() {
        double leftValue = 0, rightValue = 0;

        if (!isShootingMode()) {
            leftValue = leftArm.getY();
            rightValue = rightArm.getY();
        }

        DriveTrain.tankDrive(leftValue, rightValue);
    }

    private void driveControlOff() {
        DriveTrain.tankDrive(0, 0);
    }

    private void rollerControlOn() {
        if (!isShootingMode()) {
            if (leftArm.getRawButton(LEG_RIGHT_RIGHT)) {
                Roller.pullBallsIn();
            } else {
                Roller.stopMoving();
            }
        }
    }

    private void rollerControlOff() {
        Roller.stopMoving();
    }

    private void conveyorControlOn() {
        if (leftArm.getRawButton(LEG_LEFT_FORWARD)) {
            Conveyor.conveyorUp();
        } else if (leftArm.getRawButton(LEG_LEFT_BACKWARD)) {
            Conveyor.conveyorDown();
        } else {
            Conveyor.stopMoving();
        }
    }

    private void conveyorControlOff() {
        Conveyor.stopMoving();
    }

    private void fingerControlOn() {
        if (isShootingMode()) {
            Finger.moveFingerWithJoystick(rightArm.getY());
        } else {
            Finger.stopMoving();
        }
    }

    private void fingerControlOff() {
        Finger.stopMoving();
    }

    private void hammerControlOn() {
        if (!isShootingMode()) {
            if (leftArm.getRawButton(LEG_RIGHT_FORWARD)) {
                Hammer.pushRampDown();
            } else if (leftArm.getRawButton(LEG_RIGHT_BACKWARD)) {
                Hammer.resetRampStompers();
            } else {
                Hammer.stopMoving();
            }
        }
    }

    private void hammerControlOff() {
        Hammer.stopMoving();
    }

    private void shooterControlOn() {
        double shooterInput = 0;

        if (isShootingMode()) {
            shooterInput = leftArm.getY();
            Shooter.fireBallsWithAnalog(shooterInput);
        }
    }

    private void shooterControlOff() {
        Shooter.stopMoving();
    }

    private boolean isShootingMode() {
        return (leftArm.getRawButton(LEG_RIGHT_RIGHT) && leftArm.getRawButton(LEG_LEFT_LEFT));
    }
}
