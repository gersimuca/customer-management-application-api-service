package com.gersimuca.customer_management_application.dto.mapper;


import com.gersimuca.customer_management_application.dto.ClientDto;
import com.gersimuca.customer_management_application.model.UserEntity;

import java.util.function.Function;

public class ClientDtoMapper implements Function<UserEntity, ClientDto> {
    @Override
    public ClientDto apply(UserEntity userEntity) {
        return new ClientDto(userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getRole());
    }
}
