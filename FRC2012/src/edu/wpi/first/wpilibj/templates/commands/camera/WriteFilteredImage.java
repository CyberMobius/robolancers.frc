/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.camera;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.templates.camera.ImageProcessing;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class WriteFilteredImage extends CommandBase {

    int trial;
    boolean isDone;
    double timeBefore, timeAfter;
    private AxisCamera camera;
    private final CriteriaCollection cc;
    private final ImageProcessing filterImages;
    private int xCoordinateDifference;
    private int angleChange;
    private String targetReportStatus;

    public WriteFilteredImage() {
        filterImages = new ImageProcessing();

        camera = AxisCamera.getInstance();
        cc = new CriteriaCollection();
        //Perhaps re-add this if we always have driver center robot to hoops...
        //Taken out due to possibly distortions from width
//        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 400, false);
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 0, 300, false);
    }

    protected void initialize() {
        int[] targetIndexes;

        isDone = false;
        timeBefore = Timer.getFPGATimestamp();

        ParticleAnalysisReport[] targetReports = new ParticleAnalysisReport[1];
        targetReports[0] = null;
        ParticleAnalysisReport[] reports = null;
        ParticleAnalysisReport lowestRectangleReport = null;
        ParticleAnalysisReport test = null;

        trial++;
        int current = 0;

        try {
            ColorImage image = camera.getImage();

            BinaryImage thresholdImage = image.thresholdRGB(108, 255, 41, 255, 176, 255);
            BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(true, 1);  // remove small artifacts
            BinaryImage convexHullImage = bigObjectsImage.convexHull(true);          // fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangles

            filteredImage.write("filteredImage.png");
            System.out.println("filteredImage.png written");

            reports = filteredImage.getOrderedParticleAnalysisReports();
            targetIndexes = new int[reports.length];

            //Makes checks to see if the rectangle meets size and ratio requirements
            for (int i = 0; i < reports.length; i++) {
                test = reports[i];
                System.out.println("Test particle report made");
                double rectangleScore = test.particleArea / (test.boundingRectHeight * test.boundingRectWidth); //1 = perfect score
//                if (test.particleToImagePercent > .1 && test.particleToImagePercent < .4) {
                if (rectangleScore > 0.75) {
                    System.out.println("Test particle passes rectangle score");
                    /*
                     * Possibly remove ratio b/c there is a chance that the
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
                    double ratio = test.boundingRectWidth / test.boundingRectHeight;
                    if (ratio > ((4 / 3) - .2) && ratio < ((4 / 3) + .2)) {
                        System.out.println("Test particle passed ratio test");
//                        targetReports = new ParticleAnalysisReport[targetReports.length + 1];
                        /*
                         * After checking which reports are considered targets,
                         * make an array of ParticleAnalysisReport that is the
                         * size of the number of reports
                         */
//                        current = i;
                        targetIndexes[current] = i;
                        current++; //current represents the length of the target reports array to make
                        System.out.println("Number of Target Reports to Make at this moment: " + current);
//                        
                    }
                }
//                }
            }
            if (current != 0) { //Actually give properties to this new targetReports...
                targetReports = new ParticleAnalysisReport[current];
                for (int k = 0; k < targetReports.length; k++) {
                    targetReports[k] = reports[targetIndexes[k]];
                    System.out.println("Target Reports made");
                }
            }

            filteredImage.free();
            convexHullImage.free();
            bigObjectsImage.free();
            thresholdImage.free();
            image.free();

        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }

        if (targetReports[0] != null) {
            System.out.println("Target Reports are not null");
            for (int k = 0;
                    k < targetReports.length;
                    k++) {
                if (targetReports[k] != null) {
                    targetReportStatus = "Found something!";
                    System.out.println("Trial: " + trial + " Report: " + k + " Center of mass x: " + targetReports[k].center_mass_x);
                    xCoordinateDifference = 160 - lowestRectangleReport.center_mass_x;
                    System.out.println ("X-Coordinate Differnce: " + xCoordinateDifference);
                    lowestRectangleReport = filterImages.getLowestRectangleReport(targetReports);
                    System.out.println("Report " + k + " was analyzed");
                }
            }
        }

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
