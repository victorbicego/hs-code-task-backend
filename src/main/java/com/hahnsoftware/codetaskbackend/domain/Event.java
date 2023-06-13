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
}
