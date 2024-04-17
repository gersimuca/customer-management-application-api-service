package com.gersimuca.customer_management_application.repository;

import com.gersimuca.customer_management_application.model.RequestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestRepository extends JpaRepository<RequestsEntity, UUID> {
}
