package by.softClub.CoffeeShop.controller;


import javax.faces.bean.ManagedBean;

import java.time.LocalDate;
import java.time.LocalTime;


@ManagedBean(name = "time")
public class ViewDateTime {
    static LocalDate date;
    static LocalTime timeTo;
    static LocalTime timeFrom;
    static LocalDate minDate;
    static LocalDate maxDate;
    static LocalTime minTime;
    static LocalTime maxTime;

    public ViewDateTime() {
        init();
    }

    public void init() {
        minDate = LocalDate.now();
        maxDate = LocalDate.now().plusMonths(2);
        minTime = LocalTime.of(9, 0);
        maxTime = LocalTime.of(21, 0);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        ViewDateTime.date = date;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalTime timeTo) {
        ViewDateTime.timeTo = timeTo;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        ViewDateTime.timeFrom = timeFrom;
    }

    public LocalDate getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDate minDate) {
        ViewDateTime.minDate = minDate;
    }

    public LocalDate getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDate maxDate) {
        ViewDateTime.maxDate = maxDate;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        ViewDateTime.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        ViewDateTime.maxTime = maxTime;
    }

}

