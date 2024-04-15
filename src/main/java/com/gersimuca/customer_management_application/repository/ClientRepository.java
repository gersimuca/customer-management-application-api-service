package com.gersimuca.customer_management_application.repository;

import com.gersimuca.customer_management_application.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByEmailIgnoreCase(String email);
}
