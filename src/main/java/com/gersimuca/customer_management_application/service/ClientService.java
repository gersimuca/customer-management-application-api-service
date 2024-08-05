package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.model.UserEntity;
import com.gersimuca.customer_management_application.enumaration.Role;

public interface ClientService {
    UserEntity updateClient(String firstName, String lastName, String email, String password, Role role);
    void deleteClient(String email);
}
