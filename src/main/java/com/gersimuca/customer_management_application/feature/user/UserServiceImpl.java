package com.gersimuca.customer_management_application.feature.user;

import com.gersimuca.customer_management_application.enumaration.Role;
import com.gersimuca.customer_management_application.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity updateClient(String firstName, String lastName, String email, String password, Role role) {
        Optional<UserEntity> client = userRepository.findByEmailIgnoreCase(email);
        client.ifPresent(clientEntity -> userRepository.save(UserUtils.updateClientEntity(firstName, lastName, email, password, role)));
        return client.orElseThrow(()-> new ApiException("Client not found with email: " + email));
    }

    @Override
    public void deleteClient(String email) {
        Optional<UserEntity> client = userRepository.findByEmailIgnoreCase(email);
        client.ifPresentOrElse(userRepository::delete, () -> { throw new ApiException("Client not found with email: " + email);});
    }
}
