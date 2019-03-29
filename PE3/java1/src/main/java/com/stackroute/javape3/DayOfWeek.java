package com.stackroute.javape3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DayOfWeek {
    public String calender(String s)
    {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println();
        String s1 = "First day of week : ";
        DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
        s1 += (df.format(c.getTime()));
        s1 += " Last day of week : ";
        for (int i = 0; i < 6; i++) {
            c.add(Calendar.DATE, 1);
        }
        System.out.println();
        s1 += (df.format(c.getTime()));
        return s1;
    }
}
