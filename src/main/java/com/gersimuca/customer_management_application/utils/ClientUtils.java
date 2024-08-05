package com.gersimuca.customer_management_application.utils;

import com.gersimuca.customer_management_application.model.UserEntity;
import com.gersimuca.customer_management_application.enumaration.Role;

public class ClientUtils {
    public static UserEntity createClientEntity(String firstName, String lastName, String email, String password, Role role) {
        return UserEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

    public static UserEntity updateClientEntity(String firstName, String lastName, String email, String password, Role role) {
        return UserEntity.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }
}
