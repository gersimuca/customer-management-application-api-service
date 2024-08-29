package com.gersimuca.cma.feature.request;

import static org.apache.logging.log4j.util.Strings.EMPTY;

import com.gersimuca.cma.domain.Response;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;

public class RequestUtil {
  public static Response getResponse(
      HttpServletRequest request, Map<?, ?> data, String message, HttpStatus status) {
    return new Response(
        LocalDateTime.now().toString(),
        status.value(),
        request.getRequestURI(),
        HttpStatus.valueOf(status.value()),
        message,
        EMPTY,
        data);
  }
}
