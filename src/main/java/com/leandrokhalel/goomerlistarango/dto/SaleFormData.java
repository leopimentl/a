package com.leandrokhalel.goomerlistarango.dto;

import com.leandrokhalel.goomerlistarango.model.SaleDayHour;

import java.util.List;

public record SaleFormData(
        Long productId,
        String description,
        Integer discountPercentage,
        List<SaleDayHour> saleDayHours
) {
}
