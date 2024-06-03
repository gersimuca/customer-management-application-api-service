package com.gersimuca.customer_management_application.dto.mapper;


import com.gersimuca.customer_management_application.dto.ClientDto;
import com.gersimuca.customer_management_application.model.Client;

import java.util.function.Function;

public class ClientDtoMapper implements Function<Client, ClientDto> {
    @Override
    public ClientDto apply(Client client) {
        return new ClientDto(client.getFirstName(), client.getLastName(), client.getEmail(), client.getRole());
    }
}
