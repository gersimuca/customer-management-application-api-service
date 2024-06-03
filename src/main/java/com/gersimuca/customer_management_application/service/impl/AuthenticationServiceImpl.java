package com.gersimuca.customer_management_application.service.impl;

import com.gersimuca.customer_management_application.dto.ClientDto;
import com.gersimuca.customer_management_application.dto.mapper.ClientDtoMapper;
import com.gersimuca.customer_management_application.enumaration.Role;
import com.gersimuca.customer_management_application.exception.ApiException;
import com.gersimuca.customer_management_application.model.Client;
import com.gersimuca.customer_management_application.repository.ClientRepository;
import com.gersimuca.customer_management_application.service.AuthenticationService;
import com.gersimuca.customer_management_application.utils.ClientUtils;
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

    private final ClientRepository clientRepository;

    @Override
    public Map<?, ?> authenticate(String email, String password) {
        Map<String, Object> data = new HashMap<>();

        Optional<Client> client = clientRepository.findByEmailIgnoreCase(email);
        if(client.isEmpty()) client.orElseThrow(() -> new ApiException("Account not found by email address provided"));

        ClientDto clientDto = new ClientDtoMapper().apply(client.get());
        data.put("user", clientDto);
        return data;
    }

    @Override
    public void register(String firstName, String lastName, String email, String password, Role role){
        Optional<Client> optionalClient = clientRepository.findByEmailIgnoreCase(email);
        optionalClient.ifPresent(client -> {
            throw new ApiException("Email already exists");
        });

        clientRepository.save(ClientUtils.createClientEntity(firstName, lastName, email, password, role));
    }
}
