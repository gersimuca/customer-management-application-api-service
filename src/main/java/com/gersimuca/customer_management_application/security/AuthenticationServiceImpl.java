package com.gersimuca.customer_management_application.security;

import com.gersimuca.customer_management_application.feature.user.UserDto;
import com.gersimuca.customer_management_application.feature.user.UserDtoMapper;
import com.gersimuca.customer_management_application.enumaration.Role;
import com.gersimuca.customer_management_application.exception.ApiException;
import com.gersimuca.customer_management_application.feature.user.UserEntity;
import com.gersimuca.customer_management_application.feature.user.UserRepository;
import com.gersimuca.customer_management_application.feature.user.UserUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Override
    public Map<?, ?> authenticate(String email, String password) {
        Map<String, Object> data = new HashMap<>();

        Optional<UserEntity> client = userRepository.findByEmailIgnoreCase(email);
        if(client.isEmpty()) client.orElseThrow(() -> new ApiException("Account not found by email address provided"));

        UserDto userDto = new UserDtoMapper().apply(client.get());
        data.put("user", userDto);
        return data;
    }

    @Override
    public void register(String firstName, String lastName, String email, String password, Role role){
        Optional<UserEntity> optionalClient = userRepository.findByEmailIgnoreCase(email);
        optionalClient.ifPresent(client -> {
            throw new ApiException("Email already exists");
        });

        userRepository.save(UserUtils.createClientEntity(firstName, lastName, email, password, role));
    }
}
