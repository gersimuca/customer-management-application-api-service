package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.model.UserEntity;
import com.gersimuca.customer_management_application.model.RequestEntity;

import java.util.List;
import java.util.UUID;

public interface RequestService {
    RequestEntity findRequestById(UUID id);

    void createRequest(UserEntity userEntity);
    void deleteRequestById(UUID id);
    RequestEntity updateRequestById(UUID id);
    List<RequestEntity> getAllRequest(int offset, int limit);
}
