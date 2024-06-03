package com.gersimuca.customer_management_application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    @NotEmpty(message = "Product name cannot be empty or null")
    private String productName;
    @NotEmpty(message = "Manufacturer cannot be empty or null")
    private String manufacturer;
    @NotEmpty(message = "Quantity cannot be empty or null")
    private String quantity;
    @NotEmpty(message = "Country Of Origin cannot be empty or null")
    private String countryOfOrigin;

    @Override
    public String toString() {
        return "ProductRequest{" +
                "ProductName='" + productName + '\'' +
                ", Manufacturer='" + manufacturer + '\'' +
                ", Quantity='" + quantity + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                '}';
    }
}
