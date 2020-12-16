import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Examples {
    GregorianCalendar Jul172002 = new GregorianCalendar(2002, Calendar.JULY, 17);
    GregorianCalendar Feb292020 = new GregorianCalendar(2020, Calendar.FEBRUARY, 29);
    GregorianCalendar Oct312020 = new GregorianCalendar(2020, Calendar.OCTOBER, 31);
    GregorianCalendar Dec252020 = new GregorianCalendar(2020, Calendar.DECEMBER, 25);
    GregorianCalendar Nov012020 = new GregorianCalendar(2020, Calendar.NOVEMBER, 1);

    Time noon = new Time(12, 0);
    Time threePM = new Time(15, 0);
    Time fiveAM = new Time(5, 0);
    Time midnight = new Time(0, 0);
    Time fourTwenty = new Time(4, 20);

    Reading r1 = new Reading(noon, 68, 1.2);
    Reading r2 = new Reading(threePM, 97, 5.2);
    Reading r3 = new Reading(fiveAM, 27, 0);
    Reading r4 = new Reading(midnight, 12, 3.2);
    Reading r5 = new Reading(fourTwenty, 78, 17.4);

    LinkedList<Reading> readings1 = new LinkedList<>(); {
        readings1.add(r1);
        readings1.add(r3);
        readings1.add(r5);
    }
    LinkedList<Reading> readings2 = new LinkedList<>(); {
        readings2.add(r2);
        readings2.add(r4);
    }
    LinkedList<Reading> readings3 = new LinkedList<>(); {
        readings3.add(r1);
        readings3.add(r2);
        readings3.add(r3);
    }
    LinkedList<Reading> readings4 = new LinkedList<>(); {
        readings4.add(r1);
        readings4.add(r2);
        readings4.add(r3);
        readings4.add(r4);
        readings4.add(r5);
    }

    DailyWeatherReport report1 = new DailyWeatherReport(Jul172002, readings1);
    DailyWeatherReport report2 = new DailyWeatherReport(Feb292020, readings2);
    DailyWeatherReport report3 = new DailyWeatherReport(Feb292020, readings3);
    DailyWeatherReport report4 = new DailyWeatherReport(Oct312020, readings3);
    DailyWeatherReport report5 = new DailyWeatherReport(Dec252020, readings4);
    DailyWeatherReport report6 = new DailyWeatherReport(Nov012020, readings1);

    ReportList reportList = new ReportList(); {
        reportList.addReport(report1);
        reportList.addReport(report2);
        reportList.addReport(report3);
        reportList.addReport(report4);
        reportList.addReport(report5);
        reportList.addReport(report6);
    }

    WeatherMonitor monitor = new WeatherMonitor(reportList);
    WeatherMonitor monitorEmpty = new WeatherMonitor(new ReportList());

    @Test //Single reports
    public void checkAverageTempForMonthSingle() {
        assertEquals(0, monitor.averageTempForMonth(6, 2020), 0.01);
        assertEquals(57.67, monitor.averageTempForMonth(6, 2002), 0.01);
        assertEquals(57.67, monitor.averageTempForMonth(10, 2020), 0.01);
        assertEquals(56.4, monitor.averageTempForMonth(11, 2020), 0.01);
    }
    @Test //Multiple valid reports
    public void checkAverageTempForMonthMultiple() {
        assertEquals(59.25, monitor.averageTempForMonth(1, 2020), 0.01);
    }

    @Test //Single reports
    public void checkTotalRainfallForMonthSingle() {
        assertEquals(0, monitor.totalRainfallForMonth(6, 2020), 0.01);
        assertEquals(18.6, monitor.totalRainfallForMonth(6, 2002), 0.01);
        assertEquals(18.6, monitor.totalRainfallForMonth(10, 2020), 0.01);
        assertEquals(27, monitor.totalRainfallForMonth(11, 2020), 0.01);
    }

    @Test //Multiple valid reports
    public void checkTotalRainfallForMonthMultiple() {
        assertEquals(14.8, monitor.totalRainfallForMonth(1, 2020), 0.01);
    }

    @Test
    public void checkAddDailyReport() {
        monitorEmpty.addDailyReport(Feb292020, readings2);
        monitorEmpty.addDailyReport(Feb292020,readings3);

        assertEquals(57.67, monitor.averageTempForMonth(6, 2002), 0.01);
        assertEquals(57.67, monitor.averageTempForMonth(10, 2020), 0.01);
        assertEquals(18.6, monitor.totalRainfallForMonth(6, 2002), 0.01);
        assertEquals(18.6, monitor.totalRainfallForMonth(10, 2020), 0.01);
    }
}