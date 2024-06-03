package com.gersimuca.customer_management_application.dto;

import com.gersimuca.customer_management_application.enumaration.Role;

public record ClientDto(String firstname, String lastName, String email, Role role) {}
