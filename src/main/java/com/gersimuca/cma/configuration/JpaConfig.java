package com.gersimuca.cma.configuration;

import com.gersimuca.cma.common.repository.BaseRepositoryImpl;
import com.gersimuca.cma.feature.user.UserEntity;
import com.gersimuca.cma.feature.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableJpaRepositories(
    basePackages = "com.gersimuca.cma.feature",
    repositoryBaseClass = BaseRepositoryImpl.class)
public class JpaConfig {

  @Bean
  public AuditorAware<UserEntity> auditorAware(UserRepository userRepository) {
    return new AuditorProvider(userRepository);
  }
}
