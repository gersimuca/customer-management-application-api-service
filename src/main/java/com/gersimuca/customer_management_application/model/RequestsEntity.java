package com.gersimuca.customer_management_application.model;

import com.gersimuca.customer_management_application.enumaration.StatusRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "requests")

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestsEntity {
    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "status")
    private StatusRequest status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
