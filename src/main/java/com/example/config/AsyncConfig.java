package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

	
	
	@Bean
	ThreadPoolTaskExecutor taskexecutor() {
		ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
		executor.setWaitForTasksToCompleteOnShutdown(false);
		executor.setAwaitTerminationSeconds(20);
		executor.setThreadNamePrefix("test-async");
		return executor;
	}
}
