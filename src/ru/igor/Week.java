package ru.igor;
/*
 *
 *@Data 30.08.2020
 *@autor Fedorov Yuri
 *@project javaWithoutMain
 *
 */

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Week {
    private MyDate monday;
    private MyDate tuesday;
    private MyDate wednesday;

    public Week(Date date) {
        monday = new MyDate(date, 0);
        tuesday = new MyDate(date, 1);
        wednesday = new MyDate(date, 2);

    }

    public boolean isInclude(Date date) {
        return date.getTime() < CalendarUtill.getEndDay(monday.getDate(), 6).getTime();
    }

    public void insideMinMax(RowCsv row) {
      //  System.out.println(row);
        if (includ(row.getDate(), monday)) {
            tryChange(monday,row);
        }
        if (includ(row.getDate(), tuesday)) {
            tryChange(tuesday,row);
        }
        if (includ(row.getDate(), wednesday)) {
            tryChange(wednesday, row);
        }
    }

    private void tryChange(MyDate myDate, RowCsv row) {
        BigDecimal rowMax=row.getMax();
        BigDecimal rowMin=row.getMin();

        BigDecimal max=myDate.getMax();
        BigDecimal min=myDate.getMin();

        if(rowMax.compareTo(max)>0){
            myDate.setMax(rowMax);
            myDate.setTimeMax(row.getDate());

        }
        if(rowMin.compareTo(min)<0){
            myDate.setMin(rowMin);
            myDate.setTimeMin(row.getDate());
        }

    }

    private boolean includ(Date date, MyDate dayOfWeek) {
        return date.getTime() >= dayOfWeek.getStartDay().getTime() && date.getTime() <= dayOfWeek.getEndDay().getTime();
    }

    public MyDate getMonday() {
        return monday;
    }

    public void setMonday(MyDate monday) {
        this.monday = monday;
    }

    public MyDate getTuesday() {
        return tuesday;
    }

    public void setTuesday(MyDate tuesday) {
        this.tuesday = tuesday;
    }

    public MyDate getWednesday() {
        return wednesday;
    }

    public void setWednesday(MyDate wednesday) {
        this.wednesday = wednesday;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Week week = (Week) o;
        return Objects.equals(getMonday(), week.getMonday()) &&
                Objects.equals(getTuesday(), week.getTuesday()) &&
                Objects.equals(getWednesday(), week.getWednesday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonday(), getTuesday(), getWednesday());
    }

    @Override
    public String toString() {
        return "Week{" +
                "monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                '}';
    }
}
