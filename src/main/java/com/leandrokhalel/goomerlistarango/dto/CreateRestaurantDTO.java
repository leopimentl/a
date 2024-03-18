package com.leandrokhalel.goomerlistarango.dto;

import java.util.List;

public record CreateRestaurantDTO(
        String name,
        AdressDTO adress,
        List<OpeningHourDTO> openingHours
) {
}
