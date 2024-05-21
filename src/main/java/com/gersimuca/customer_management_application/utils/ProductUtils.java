package com.gersimuca.customer_management_application.utils;

import com.gersimuca.customer_management_application.model.Product;

import java.util.UUID;

public class ProductUtils {
    public static Product createProductEntity(String productName, String manufacturer, String quantity, String countryOfOrigin) {
        return Product.builder()
                .productId(UUID.randomUUID())
                .productName(productName)
                .manufacturer(manufacturer)
                .quantity(quantity)
                .countryOfOrigin(countryOfOrigin)
                .build();
    }

    public static Product updateProductEntity(UUID id, String productName, String manufacturer, String quantity, String countryOfOrigin) {
        return Product.builder()
                .productId(id)
                .productName(productName)
                .manufacturer(manufacturer)
                .quantity(quantity)
                .countryOfOrigin(countryOfOrigin)
                .build();
    }
}
