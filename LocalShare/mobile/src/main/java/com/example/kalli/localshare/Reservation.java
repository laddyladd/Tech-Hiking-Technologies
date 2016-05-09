package com.example.kalli.localshare;

import java.util.Calendar;


/**
 * Created by macbookair5 on 5/9/16.
 */
public class Reservation {

    int startMonth;
    int startDay;
    int startYear;
    int endMonth;
    int endDay;
    int endYear;
    Item.Status status;


    public Reservation(Item.Status status, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear) {
        this.status = status;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startYear = startYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.endYear = endYear;
    }

    public Calendar getStart() {
        Calendar start = Calendar.getInstance();
        start.set(startYear, startMonth, startDay);
        return start;
    }

    public Calendar getEnd() {
        Calendar end = Calendar.getInstance();
        end.set(endYear, endMonth, endDay);
        return end;
    }

    public Item.Status getStatus() {
        return status;
    }
}
