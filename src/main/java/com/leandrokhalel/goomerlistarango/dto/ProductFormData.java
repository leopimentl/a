package com.leandrokhalel.goomerlistarango.dto;

import com.leandrokhalel.goomerlistarango.model.Category;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductFormData(

        @NotNull
        Long restaurantId,

        @NotBlank
        String name,

        @NotNull
        @Positive
        BigDecimal price,

        @NotNull
        Category category
) {
}
