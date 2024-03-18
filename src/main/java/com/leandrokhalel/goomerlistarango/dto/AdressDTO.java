package com.leandrokhalel.goomerlistarango.dto;

public record AdressDTO(
        String state,
        String city,
        String street,
        String district,
        String number,
        String postalCode,
        String complement
) {
}
