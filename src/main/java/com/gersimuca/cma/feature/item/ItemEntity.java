package com.gersimuca.cma.feature.item;

import com.gersimuca.cma.feature.offer.OfferEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String description;
    private Integer quantity;
    private Double price;
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id")
    private OfferEntity offer;
}
