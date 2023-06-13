package com.hahnsoftware.codetaskbackend.infrastructure;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Embeddable
public class TimeIntervalEntity {
    @NotNull
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
