package com.leandrokhalel.goomerlistarango.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpeningHour {

    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;

}
