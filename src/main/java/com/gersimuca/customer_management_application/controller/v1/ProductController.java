package com.gersimuca.customer_management_application.controller.v1;

import com.gersimuca.customer_management_application.domain.Response;
import com.gersimuca.customer_management_application.dto.ProductRequest;
import com.gersimuca.customer_management_application.model.Product;
import com.gersimuca.customer_management_application.service.ProductService;
import com.gersimuca.customer_management_application.utils.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
@Log4j2
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Response> saveClient(@Valid @RequestBody ProductRequest product, HttpServletRequest request){
        log.warn(product);
        productService.createProduct(product.getProductName(), product.getManufacturer(), product.getQuantity(), product.getCountryOfOrigin());
        return ResponseEntity.created(getUri()).body(RequestUtils.getResponse(request, emptyMap(), "Product created successfully!", HttpStatus.CREATED));
    }

    @GetMapping
    public ResponseEntity<Response> getProducts(@RequestParam int offset, @RequestParam int limit, HttpServletRequest request){
        List<Product> products = productService.getAllProductsByRequest(offset, limit);
        log.warn(products);
        return ResponseEntity.ok(RequestUtils.getResponse(request, Map.of("products", products), "Products retrieved successfully.", HttpStatus.OK));
    }

    private URI getUri() {
        return URI.create("");
    }

}
