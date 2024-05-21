package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product findProductById(UUID id);
    void createProduct(String productName, String manufacturer, String quantity, String countryOfOrigin);
    void deleteProductById(UUID id);
    Product updateProductById(UUID id, String productName, String manufacturer, String quantity, String countryOfOrigin);
    List<Product> getAllProductsByRequest(int offset, int limit);
}
