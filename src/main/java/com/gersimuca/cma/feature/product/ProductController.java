package com.gersimuca.cma.feature.product;

import com.gersimuca.cma.domain.Response;
import com.gersimuca.cma.feature.request.RequestUtil;
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
        return ResponseEntity.created(getUri()).body(RequestUtil.getResponse(request, emptyMap(), "Product created successfully!", HttpStatus.CREATED));
    }

    @GetMapping
    public ResponseEntity<Response> getProducts(@RequestParam int offset, @RequestParam int limit, HttpServletRequest request){
        List<ProductEntity> products = productService.getAllProductsByRequest(offset, limit);
        log.warn(products);
        return ResponseEntity.ok(RequestUtil.getResponse(request, Map.of("products", products), "Products retrieved successfully.", HttpStatus.OK));
    }

    private URI getUri() {
        return URI.create("");
    }

}
