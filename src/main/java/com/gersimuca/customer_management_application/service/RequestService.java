package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.model.Client;
import com.gersimuca.customer_management_application.model.Product;
import com.gersimuca.customer_management_application.model.Request;

import java.util.List;
import java.util.UUID;

public interface RequestService {
    Request findRequestById(UUID id);

    void createRequest(Client client);
    void deleteRequestById(UUID id);
    Request updateRequestById(UUID id);
    List<Request> getAllRequest(int offset, int limit);
}
