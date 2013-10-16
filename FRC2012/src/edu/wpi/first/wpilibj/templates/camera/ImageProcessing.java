/*\
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.camera;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author Eric
 */
public class ImageProcessing {

    /*
     * X-Axis: 0 to 320 Y-Axis: Is inverted, 0 to 240 (0 on Top, as you go Down
     * till reaches 240)
     */
    private static AxisCamera camera;
    private static CriteriaCollection cc;
    private static ColorImage image; //Disable color?
//    static int trial;
//    static int testRectangle;
//    static int lowestRectanglePosition;
//    static int lowestRectangleArrayPosition;
    private int current = 0;

    public ImageProcessing() {
        camera = AxisCamera.getInstance();  // get an instance ofthe camera
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        //Taken out due to possibly distortions from width
//        cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 400, false); 
        //Since the camera does not change pitch angle, the height will usually be consistent
        cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 30, 300, false);
    }

    /*
     * I'm having some trouble with this method right now with null pointer exceptions
     * and what not, so I'll just copy and paste the contents where I desire for now
     * and edit it there...
     * 
     * Maybe someone can get this method working one day...
     * 
     * I'm too lazy at the moment
     * 
     * 3/16/2012 7:49 PM in My Bedroom
     * 
     * -Eric
     */
    public ParticleAnalysisReport[] getRectangleParticles() throws AxisCameraException, NIVisionException {
        ParticleAnalysisReport[] toReturn = new ParticleAnalysisReport[0];

//        trial++;
        int current = 0;
        this.current++;
        try {
            image = AxisCamera.getInstance().getImage();
            image.write(this.current + "image");
            if (image != null) {
                //Created a binary image where pixels meeting threshold
                BinaryImage thresholdImage = image.thresholdRGB(116, 194, 43, 94, 38, 146);
                BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(true, 1);  // remove small artifacts
                BinaryImage convexHullImage = bigObjectsImage.convexHull(true);          // fill in occluded rectangles
                BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangles

                ParticleAnalysisReport[] reports = filteredImage.getOrderedParticleAnalysisReports();

                //Makes checks to see if the rectangle meets size and ratio requirements
                for (int i = 0; i < reports.length; i++) {
                    ParticleAnalysisReport test = reports[i];
//                    if (test.particleToImagePercent > .1 && test.particleToImagePercent < .4) {
                    double rectangleScore = test.particleArea / (test.boundingRectHeight * test.boundingRectWidth);
                    if (rectangleScore >= 0.70) {
                        double ratio = test.boundingRectWidth / test.boundingRectHeight;
                        if (ratio > ((4 / 3) - .2) && ratio < ((4 / 3) + .2)) {
//                            toReturn = new ParticleAnalysisReport[toReturn.length + 1];
//                            toReturn[current] = test;
                            current++;
//                            image.write(current + "image");
                        }
                    }
//                    }
                }

                toReturn = new ParticleAnalysisReport[current];

                filteredImage.free();
                convexHullImage.free();
                bigObjectsImage.free();
                thresholdImage.free();
                image.free();
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }

        //return the rectangles that meet the requirements
        return toReturn;
    }

    public ParticleAnalysisReport getLowestRectangleReport(ParticleAnalysisReport[] reports) {
        ParticleAnalysisReport test;
        ParticleAnalysisReport lowestRectangleReport = null;

        int testRectangleY,
                lowestRectangleYPosition = 0,
                lowestRectangleArrayPosition;

        if (reports[0] != null) {
            for (int k = 0; k < reports.length; k++) {
                if (reports[k] != null) { //Because I'm cautious like that...
                    test = reports[k];

                    testRectangleY = test.center_mass_y;

                    //If testRectangle's Center Y Position is lower than what is currently the lowest rectangle position
                    //It's > because of inverted Y-Axis
                    if (testRectangleY > lowestRectangleYPosition) { //If our current rectangle is lower than our currently stored rectangle...
                        lowestRectangleYPosition = testRectangleY; //Stores the lowest rectangle position as of this line if able to
                        lowestRectangleArrayPosition = k; //Store the array position where the lowest rectangle is

                        lowestRectangleReport = reports[lowestRectangleArrayPosition];
                    }
                }
            }
        } else {
            System.out.println("Reports were null when trying to find the lowest rectangle report"); //In theory, this should be never reached
        }

        return lowestRectangleReport;
    }
    
    /*
     * I'm having some trouble with this method right now with null pointer exceptions
     * and what not, so I'll just copy and paste the contents where I desire for now
     * and edit it there...
     * 
     * Maybe someone can get this method working one day...
     * 
     * I'm too lazy at the moment...
     * 
     * 3/16/2012 7:49 PM in My Bedroom
     * 
     * -Eric
     */
    public static void writeFilteredImage() throws AxisCameraException, NIVisionException {
        try {
            //gets and stores the current camera image
            image = AxisCamera.getInstance().getImage();

            //Created a binary image where pixels meeting threshold
            BinaryImage thresholdImage = image.thresholdHSL(0, 14, 0, 114, 21, 206);
            BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);  // remove small artifacts
            BinaryImage convexHullImage = bigObjectsImage.convexHull(false);          // fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangles

            filteredImage.write("filteredImage");
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * The height and width of the bounding rectangle from the target will be taken
     * to calculate the distance from the robot to the targets using proportionality constants
     * from the ShooterYaw
     * 
     * @param report The report of the target that you wanna use to calulate distance
     */
    public void calculateDistance(ParticleAnalysisReport report) {
    }
}
