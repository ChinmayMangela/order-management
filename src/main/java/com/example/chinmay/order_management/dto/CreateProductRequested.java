package com.example.chinmay.order_management.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateProductRequested(
        @NotBlank(message = BLANK_SKU_MESSAGE)
        String sku,

        @NotBlank(message = BLANK_NAME_MESSAGE)
        @Size(min = 2, max = 255, message = NAME_LENGTH_MESSAGE)
        String name,

        @NotNull(message = NULL_PRICE_MESSAGE)
        @PositiveOrZero(message = NEG_PRICE_MESSAGE)
        @Digits(integer = 6, fraction = 2, message = INVALID_PRICE_MESSAGE)
        BigDecimal price,

        @PositiveOrZero(message = NEG_STOCK_MESSAGE)
        int stock
) {
    private static final String BLANK_SKU_MESSAGE = "SKU is mandatory";
    private static final String BLANK_NAME_MESSAGE = "Product name is mandatory";
    private static final String NAME_LENGTH_MESSAGE = "product name must be between 2 to 255 characters long";
    private static final  String NULL_PRICE_MESSAGE = "Product price is mandatory";
    private static final String NEG_PRICE_MESSAGE = "Product price cannot be negative";

    private static final String INVALID_PRICE_MESSAGE = "Price must be upto 100000 dollars";
    private static final String NEG_STOCK_MESSAGE = "Stock cannot be negative";


}
