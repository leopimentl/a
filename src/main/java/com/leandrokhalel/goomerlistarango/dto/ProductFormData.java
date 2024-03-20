package com.leandrokhalel.goomerlistarango.dto;

import com.leandrokhalel.goomerlistarango.model.Category;

import java.math.BigDecimal;

public record ProductFormData(
        Long restaurantId,
        String name,
        BigDecimal price,
        Category category
) {
}
