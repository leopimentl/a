package com.leandrokhalel.goomerlistarango.dto;

import com.leandrokhalel.goomerlistarango.model.Adress;
import com.leandrokhalel.goomerlistarango.model.Restaurant;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public record RestaurantMinView(
        Long id,
        String name,
        AdressMinView adress
) {
    public RestaurantMinView(Restaurant restaurant) {
        this(restaurant.getId(), restaurant.getName(), new AdressMinView(restaurant.getAdress()));
    }

    private record AdressMinView(
            String state,
            String city
    ) {
        private AdressMinView(Adress adress) {
            this(adress.getState(), adress.getCity());
        }
    }
}
