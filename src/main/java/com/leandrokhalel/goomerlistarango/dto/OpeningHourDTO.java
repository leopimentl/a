package com.leandrokhalel.goomerlistarango.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record OpeningHourDTO(
        DayOfWeek day,
        LocalTime open,
        LocalTime close
) {
}
