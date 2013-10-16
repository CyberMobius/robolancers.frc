package edu.wpi.first.wpilibj.templates.commands.drivetrain;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 *
 *
 * @author Eric
 */
public class DriveWithJoystick extends CommandBase {

    public static String driveStatus;

    public DriveWithJoystick() {
        super("Joysticks in control");
        requires(drivetrain);
        driveStatus = "Forward Drive";
    }

    protected void initialize() {
    }

    protected void execute() {
        double joyY = OI.driveStick.getY();
        double joyX = OI.driveStick.getX();

        if (ReverseCurrentDrive.reverseCheck == 0) {
            drivetrain.arcadeDrive(-joyY, -joyX);
            driveStatus = "Forward Drive";
        } else if (ReverseCurrentDrive.reverseCheck == 1) {
            drivetrain.arcadeDrive(joyY, -joyX);
            driveStatus = "Backward Drive";
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}