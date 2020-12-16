import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Represents the collected data from a weather sensor in a day.
 */
public class DailyWeatherReport {
    private final GregorianCalendar date;
    private final LinkedList<Double> temp;
    private final LinkedList<Double> rainfallAMT;

    public DailyWeatherReport(GregorianCalendar date, LinkedList<Reading> readings) {
        this.date = date;
        this.temp = new LinkedList<>();
        this.rainfallAMT = new LinkedList<>();

        for(Reading reading : readings) {
            temp.add(reading.getTemp());
            rainfallAMT.add(reading.getRainfallAMT());
        }
    }

    public GregorianCalendar getDate() { return date; }

    /**
     * Calculates the average temperature in a day.
     * @return A double representing the average temperature that day.
     */
    public double getAvgTemp(){ return sumOfList(temp) / temp.size(); }

    /**
     * Calculates the total rainfall in a day.
     * @return A double representing the total rainfall that day.
     */
    public double getTotalRainfall() { return sumOfList(rainfallAMT); }

    /**
     * Sum the elements in a given list up.
     * @param data The list of data we want to calculate the sum of.
     * @return A double representing the sum of the list.
     */
    private double sumOfList(LinkedList<Double> data) {
        double sum = 0;

        for(double num : data) {
            sum += num;
        }
        return sum;
    }
}