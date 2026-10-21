package com.example.chinmay.order_management.mappers;

import com.example.chinmay.order_management.dto.ProductResponse;
import com.example.chinmay.order_management.entity.ProductEntity;

public class ProductMapper {
    public static ProductResponse toProductResponse(ProductEntity productEntity) {
        return new ProductResponse(
                productEntity.getId(),
                productEntity.getSku(),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getStock()
        );
    }
}
