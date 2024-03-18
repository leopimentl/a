package com.leandrokhalel.goomerlistarango.dto;

import com.leandrokhalel.goomerlistarango.model.OpeningHour;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record OpeningHourDTO(
        DayOfWeek day,
        LocalTime open,
        LocalTime close
) {

    public OpeningHourDTO(OpeningHour openingHour) {
        this(openingHour.getDay(), openingHour.getStartTime(), openingHour.getEndTime());
    }
}
