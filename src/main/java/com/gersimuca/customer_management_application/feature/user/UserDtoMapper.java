package com.gersimuca.customer_management_application.feature.user;


import java.util.function.Function;

public class UserDtoMapper implements Function<UserEntity, UserDto> {
    @Override
    public UserDto apply(UserEntity userEntity) {
        return new UserDto(userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getRole());
    }
}
