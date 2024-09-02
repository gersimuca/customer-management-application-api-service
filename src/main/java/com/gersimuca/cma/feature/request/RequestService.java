package com.gersimuca.cma.feature.request;

import com.gersimuca.cma.feature.user.UserEntity;
import java.util.List;
import java.util.UUID;

public interface RequestService {
  RequestEntity findRequestById(UUID id);

  void createRequest(UserEntity userEntity);

  void deleteRequestById(UUID id);

  RequestEntity updateRequestById(UUID id);

  List<RequestEntity> getAllRequest(int offset, int limit);
}
