package com.gersimuca.cma.feature.admin;

import com.gersimuca.cma.common.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
  private final AdminMapper mapper;
  private final AdminRepository repository;

  public AdminDto findAdminById(final Long id) {
    AdminEntity admin =
        repository.findById(id).orElseThrow(() -> new ApiException("Admin not found"));
    return mapper.mapToDto(admin);
  }
}
