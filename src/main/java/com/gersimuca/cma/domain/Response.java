package com.gersimuca.cma.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record Response(
    String time,
    int code,
    String path,
    HttpStatus status,
    String message,
    String exception,
    Map<?, ?> data) {}
