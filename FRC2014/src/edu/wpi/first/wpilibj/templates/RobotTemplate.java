/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Kicker;
import edu.wpi.first.wpilibj.templates.subsystems.Ramp;
import edu.wpi.first.wpilibj.templates.subsystems.Roller;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    //Autonomous autoComm;
    //public static SmartDashboard smartDash = new SmartDashboard();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        
        //autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        if(RobotMap.DEBUG_MODE){
            LiveWindow.addActuator("Flaps", "Port 1", new Victor(1));
            LiveWindow.addActuator("Flaps", "Port 2", new Victor(2));
            LiveWindow.addActuator("DriveTrain", "Port 3", new Talon(3));
            LiveWindow.addActuator("DriveTtain", "Port 4", new Talon(4));
            LiveWindow.addActuator("DriveTrain", "Port 8", new Talon(8));
            LiveWindow.addActuator("DriveTrain", "Port 9", new Talon(9));
            LiveWindow.addActuator("Roller", "Port 6", new Victor(6));
            LiveWindow.addActuator("Ramp", "Port 7", new Victor(7));
            LiveWindow.addActuator("Unused", "Port 5", new Victor(5));
            LiveWindow.addActuator("Unused", "Port 10", new Victor(10));
            LiveWindow.addActuator("Ramp", "Port 1", new AnalogPotentiometer(2));
        }else{
            CommandBase.init();
        }
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //autoComm.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //autoComm.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Sonic Shifter", DriveTrain.isHighGear);
        SmartDashboard.putBoolean("Roller Piston", Roller.isExtended);
        SmartDashboard.putBoolean("Kicker", Kicker.isExtended);
        SmartDashboard.putString("Ramp Status", CommandBase.ramp.getRampStatus());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
