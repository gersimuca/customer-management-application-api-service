package com.gersimuca.cma.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final JwtAuthenticationConverter jwtAuthenticationConverter;

  private static final String[] ALLOW_LIST = {
    "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/resources/**"
  };

  @Bean
  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    var tokenResolver = new DefaultBearerTokenResolver();
    tokenResolver.setAllowUriQueryParameter(true);

    http.authorizeHttpRequests(
            request ->
                request
                    .requestMatchers(ALLOW_LIST)
                    .permitAll()
                    .requestMatchers(getPublicEndpoints())
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .oauth2ResourceServer(
            oauthConfigurer ->
                oauthConfigurer
                    .bearerTokenResolver(tokenResolver)
                    .jwt(
                        jwtConfigurer ->
                            jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter)));

    return http.build();
  }

  private EndpointRequest.EndpointRequestMatcher getPublicEndpoints() {
    return EndpointRequest.to(
        HealthEndpoint.class,
        PrometheusScrapeEndpoint.class,
        MetricsEndpoint.class,
        InfoEndpoint.class);
  }
}
