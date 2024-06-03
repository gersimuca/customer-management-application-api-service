package com.gersimuca.customer_management_application.controller.v1;

import com.gersimuca.customer_management_application.domain.Response;
import com.gersimuca.customer_management_application.dto.request.AuthenticationRequest;
import com.gersimuca.customer_management_application.dto.request.ClientRequest;
import com.gersimuca.customer_management_application.enumaration.Role;
import com.gersimuca.customer_management_application.service.AuthenticationService;
import com.gersimuca.customer_management_application.service.ClientService;
import com.gersimuca.customer_management_application.utils.RequestUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

import static java.util.Collections.emptyMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/client")
@Log4j2
public class AuthenticationController {

    private final ClientService clientService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Response> saveClient(@RequestBody ClientRequest client, HttpServletRequest request){
        clientService.createClient(client.getFirstName(), client.getLastName(), client.getEmail(), client.getPassword(), Role.USER);
        log.info("Client with FirstName: {}, LastName: {}, Email: {}, Password: {} and Role: {} register successfully", client.getFirstName(), client.getLastName(), client.getEmail(), client.getPassword(), Role.USER);
        return ResponseEntity.created(getUri()).body(RequestUtils.getResponse(request, emptyMap(), "Account created successfully! Pleas Login...", HttpStatus.CREATED));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthenticationRequest auth, HttpServletRequest request){
        Map<?,?> data = authenticationService.authenticate(auth.getEmail(), auth.getEmail());

        String successMessage = "Account login successfully!";

        URI location = getUri();

        Response responseBody = RequestUtils.getResponse(request, data, successMessage, HttpStatus.CREATED);

        log.info("User with email {} logged in", auth.getEmail());

        return ResponseEntity.created(location).body(responseBody);
    }

    private URI getUri() {
        return URI.create("");
    }
}
