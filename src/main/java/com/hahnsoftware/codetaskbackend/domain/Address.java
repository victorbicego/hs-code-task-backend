package com.hahnsoftware.codetaskbackend.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Address {
    @NotNull
    private String street;
    @NotNull
    private String immobileNumber;
    @NotNull
    private String city;
    @NotNull
    private String postalCode;
}
