package com.gersimuca.customer_management_application.feature.user;

import com.gersimuca.customer_management_application.enumaration.Role;

public record UserDto(String firstname, String lastName, String email, Role role) {}
