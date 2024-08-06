package com.gersimuca.cma.feature.user;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
@Log4j2
public class UserController {

    @GetMapping("/hello")
    public String sayHello() {
        return "<h1>Hello, World!</h1>";
    }

}
