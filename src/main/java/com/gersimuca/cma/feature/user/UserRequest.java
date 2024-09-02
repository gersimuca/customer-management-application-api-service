package com.gersimuca.cma.feature.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
  @NotEmpty(message = "FirstName cannot be empty or null")
  private String firstName;

  @NotEmpty(message = "LastName cannot be empty or null")
  private String lastName;

  @NotEmpty(message = "Email cannot be empty or null")
  @Email(message = "Invalid email address")
  private String email;

  @NotEmpty(message = "Password cannot be empty or null")
  private String password;

  @Override
  public String toString() {
    return "ClientRequest{"
        + "firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", email='"
        + email
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
}
