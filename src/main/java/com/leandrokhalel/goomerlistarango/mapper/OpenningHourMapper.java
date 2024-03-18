package com.leandrokhalel.goomerlistarango.mapper;

import com.leandrokhalel.goomerlistarango.dto.OpeningHourDTO;
import com.leandrokhalel.goomerlistarango.model.OpeningHour;
import com.leandrokhalel.goomerlistarango.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpenningHourMapper implements Mapper<OpeningHour, OpeningHourDTO> {

    @Override
    public OpeningHour map(OpeningHourDTO source) {
        return OpeningHour.builder()
                .day(source.day())
                .startTime(source.open())
                .endTime(source.close())
                .build();
    }

    public List<OpeningHour> map(List<OpeningHour> source, Restaurant restaurant) {
       return source.stream()
               .peek(openingHour -> openingHour.setRestaurant(restaurant))
               .toList();
    }
}
