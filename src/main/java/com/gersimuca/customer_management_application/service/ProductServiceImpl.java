package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.exception.ApiException;
import com.gersimuca.customer_management_application.model.ClientEntity;
import com.gersimuca.customer_management_application.model.ProductEntity;
import com.gersimuca.customer_management_application.repository.ProductRepository;
import com.gersimuca.customer_management_application.utils.ClientUtils;
import com.gersimuca.customer_management_application.utils.ProductUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public ProductEntity findProductById(UUID id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        return product.orElseThrow(()-> new ApiException("Product not found!"));
    }

    @Override
    public void createProduct(String productName, String manufacturer, String quantity, String countryOfOrigin) {
        productRepository.save(ProductUtils.createProductEntity(productName, manufacturer, quantity, countryOfOrigin));
    }

    @Override
    public void deleteProductById(UUID id) {
        Optional<ProductEntity> client = productRepository.findById(id);
        client.ifPresentOrElse(productRepository::delete, () -> { throw new ApiException("Product not found!");});
    }

    @Override
    public ProductEntity updateProductById(UUID id, String productName, String manufacturer, String quantity, String countryOfOrigin) {
            Optional<ProductEntity> product = productRepository.findById(id);
            product.ifPresent(productEntity -> productRepository.save(ProductUtils.updateProductEntity(id,productName, manufacturer,quantity,countryOfOrigin)));
            return product.orElseThrow(()-> new ApiException("Product not found!"));
    }

    @Override
    public List<ProductEntity> getAllProductsByRequest(int offset, int limit) {
        Optional<List<ProductEntity>> products = productRepository.getAll(PageRequest.of(offset, limit));
        return products.orElseThrow(()-> new ApiException("Products not found!"));
    }
}
