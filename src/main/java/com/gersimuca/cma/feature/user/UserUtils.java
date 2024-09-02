package com.gersimuca.cma.feature.user;

import com.gersimuca.cma.enumaration.Role;

public class UserUtils {
  public static UserEntity createClientEntity(
      String firstName, String lastName, String email, String password, Role role) {
    return UserEntity.builder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(password)
        .role(role)
        .build();
  }

  public static UserEntity updateClientEntity(
      String firstName, String lastName, String email, String password, Role role) {
    return UserEntity.builder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(password)
        .build();
  }
}
