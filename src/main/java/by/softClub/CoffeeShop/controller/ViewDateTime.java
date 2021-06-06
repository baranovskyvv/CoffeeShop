package by.softClub.CoffeeShop.controller;


import javax.faces.bean.ManagedBean;
import java.time.LocalDate;
import java.time.LocalTime;

@ManagedBean(name = "time")
public class ViewDateTime {
    static LocalDate date;
    static LocalTime timeTo;
    static LocalTime timeFrom;
    private LocalDate minDate;
    private LocalDate maxDate;
    private LocalTime minTime;
    private LocalTime maxTime;

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
        this.date = date;
        if (date.equals(minDate)) {
            minTime = LocalTime.now();
        }
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDate getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDate minDate) {
        this.minDate = minDate;
    }

    public LocalDate getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDate maxDate) {
        this.maxDate = maxDate;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }
}

