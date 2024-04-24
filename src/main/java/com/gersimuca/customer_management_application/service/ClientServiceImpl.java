package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.model.ClientEntity;
import com.gersimuca.customer_management_application.enumaration.Role;
import com.gersimuca.customer_management_application.exception.ApiException;
import com.gersimuca.customer_management_application.repository.ClientRepository;
import com.gersimuca.customer_management_application.utils.ClientUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public void createClient(String firstName, String lastName, String email, String password, Role role){
        clientRepository.save(ClientUtils.createClientEntity(firstName, lastName, email, password, role));
    }

    @Override
    public ClientEntity updateClient(String firstName, String lastName, String email, String password, Role role) {
        Optional<ClientEntity> client = clientRepository.findByEmailIgnoreCase(email);
        client.ifPresent(clientEntity -> clientRepository.save(ClientUtils.updateClientEntity(firstName, lastName, email, password, role)));
        return client.orElseThrow(()-> new ApiException("Client not found with email: " + email));
    }

    @Override
    public void deleteClient(String email) {
        Optional<ClientEntity> client = clientRepository.findByEmailIgnoreCase(email);
        client.ifPresentOrElse(clientRepository::delete, () -> { throw new ApiException("Client not found with email: " + email);});
    }
}
