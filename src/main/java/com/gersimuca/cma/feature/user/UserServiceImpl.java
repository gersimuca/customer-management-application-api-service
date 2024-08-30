package com.gersimuca.cma.feature.user;

import com.gersimuca.cma.common.exception.ApiException;
import com.gersimuca.cma.enumaration.Role;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserEntity updateClient(
      String firstName, String lastName, String email, String password, Role role) {
    Optional<UserEntity> client = userRepository.findByEmailIgnoreCase(email);
    client.ifPresent(
        clientEntity ->
            userRepository.save(
                UserUtils.updateClientEntity(firstName, lastName, email, password, role)));
    return client.orElseThrow(() -> new ApiException("Client not found with email: " + email));
  }

  @Override
  public void deleteClient(String email) {
    Optional<UserEntity> client = userRepository.findByEmailIgnoreCase(email);
    client.ifPresentOrElse(
        userRepository::delete,
        () -> {
          throw new ApiException("Client not found with email: " + email);
        });
  }
}
