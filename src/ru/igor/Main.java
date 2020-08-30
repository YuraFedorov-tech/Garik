package ru.igor;
/*
 *
 *@Data 30.08.2020
 *@autor Fedorov Yuri
 *@project javaWithoutMain
 *
 */

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
<dependency>
    <groupId>net.sf.opencsv</groupId>
    <artifactId>opencsv</artifactId>
    <version>2.3</version>
</dependency>
 */
public class Main {
    private boolean start;
    private List<Week> week = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.go();

    }

    private void go() throws IOException {
        //Build reader instance
        //Read data.csv
        //Default seperator is comma
        //Default quote character is double quote
        //Start reading from line number 2 (line numbers start from zero)
        CSVReader reader = new CSVReader(new FileReader("E:\\Garic\\javaWithoutMain\\data\\data.csv"), ',', '"', 1);
        //Read all rows at once
        List<String[]> allRows = reader.readAll();
        //Read CSV line by line and use the string array as you want
        List<RowCsv> rowCsvs = new ArrayList<>();
        for (String[] row : allRows) {
            //      System.out.println(Arrays.toString(row));
            RowCsv rowFromFile = new RowCsv(row);
            rowFromFile.doRow();
            if (ifStartSafe(rowFromFile)) {
                rowCsvs.add(rowFromFile);
            }
        }

        fillWeek(rowCsvs);
        Week myWeek = InputWeek.getMyWeek();
        System.out.println("параметры недели - "+ myWeek);
        System.out.println();
        int y = 1;
        for (Week thisWeek : week) {
            if (thisWeek.equals(myWeek)) {
                System.out.println("неделя номер - " + y + thisWeek);
                y++;
            }
        }
    }

    private void doAllWeek(Date rowCsv) {
        while (true) {
            Week week1 = new Week(rowCsv);
            week.add(week1);
            rowCsv = CalendarUtill.add7Days(rowCsv);
            Date date = new Date();
            if (rowCsv.getTime() > date.getTime())
                break;
        }
    }

    private void fillWeek(List<RowCsv> rowCsvs) {
        int numWeek = 0;
        for (RowCsv row : rowCsvs) {
            while (!isIncudDayInWeek(row.getDate(), week.get(numWeek))) {
                numWeek++;
            }
            week.get(numWeek).insideMinMax(row);

        }

    }

    private boolean isIncudDayInWeek(Date date, Week week) {
        return week.isInclude(date);
    }


    private boolean ifStartSafe(RowCsv rowFromFile) {
        if (start)
            return true;
        Calendar c = Calendar.getInstance();
        Date date = rowFromFile.getDate();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 2) {
            doAllWeek(date);
            start = true;
        }
        return true;
    }
}
