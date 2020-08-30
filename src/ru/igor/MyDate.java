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

public class MyDate {
    private BigDecimal max;
    private BigDecimal min;
    private Date date;
    private Date startDay;
    private Date endDay;

    private Date timeMax;
    private Date timeMin;


    public MyDate(Date date, int days) {
        this.date = CalendarUtill.getBeginDay(date, days);
        startDay = CalendarUtill.getBeginDay(date, days);
        endDay = CalendarUtill.getEndDay(date, days);
        max = new BigDecimal("-10000000");
        min = new BigDecimal("100000000000000");
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Date getTimeMax() {
        return timeMax;
    }

    public void setTimeMax(Date timeMax) {
        this.timeMax = timeMax;
    }

    public Date getTimeMin() {
        return timeMin;
    }

    public void setTimeMin(Date timeMin) {
        this.timeMin = timeMin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeMax, timeMin);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MyDate other = (MyDate) obj;
        if(this.timeMax==null ||this.timeMin==null ||other.getTimeMax()==null|| other.getTimeMin()==null)
            return false;
        boolean ans0 = CalendarUtill.check(timeMax,other.getTimeMax());
        boolean ans1 = CalendarUtill.check(timeMin,other.getTimeMin());


        return ans0 && ans1;
    }

    private boolean check(Date time, Date time1) {
        return false;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "max=" + max +
                ", min=" + min +
                ", timeMax=" + timeMax +
                ", timeMin=" + timeMin +
                '}';
    }
}
