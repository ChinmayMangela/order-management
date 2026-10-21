package com.example.chinmay.order_management.controller;


import com.example.chinmay.order_management.dto.CreateProductRequested;
import com.example.chinmay.order_management.dto.ProductResponse;
import com.example.chinmay.order_management.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody @Valid CreateProductRequested createProductRequested
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(createProductRequested));
    }
}