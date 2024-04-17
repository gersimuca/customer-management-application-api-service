package com.gersimuca.customer_management_application.controller;

import com.gersimuca.customer_management_application.domain.Response;
import com.gersimuca.customer_management_application.dto.ClientRequest;
import com.gersimuca.customer_management_application.enumaration.Role;
import com.gersimuca.customer_management_application.service.ClientService;
import com.gersimuca.customer_management_application.utils.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static java.util.Collections.emptyMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;
    @PostMapping("/register/")
    public ResponseEntity<Response> saveClient(@RequestBody @Valid ClientRequest client, HttpServletRequest request){
        clientService.createClient(client.getFirstName(), client.getLastName(), client.getEmail(), client.getPassword(), Role.USER);
        return ResponseEntity.created(getUri()).body(RequestUtils.getResponse(request, emptyMap(), "Account created successfully! Pleas Login...", HttpStatus.CREATED));
    }

    private URI getUri() {
        return URI.create("");
    }

}
