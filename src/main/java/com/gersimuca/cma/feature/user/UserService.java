package com.gersimuca.cma.feature.user;

import com.gersimuca.cma.enumaration.Role;

public interface UserService {
  UserEntity updateClient(
      String firstName, String lastName, String email, String password, Role role);

  void deleteClient(String email);
}
