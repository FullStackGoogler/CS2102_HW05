import java.util.LinkedList;

/**
 * Represents a generic data structure of one of.
 */
public interface IReportList {
    /**
     * Adds a report to a list of reports.
     * @param report The report to be added.
     */
    void addReport(DailyWeatherReport report);

    /**
     * Finds all the {@link DailyWeatherReport} that are in the given month and year.
     * @param month The target month.
     * @param year The target year.
     * @return A List of {@link DailyWeatherReport}.
     */
    LinkedList<DailyWeatherReport> getReports(int month, int year);
}