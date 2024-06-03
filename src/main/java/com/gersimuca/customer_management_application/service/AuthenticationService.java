package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.enumaration.Role;

import java.util.Map;

public interface AuthenticationService {
    Map<?, ?> authenticate(String email, String password);
    void register(String firstName, String lastName, String email, String password, Role role);
}
