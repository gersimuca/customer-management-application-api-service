package com.gersimuca.customer_management_application.utils;

import com.gersimuca.customer_management_application.model.Client;
import com.gersimuca.customer_management_application.enumaration.Role;

public class ClientUtils {
    public static Client createClientEntity(String firstName, String lastName, String email, String password, Role role) {
        return Client.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

    public static Client updateClientEntity(String firstName, String lastName, String email, String password, Role role) {
        return Client.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }
}
