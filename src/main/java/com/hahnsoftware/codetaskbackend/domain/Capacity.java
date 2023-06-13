package com.hahnsoftware.codetaskbackend.domain;

import lombok.Data;

@Data
public class Capacity {
    private int maxCapacity;
    private int actualCapacity;

    public boolean hasAvailableSeat() {
        return actualCapacity < maxCapacity;
    }

    public void addAttendant() {
        actualCapacity++;
    }
}
