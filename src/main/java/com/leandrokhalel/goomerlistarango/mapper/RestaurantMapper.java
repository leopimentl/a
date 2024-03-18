package com.leandrokhalel.goomerlistarango.mapper;

import com.leandrokhalel.goomerlistarango.dto.CreateRestaurantDTO;
import com.leandrokhalel.goomerlistarango.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantMapper implements Mapper<Restaurant, CreateRestaurantDTO> {

    private final AdressMapper adressMapper;
    private final OpenningHourMapper openningHourMapper;

    @Override
    public Restaurant map(CreateRestaurantDTO source)  {
        return Restaurant.builder()
                .name(source.name())
                .adress(adressMapper.map(source.adress()))
                .openingHours(source.openingHours().stream().map(openningHourMapper::map).toList())
                .build();
    }
}
