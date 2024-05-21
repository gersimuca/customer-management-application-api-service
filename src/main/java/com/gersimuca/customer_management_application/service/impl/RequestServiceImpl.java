package com.gersimuca.customer_management_application.service.impl;

import com.gersimuca.customer_management_application.exception.ApiException;
import com.gersimuca.customer_management_application.model.Client;
import com.gersimuca.customer_management_application.model.Request;
import com.gersimuca.customer_management_application.repository.RequestRepository;
import com.gersimuca.customer_management_application.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{
    private final RequestRepository requestRepository;


    @Override
    public Request findRequestById(UUID id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ApiException("Request not found"));
    }

    @Override
    public void createRequest(Client client) {

    }

    @Override
    public void deleteRequestById(UUID id) {
        requestRepository.deleteById(id);
    }

    @Override
    public Request updateRequestById(UUID id) {
        // Incomplete
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new ApiException("Request not found"));

        return request;
    }

    @Override
    public List<Request> getAllRequest(int offset, int limit) {
        return List.of();
    }
}
