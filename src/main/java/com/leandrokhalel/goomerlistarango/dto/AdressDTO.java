package com.leandrokhalel.goomerlistarango.dto;

import com.leandrokhalel.goomerlistarango.model.Adress;

public record AdressDTO(
        String state,
        String city,
        String street,
        String district,
        String number,
        String postalCode,
        String complement
) {

    public AdressDTO(Adress adress) {
        this(adress.getState(), adress.getCity(), adress.getStreet(), adress.getDistrict(), adress.getNumber(), adress.getPostalCode(), adress.getComplement());
    }
}
