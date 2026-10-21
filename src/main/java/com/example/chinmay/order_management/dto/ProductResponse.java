package com.example.chinmay.order_management.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String sku,
        String name,
        BigDecimal price,
        int stock
) {
}
