package com.gersimuca.customer_management_application.repository;

import com.gersimuca.customer_management_application.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
