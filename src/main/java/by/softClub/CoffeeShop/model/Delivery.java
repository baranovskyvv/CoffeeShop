package by.softClub.CoffeeShop.model;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
public class Delivery {

    static Integer cost = 3;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "timeFrom")
    private LocalDateTime timeFrom;
    @Column(name = "timeTo")
    private LocalDateTime timeTo;

    public Delivery(String address, LocalDateTime timeFrom, LocalDateTime timeTo) {
        this.address = address;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public Delivery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

    @Override
    public String toString() {
        if (timeTo == null || timeFrom == null) {
            return "по адресу: " + address;
        } else
            return "c " + timeFrom.getHour() + "." + timeFrom.getMinute() +
                    " по " + timeTo.getHour() + "." + timeTo.getMinute() + " " + timeTo.getDayOfMonth() + "." +
                    timeTo.getMonthValue() + "." + timeTo.getYear() + "по адресу: " + address;
    }
}