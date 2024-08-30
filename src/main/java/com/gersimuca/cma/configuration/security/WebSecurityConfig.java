package com.gersimuca.cma.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig {

  private final JwtAuthenticationFilter jwtAuthenticationFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  @Order(1)
  public SecurityFilterChain jwtFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            req -> req.anyRequest().permitAll()
            //                        req
            //
            // .requestMatchers("**/api/v1/management/**").hasAnyRole(EMPLOYEE.name())
            //                                .requestMatchers(GET,
            // "**/api/v1/management/**").hasAnyAuthority(EMPLOYEE_READ.name())
            //                                .requestMatchers(POST,
            // "**/api/v1/management/**").hasAnyAuthority(EMPLOYEE_CREATE.name())
            //                                .requestMatchers(PUT,
            // "**/api/v1/management/**").hasAnyAuthority(EMPLOYEE_UPDATE.name())
            //                                .requestMatchers(DELETE,
            // "**/api/v1/management/**").hasAnyAuthority(EMPLOYEE_DELETE.name())
            //
            //
            // .requestMatchers("**/api/v1/system/admin/**").hasAnyRole(SYSTEM_ADMIN.name())
            //                                .requestMatchers(GET,
            // "**/api/v1/system/admin/**").hasAnyAuthority(SYSTEM_ADMIN_READ.name())
            //                                .requestMatchers(POST,
            // "**/api/v1/system/admin/**").hasAnyAuthority(SYSTEM_ADMIN_CREATE.name())
            //                                .requestMatchers(PUT,
            // "**/api/v1/system/admin/**").hasAnyAuthority(SYSTEM_ADMIN_UPDATE.name())
            //                                .requestMatchers(DELETE,
            // "**/api/v1/system/admin/**").hasAnyAuthority(SYSTEM_ADMIN_DELETE.name())
            //                                .anyRequest()
            //                                .authenticated()
            )
        .sessionManagement(
            (session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .logout(
            logout ->
                logout
                    .logoutUrl("/api/v1/logout")
                    .addLogoutHandler(logoutHandler)
                    .logoutSuccessHandler(
                        (request, response, authentication) ->
                            SecurityContextHolder.clearContext()))
        .build();
  }
}
