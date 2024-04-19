package com.gersimuca.customer_management_application.utils;

import com.gersimuca.customer_management_application.model.ClientEntity;
import com.gersimuca.customer_management_application.enumaration.Role;

public class ClientUtils {
    public static ClientEntity createClientEntity(String firstName, String lastName, String email, String password, Role role) {
        return ClientEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

    public static ClientEntity updateClientEntity(String firstName, String lastName, String email, String password, Role role) {
        return ClientEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }
}
