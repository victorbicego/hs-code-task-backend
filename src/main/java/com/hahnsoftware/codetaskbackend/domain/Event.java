package com.hahnsoftware.codetaskbackend.domain;

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

    public subscribeAttendant(){
        if(capacity.hasAvailableSeat()){
            capacity.addAttendant();
        }else{
            throw new EventNotSubscribedException("Event has no available seat.");
        }
    }
}
