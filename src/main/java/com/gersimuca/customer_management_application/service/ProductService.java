package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.model.ProductEntity;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductEntity findProductById(UUID id);
    void createProduct(String productName, String manufacturer, String quantity, String countryOfOrigin);
    void deleteProductById(UUID id);
    ProductEntity updateProductById(UUID id, String productName, String manufacturer, String quantity, String countryOfOrigin);
    List<ProductEntity> getAllProductsByRequest(int offset, int limit);
}
