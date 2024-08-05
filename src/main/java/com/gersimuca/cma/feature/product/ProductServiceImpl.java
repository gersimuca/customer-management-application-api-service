package com.gersimuca.cma.feature.product;

import com.gersimuca.cma.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity findProductById(UUID id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        return product.orElseThrow(()-> new ApiException("Product not found!"));
    }

    @Override
    public void createProduct(String productName, String manufacturer, String quantity, String countryOfOrigin) {
        productRepository.save(ProductUtil.createProductEntity(productName, manufacturer, quantity, countryOfOrigin));
    }

    @Override
    public void deleteProductById(UUID id) {
        Optional<ProductEntity> client = productRepository.findById(id);
        client.ifPresentOrElse(productRepository::delete, () -> { throw new ApiException("Product not found!");});
    }

    @Override
    public ProductEntity updateProductById(UUID id, String productName, String manufacturer, String quantity, String countryOfOrigin) {
            Optional<ProductEntity> product = productRepository.findById(id);
            product.ifPresent(productEntity -> productRepository.save(ProductUtil.updateProductEntity(id,productName, manufacturer,quantity,countryOfOrigin)));
            return product.orElseThrow(()-> new ApiException("Product not found!"));
    }

    @Override
    public List<ProductEntity> getAllProductsByRequest(int offset, int limit) {
        if(limit > 5) throw new ApiException("Cannot fetch data with custom limit");
        Optional<List<ProductEntity>> products = productRepository.getAll(PageRequest.of(offset, limit));
        return products.orElseThrow(()-> new ApiException("Products not found!"));
    }
}
