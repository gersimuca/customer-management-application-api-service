package com.gersimuca.cma.feature.product;

import java.util.UUID;

public class ProductUtil {
    public static ProductEntity createProductEntity(String productName, String manufacturer, String quantity, String countryOfOrigin) {
        return ProductEntity.builder()
                .productId(UUID.randomUUID())
                .productName(productName)
                .manufacturer(manufacturer)
                .quantity(quantity)
                .countryOfOrigin(countryOfOrigin)
                .build();
    }

    public static ProductEntity updateProductEntity(UUID id, String productName, String manufacturer, String quantity, String countryOfOrigin) {
        return ProductEntity.builder()
                .productId(id)
                .productName(productName)
                .manufacturer(manufacturer)
                .quantity(quantity)
                .countryOfOrigin(countryOfOrigin)
                .build();
    }
}
