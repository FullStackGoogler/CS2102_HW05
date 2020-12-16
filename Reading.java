/**
 * Represents data gathered from a weather sensor.
 */
public class Reading {
    private final Time time;
    private final double temp;
    private final double rainfallAMT;

    public Reading(Time time, double temp, double rainfallAMT) {
        this.time = time;
        this.temp = temp;
        this.rainfallAMT = rainfallAMT;
    }

    public double getTemp() { return temp; }

    public double getRainfallAMT() { return rainfallAMT; }
}