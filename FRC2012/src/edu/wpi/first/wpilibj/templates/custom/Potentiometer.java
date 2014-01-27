package edu.wpi.first.wpilibj.templates.custom;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 * @author Eric
 */
public class Potentiometer extends AnalogChannel implements PIDSource {

    public Potentiometer(int channel) {
        super(channel);
    }

    public double pidGet() {
        return getAverageVoltage();
    }
}
