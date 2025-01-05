package com.gersimuca.cma.configuration.security;

import com.gersimuca.cma.common.exception.ApiException;
import com.gersimuca.cma.enumaration.Role;
import com.gersimuca.cma.feature.user.UserDto;
import com.gersimuca.cma.feature.user.UserDtoMapper;
import com.gersimuca.cma.feature.user.UserEntity;
import com.gersimuca.cma.feature.user.UserRepository;
import com.gersimuca.cma.feature.user.UserUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Deprecated
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

  private final UserRepository userRepository;

  @Override
  public Map<?, ?> authenticate(String email, String password) {
    Map<String, Object> data = new HashMap<>();

    UserEntity client = userRepository.findByEmailIgnoreCase(email)
            .orElseThrow(() -> new ApiException("Account not found by email address provided"));

    UserDto userDto = new UserDtoMapper().apply(client);
    data.put("user", userDto);
    return data;
  }

  @Override
  public void register(
      String firstName, String lastName, String email, String password, Role role) {
    Optional<UserEntity> optionalClient = userRepository.findByEmailIgnoreCase(email);
    optionalClient.ifPresent(
        client -> {
          throw new ApiException("Email already exists");
        });

    userRepository.save(UserUtils.createClientEntity(firstName, lastName, email, password, role));
  }
}
