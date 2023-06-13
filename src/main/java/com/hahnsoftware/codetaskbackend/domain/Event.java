package com.hahnsoftware.codetaskbackend.domain;

import com.hahnsoftware.codetaskbackend.exceptions.AttendantNotSubscribedException;
import lombok.Data;

@Data
public class Event {
    private Long id;
    private String title;
    private String description;
    private double price;
    private Address address;
    private Capacity capacity;
    private TimeInterval timeInterval;

    public void subscribeAttendant() throws AttendantNotSubscribedException {
        if (capacity.hasAvailableSeat()) {
            capacity.addAttendant();
        } else {
            throw new AttendantNotSubscribedException("Event has no available seat.");
        }
    }
}
