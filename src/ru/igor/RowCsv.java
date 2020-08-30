package ru.igor;
/*
 *
 *@Data 30.08.2020
 *@autor Fedorov Yuri
 *@project javaWithoutMain
 *
 */

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RowCsv {
    private String[] row;
    private Date date;
    private BigDecimal max;

    public String[] getRow() {
        return row;
    }

    public void setRow(String[] row) {
        this.row = row;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    private BigDecimal min;

    public RowCsv(String[] row) {
        this.row = row;
    }

    public void doRow() {
        doDate();
        doMax();
        doMin();
    }

    private void doDate() {
//        SimpleDateFormat format = new SimpleDateFormat();
//        format.applyPattern("yyyyMMdd");

        SimpleDateFormat format2 = new SimpleDateFormat();
        format2.applyPattern("yyyyMMddHHmmss");
        try {
            date = format2.parse(row[0] + row[1]);
            int t = 0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void doMax() {
        max = new BigDecimal(row[3]);
    }

    private void doMin() {
        min = new BigDecimal(row[4]);
    }

    @Override
    public String toString() {
        return "RowCsv{" +
                "row=" + Arrays.toString(row) +
                ", date=" + date +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
