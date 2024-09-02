package com.gersimuca.cma.feature.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
  private final AdminService service;
  private final AdminMapper mapper;

  @GetMapping("/{id}")
  public ResponseEntity<AdminResponse> findAdminById(@PathVariable final Long id) {
    return ResponseEntity.ok(mapper.mapToResponse(service.findAdminById(id)));
  }
}
