package com.gersimuca.customer_management_application.feature.user;

import com.gersimuca.customer_management_application.enumaration.Role;

public interface UserService {
    UserEntity updateClient(String firstName, String lastName, String email, String password, Role role);
    void deleteClient(String email);
}
