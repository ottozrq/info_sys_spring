import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by zhangruoqiu on 2017/5/3.
 */
public class TryCalender {

    @Test
    public void tryCalender(){
        Calendar c = GregorianCalendar.getInstance();

        System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

        // Set the calendar to monday of the current week
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

        // Print dates of the current week starting on Monday
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String startDate = "", endDate = "";

        startDate = df.format(c.getTime());
        c.add(Calendar.DATE, 6);
        endDate = df.format(c.getTime());

        System.out.println("Start Date = " + startDate);
        System.out.println("End Date = " + endDate);
    }
}
