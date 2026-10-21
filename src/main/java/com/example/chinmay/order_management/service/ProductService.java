package com.example.chinmay.order_management.service;

import com.example.chinmay.order_management.dto.CreateProductRequested;
import com.example.chinmay.order_management.dto.ProductResponse;
import com.example.chinmay.order_management.entity.ProductEntity;
import com.example.chinmay.order_management.mappers.ProductMapper;
import com.example.chinmay.order_management.repository.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(CreateProductRequested createProductRequested) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setSku(createProductRequested.sku());
        productEntity.setName(createProductRequested.name());
        productEntity.setPrice(createProductRequested.price());
        productEntity.setStock(createProductRequested.stock());

        productRepository.save(productEntity);
        return ProductMapper.toProductResponse(productEntity);

    }
}
