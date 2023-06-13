package com.hahnsoftware.codetaskbackend.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeInterval {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
