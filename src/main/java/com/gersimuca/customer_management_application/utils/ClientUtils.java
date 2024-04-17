package com.gersimuca.customer_management_application.utils;

import com.gersimuca.customer_management_application.model.ClientEntity;
import com.gersimuca.customer_management_application.enumaration.Role;

import java.util.UUID;

public class ClientUtils {
    public static ClientEntity createClientEntity(String firstName, String lastName, String email, String password, Role role){
        return ClientEntity.builder()
                .client_id(UUID.randomUUID())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }

    public static ClientEntity updateClientEntity(UUID clientId, String firstName, String lastName, String email, String password, Role role){
        return ClientEntity.builder()
                .client_id(clientId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }
}
