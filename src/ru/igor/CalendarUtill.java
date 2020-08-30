package ru.igor;
/*
 *
 *@Data 30.08.2020
 *@autor Fedorov Yuri
 *@project javaWithoutMain
 *
 */

import java.util.Calendar;
import java.util.Date;

public class CalendarUtill {

    public static Date getBeginDay(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, days);
        Calendar calendar = Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int day = c.get(c.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();

    }

    public static Date getEndDay(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, days);
        Calendar calendar = Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int day = c.get(c.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        return calendar.getTime();
    }

    public static Date add7Days(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, 7);
        return c.getTime();
    }

    public static boolean check(Date timeMax, Date timeMax1) {
        Calendar timeMaxPlus1Houer = Calendar.getInstance();
        timeMaxPlus1Houer.setTime(timeMax);
        timeMaxPlus1Houer.add(Calendar.HOUR, 1);
        Date datePl1 = timeMaxPlus1Houer.getTime();

        Calendar timeMinMinus1Houer = Calendar.getInstance();
        timeMinMinus1Houer.setTime(timeMax);
        timeMinMinus1Houer.add(Calendar.HOUR, -1);
        Date dateMinus1 = timeMinMinus1Houer.getTime();

        Calendar c = Calendar.getInstance();
        c.setTime(timeMax);
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int day = c.get(c.DATE);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(timeMax1);
        int houer = c2.get(c2.HOUR_OF_DAY);
        int minut = c2.get(c2.MINUTE);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, houer, minut, 00);
        Date my = calendar.getTime();

        return datePl1.getTime() >= my.getTime() && dateMinus1.getTime() <= my.getTime();


    }
}
