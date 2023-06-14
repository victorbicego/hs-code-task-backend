package com.hahnsoftware.codetaskbackend.domain;

import com.hahnsoftware.codetaskbackend.exceptions.AttendantNotSubscribedException;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Event {
    private Long id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private double price;
    @NotNull
    private Address address;
    @NotNull
    private Capacity capacity;
    @NotNull
    private TimeInterval timeInterval;

    public void subscribeAttendant() throws AttendantNotSubscribedException {
        if (capacity.hasAvailableSeat()) {
            capacity.addAttendant();
        } else {
            throw new AttendantNotSubscribedException("Event has no available seat.");
        }
    }
}
