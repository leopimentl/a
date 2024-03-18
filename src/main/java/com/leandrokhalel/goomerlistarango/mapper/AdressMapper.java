package com.leandrokhalel.goomerlistarango.mapper;

import com.leandrokhalel.goomerlistarango.dto.AdressDTO;
import com.leandrokhalel.goomerlistarango.model.Adress;
import org.springframework.stereotype.Component;

@Component
public class AdressMapper implements Mapper<Adress, AdressDTO> {

    @Override
    public Adress map(AdressDTO source) {
        return Adress.builder()
                .state(source.state())
                .city(source.city())
                .street(source.street())
                .district(source.district())
                .number(source.number())
                .postalCode(source.postalCode())
                .complement(source.complement())
                .build();
    }
}
