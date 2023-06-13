package com.hahnsoftware.codetaskbackend.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private double price;
    private String description;
    @Embedded
    @NotNull
    private AddressEntity address;
    @Embedded
    @NotNull
    private TimeIntervalEntity timeInterval;
    @Embedded
    @NotNull
    private CapacityEntity capacity;
}
