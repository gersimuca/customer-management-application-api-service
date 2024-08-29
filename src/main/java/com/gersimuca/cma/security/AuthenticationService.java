package com.gersimuca.cma.security;

import com.gersimuca.cma.enumaration.Role;
import java.util.Map;

public interface AuthenticationService {
  Map<?, ?> authenticate(String email, String password);

  void register(String firstName, String lastName, String email, String password, Role role);
}
