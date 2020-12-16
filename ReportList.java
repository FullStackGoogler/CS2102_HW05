import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Represents a LinkedList of {@link DailyWeatherReport}.
 */
public class ReportList implements IReportList {
    private final LinkedList<DailyWeatherReport> reports;

    public ReportList() {
        this.reports = new LinkedList<>();
    }

    public ReportList(LinkedList<DailyWeatherReport> reports) {
        this.reports = reports;
    }

    /**
     * Adds a report to a list of reports.
     * @param report The report to be added.
     */
    @Override
    public void addReport(DailyWeatherReport report) { reports.add(report); }

    /**
     * Finds all the {@link DailyWeatherReport} that are in the given month and year.
     * @param month The target month.
     * @param year The target year.
     * @return A List of {@link DailyWeatherReport}.
     */
    @Override
    public LinkedList<DailyWeatherReport> getReports(int month, int year) {
        LinkedList<DailyWeatherReport> reports = new LinkedList<>();

        for(DailyWeatherReport report : this.reports) {
            GregorianCalendar date = report.getDate();

            if((date.get(GregorianCalendar.MONTH) == month) && (date.get(GregorianCalendar.YEAR) == year)) {
                reports.add(report);
            }
        }
        return reports;
    }
}