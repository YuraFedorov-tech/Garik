package ru.igor;
/*
 *
 *@Data 30.08.2020
 *@autor Fedorov Yuri
 *@project javaWithoutMain
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputWeek {
    private static String days[] = {"понедельника", "вторника", "среды"};
    private static String tMax = "введите время максимума в формате HHmmss";
    private static String tMin = "введите время минимума в формате HHmmss";
    private static String dayString;

    /*
        SimpleDateFormat format2 = new SimpleDateFormat();
        format2.applyPattern("yyyyMMddHHmmss");
        try {
            date = format2.parse(row[0] + row[1]);
     */
    public static Week getMyWeek() {
        SimpleDateFormat format2 = new SimpleDateFormat();
        format2.applyPattern("yyyyMMddHHmmss");

        Scanner sc = new Scanner(System.in);
        Week week = null;
        week = getWeek(sc);

        // понедельник максимум
        System.out.println(tMax + days[0]);
        String t;
        t = "061000";
        t = sc.nextLine().trim();
        try {
            Date date = format2.parse(dayString + t);
            week.getMonday().setTimeMax(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // понедельник минимум
        System.out.println(tMin + days[0]);

        t = "061000";
        t = sc.nextLine().trim();
        try {
            Date date = format2.parse(dayString + t);
            week.getMonday().setTimeMin(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // вторник максимум
        System.out.println("введите вторник максимум в формате  yyyyMMddHHmmss");

        t = "20200825104630";
        t = sc.nextLine().trim();


        try {
            Date date = format2.parse(t);
            week.getTuesday().setTimeMax(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // вторник минимум
        System.out.println("введите вторник минимум в формате  yyyyMMddHHmmss");

        t = "20200825052030";
        t = sc.nextLine().trim();

        try {
            Date date = format2.parse(t);
            week.getTuesday().setTimeMin(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // среда максимум
        System.out.println("введите среда максимум в формате  yyyyMMddHHmmss");

        t = "20200826056012";
        t = sc.nextLine().trim();
        try {
            Date date = format2.parse(t);
            week.getWednesday().setTimeMax(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // среда минимум
        System.out.println("введите среда минимум в формате  yyyyMMddHHmmss");

        t = "20200826201012";
        t = sc.nextLine().trim();

        try {
            Date date = format2.parse(t);
            week.getWednesday().setTimeMin(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int y = 4;
        return week;
    }

    private static Week getWeek(Scanner sc) {
        System.out.println("введите дату понедельника в формате yyyyMMdd");

        dayString = "20200824";
        dayString = sc.nextLine().trim();

        SimpleDateFormat format2 = new SimpleDateFormat();
        format2.applyPattern("yyyyMMdd");
        try {
            Date date = format2.parse(dayString);
            Week week = new Week(new Date());
            return week;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        throw new ArithmeticException("неверный формат даты");
    }
}
