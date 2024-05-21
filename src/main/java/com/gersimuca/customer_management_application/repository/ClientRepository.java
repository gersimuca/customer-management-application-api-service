package com.gersimuca.customer_management_application.repository;

import com.gersimuca.customer_management_application.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByEmailIgnoreCase(String email);
}
