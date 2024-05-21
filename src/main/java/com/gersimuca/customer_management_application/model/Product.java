package com.gersimuca.customer_management_application.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "product_id", columnDefinition = "uuid", updatable = false, nullable = false)
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


