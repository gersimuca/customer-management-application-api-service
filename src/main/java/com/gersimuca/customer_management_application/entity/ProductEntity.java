package com.gersimuca.customer_management_application.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "product")

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "product_name", unique = true)
    private String productName;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;
}


