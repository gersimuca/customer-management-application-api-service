package com.gersimuca.cma.feature.user;

import com.gersimuca.cma.enumaration.Role;

public record UserDto(String firstname, String lastName, String email, Role role) {}
