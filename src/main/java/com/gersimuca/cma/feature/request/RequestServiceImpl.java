package com.gersimuca.cma.feature.request;

import com.gersimuca.cma.exception.ApiException;
import com.gersimuca.cma.feature.user.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{
    private final RequestRepository repository;


    @Override
    public RequestEntity findRequestById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiException("Request not found"));
    }

    @Override
    public void createRequest(UserEntity userEntity) {

    }

    @Override
    public void deleteRequestById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public RequestEntity updateRequestById(UUID id) {
        // Incomplete
        RequestEntity requestEntity = repository.findById(id)
                .orElseThrow(() -> new ApiException("Request not found"));

        return requestEntity;
    }

    @Override
    public List<RequestEntity> getAllRequest(int offset, int limit) {
        return List.of();
    }
}
