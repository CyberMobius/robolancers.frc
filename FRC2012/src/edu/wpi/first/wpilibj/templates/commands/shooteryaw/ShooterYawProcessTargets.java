/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.shooteryaw;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.templates.camera.ImageProcessing;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author RoboLancers
 */
public class ShooterYawProcessTargets extends CommandBase {

    private final double PIXEL_HEIGHT_TO_DISTANCE = 1, //TODO - Find this
            BOUNDING_WIDTH_ERROR_TO_ANGLE = 1; //TODO - Find this //See CameraDistance.png
    private ImageProcessing filterImages;
    public static String targetReportStatus;
    /*
     * Camera will be looking at X-Coordinate 160 We want that X-Coordinate to
     * matchup with lowestRectangleReport's center x mass
     */
    private static AxisCamera camera;
    private static CriteriaCollection cc;
    public static int lowestRectangleCenterX,
            xCoordinateDifference;
    private int trial;
    private boolean isDone;
    public static double timeBefore, timeAfter;
    public static double angleChange = 0, distance;
    static int pic = 1;

    public ShooterYawProcessTargets() {
        super("Processing...");
        requires(shooterYaw);

        filterImages = new ImageProcessing();

        targetReportStatus = "Chilling.";

        camera = AxisCamera.getInstance();
        cc = new CriteriaCollection();
        //Perhaps re-add this if we always have driver center robot to hoops...
        //Taken out due to possibly distortions from width
//        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 400, false);
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 30, 300, false);

        distance = 0;
    }

    protected void initialize() {
        int[] targetIndexes = null;

        isDone = false;
        timeBefore = Timer.getFPGATimestamp();

        ParticleAnalysisReport[] targetReports = null;
        ParticleAnalysisReport[] reports = null;
        ParticleAnalysisReport lowestRectangleReport = null;
        ParticleAnalysisReport test = null;

        trial++;
        int current = 0;
        distance = 0;

        try {
            ColorImage image = camera.getImage();

            BinaryImage thresholdImage = image.thresholdRGB(0, 255, 41, 255, 176, 255);
            BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(true, 1);  // remove small artifacts
            BinaryImage convexHullImage = bigObjectsImage.convexHull(true);          // fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangles

            filteredImage.write("filteredImage.png");
            System.out.println("Image written as filteredImage.png");

            reports = filteredImage.getOrderedParticleAnalysisReports();
            targetIndexes = new int[reports.length];

            System.out.println(reports.length + " reports to be analyzed");

            //Makes checks to see if the rectangle meets size and ratio requirements
            for (int j = 0; j < reports.length; j++) {
                test = reports[j];
                System.out.println("Test particle report " + j + " made");
                double rectangleScore = test.particleArea / (test.boundingRectHeight * test.boundingRectWidth); //1 = perfect score
                if (rectangleScore > 0.80) {
                    System.out.println("Test particle report " + j + " passes rectangle score");

                    /*
                     * I removed ratio test b/c there is a chance that the
                     * image will be distorted when we are at a close distance
                     * and we facing the targets at an angle, as in
                     * _______________ | T | T = Target | T | |R | R = Robot | |
                     * | | vs. | R | | | | |
                     *
                     * The angle in respect to the top horizontal line to the
                     * robot is farther away the angle perpindicular to the
                     * robot, which distorts the horizontal section of the
                     * targets into looking smaller than it actually is.
                     */

                    /*
                     * After checking which reports are considered targets,
                     * make an array of ParticleAnalysisReport that is the
                     * size of the number of reports
                     */
                    targetIndexes[current] = j;
                    current++; //current represents the length of the target reports array to make to be analyzed later
                }
            }

            filteredImage.free();
            convexHullImage.free();
            bigObjectsImage.free();
            thresholdImage.free();
            image.free();
            System.out.println("Images were freed");

        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }

        if (current != 0) { //Actually give properties to this new targetReports...
            targetReports = new ParticleAnalysisReport[current];
            for (int k = 0; k < targetReports.length; k++) {
                targetReports[k] = reports[targetIndexes[k]];
            }
            System.out.println(current + " Target Reports were made");

            lowestRectangleReport = filterImages.getLowestRectangleReport(targetReports);
            System.out.println("Lowest Rectangle Report Identified");

            if (lowestRectangleReport != null) {
                System.out.println("Lowest Rectangle Report was not null");
                xCoordinateDifference = 160 - lowestRectangleReport.center_mass_x;
                System.out.println("xCoordinateDifference: " + xCoordinateDifference);

                //Calculates distance from robot to hoops based on lowest target report
                double boundingHeight = lowestRectangleReport.boundingRectHeight;
                System.out.println("Bounding Height " + boundingHeight);
                double boundingWidth = lowestRectangleReport.boundingRectWidth;
                System.out.println("Bounding Width " + boundingWidth);

                /* 
                 * Distance from the target to the robot from the viewpoint that 
                 * the line pertruding from the target perpindicular to the 
                 * backboards hits the robot
                 */
                double yDist = boundingHeight * PIXEL_HEIGHT_TO_DISTANCE;
                System.out.println("Y-Dist " + yDist);
                /*
                 * What the bounding width SHOULD be if the robot followed the
                 * guidelines from yDist
                 * 4/3 Represents 4 width pixels / 3 height pixels
                 */
                double theoreticalBoundingWidth = boundingHeight * (4 / 3);
                System.out.println("Theoretical Bounding Width " + theoreticalBoundingWidth);

                double boundingWidthError = Math.abs(boundingWidth - theoreticalBoundingWidth) / 100;
                System.out.println("Bounding Width Error " + boundingWidthError);

                /*
                 * See diagram of backboard to robot (CameraDistance.png)
                 */
                double theta = boundingWidthError * BOUNDING_WIDTH_ERROR_TO_ANGLE;
                System.out.println("Theta (Degrees) " + theta);
                double thetaInRadians = Math.toRadians(theta); //Darn trig functions only accept radians...
                System.out.println("Theta (Radians) " + thetaInRadians);

                //Actual distance from robot to target
                distance = yDist / (Math.cos(thetaInRadians));
                System.out.println("Distance");

                Shooter.velocitySetpoint = Shooter.calculateVelocitySetpoint(distance);
                System.out.println("Calculated Velocity Setpoint " + Shooter.calculateVelocitySetpoint(distance));
            }
        }

        if (targetReports == null) {
            targetReportStatus = "Trial " + trial + ": No Targets Found";
        }

        timeAfter = Timer.getFPGATimestamp() - timeBefore;
        isDone = true;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}