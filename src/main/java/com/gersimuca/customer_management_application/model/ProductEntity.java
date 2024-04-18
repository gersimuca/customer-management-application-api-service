package com.gersimuca.customer_management_application.model;


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
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column(insertable=false, updatable=false, name = "product_id")
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


