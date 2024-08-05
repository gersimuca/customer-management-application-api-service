package com.gersimuca.customer_management_application.security;

import com.gersimuca.customer_management_application.domain.Response;
import com.gersimuca.customer_management_application.feature.user.UserService;
import com.gersimuca.customer_management_application.feature.request.RequestUtil;
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

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/client")
@Log4j2
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

//    @PostMapping("/register")
//    public ResponseEntity<Response> saveClient(@RequestBody ClientRequest client, HttpServletRequest request){
//        clientService.createClient(client.getFirstName(), client.getLastName(), client.getEmail(), client.getPassword(), Role.USER);
//        log.info("Client with FirstName: {}, LastName: {}, Email: {}, Password: {} and Role: {} register successfully", client.getFirstName(), client.getLastName(), client.getEmail(), client.getPassword(), Role.USER);
//        return ResponseEntity.created(getUri()).body(RequestUtils.getResponse(request, emptyMap(), "Account created successfully! Pleas Login...", HttpStatus.CREATED));
//    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthenticationRequest auth, HttpServletRequest request){
        Map<?,?> data = authenticationService.authenticate(auth.getEmail(), auth.getEmail());

        String successMessage = "Account login successfully!";

        URI location = getUri();

        Response responseBody = RequestUtil.getResponse(request, data, successMessage, HttpStatus.CREATED);

        log.info("User with email {} logged in", auth.getEmail());

        return ResponseEntity.created(location).body(responseBody);
    }

    private URI getUri() {
        return URI.create("");
    }
}
