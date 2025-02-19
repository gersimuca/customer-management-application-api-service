package com.gersimuca.cma.configuration;

import java.util.concurrent.RejectedExecutionHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Data
@EnableAsync
@Configuration
@ConfigurationProperties(prefix = "async")
@Slf4j
public class AsyncConfiguration {

  private int corePoolSize;
  private int maxPoolSize;
  private int queueCapacity;
  private int keepAliveSeconds;
  private boolean waitForTasksToCompleteOnShutdown;
  private String rejectedExecutionHandlerPolicy;

  @Bean(name = "asyncTaskExecutor")
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setKeepAliveSeconds(keepAliveSeconds);
    executor.setThreadNamePrefix("AsyncThreadPoolExecutor-");
    executor.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
    executor.setRejectedExecutionHandler(
        getRejectedExecutionHandler(rejectedExecutionHandlerPolicy));
    executor.initialize();
    return executor;
  }

  private RejectedExecutionHandler getRejectedExecutionHandler(
      final String rejectedExecutionHandlerPolicy) {
    return RejectionPolicy.getHandler(rejectedExecutionHandlerPolicy);
  }
}
