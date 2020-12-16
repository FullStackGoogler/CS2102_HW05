import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Represents a Weather Monitor object.
 */
public class WeatherMonitor {
    private final IReportList reports;

    public WeatherMonitor(IReportList reports) {
        this.reports = reports;
    }

    /**
     * Calculates the average temperature over all days that month.
     * @param month The target month.
     * @param year The target year.
     * @return A double representing the average temperature for that month, 0 if there are no reports in a given month.
     */
    public double averageTempForMonth(int month, int year) {
        double total = 0;
        int count = 0;

        for(DailyWeatherReport report : reports.getReports(month, year)) {
            total += report.getAvgTemp();
            count++;
        }

        if(count == 0)
            return 0;

        return total / count;
    }

    /**
     * Calculates the total rainfall over all days that month.
     * @param month The target month.
     * @param year The target year.
     * @return A double representing the total rainfall that month.
     */
    public double totalRainfallForMonth(int month, int year) {
        double total = 0;

        for(DailyWeatherReport report : reports.getReports(month, year))
            total += report.getTotalRainfall();
        return total;
    }

    /**
     * Creates and adds a {@link DailyWeatherReport} to the list of reports.
     * @param date The date the report was taken.
     * @param readings The data collected from the weather sensor.
     */
    public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
        reports.addReport(new DailyWeatherReport(date, readings));
    }
}