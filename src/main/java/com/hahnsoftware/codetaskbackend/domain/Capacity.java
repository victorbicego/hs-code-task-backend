package com.hahnsoftware.codetaskbackend.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Capacity {
    @NotNull
    private int maxCapacity;
    private int actualCapacity;

    public boolean hasAvailableSeat() {
        return actualCapacity < maxCapacity;
    }

    public void addAttendant() {
        actualCapacity++;
    }
}
