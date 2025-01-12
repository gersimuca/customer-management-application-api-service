package com.gersimuca.cma.feature.user;

import com.gersimuca.cma.enumaration.Role;

public class UserUtils {
  public static UserEntity createClientEntity(
      String firstName, String lastName, String email, String password, Role role) {
    return UserEntity.builder().givenName(firstName).familyName(lastName).email(email).build();
  }

  public static UserEntity updateClientEntity(
      String firstName, String lastName, String email, String password, Role role) {
    return UserEntity.builder().givenName(firstName).familyName(lastName).email(email).build();
  }
}
