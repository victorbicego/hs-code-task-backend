package com.hahnsoftware.codetaskbackend.infrastructure.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Embeddable
public class AddressEntity {
    @NotNull
    private String street;
    @NotNull
    private String immobileNumber;
    @NotNull
    private String city;
    @NotNull
    private String postalCode;
}
