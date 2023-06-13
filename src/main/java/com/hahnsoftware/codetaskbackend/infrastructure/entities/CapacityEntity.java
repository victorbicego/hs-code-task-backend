package com.hahnsoftware.codetaskbackend.infrastructure.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Embeddable
public class CapacityEntity {
    @NotNull
    private int maxCapacity;
    private int actualCapacity;
}
