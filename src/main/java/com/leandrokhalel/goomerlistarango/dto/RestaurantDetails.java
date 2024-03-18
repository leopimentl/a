package com.leandrokhalel.goomerlistarango.dto;

import com.leandrokhalel.goomerlistarango.model.Restaurant;

import java.util.List;

public record RestaurantDetails(
        Long id,
        String name,
        AdressDTO adress,
        List<OpeningHourDTO> openingHours
) {

    public RestaurantDetails(Restaurant restaurant) {
        this(restaurant.getId(), restaurant.getName(), new AdressDTO(restaurant.getAdress()),
                restaurant.getOpeningHours().stream().map(OpeningHourDTO::new).toList());
    }
}
