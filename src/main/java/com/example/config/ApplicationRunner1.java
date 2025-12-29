package com.example.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ApplicationRunner1 implements ApplicationRunner{

    private final ThreadPoolTaskExecutor taskexecutor;

    ApplicationRunner1(ThreadPoolTaskExecutor taskexecutor) {
        this.taskexecutor = taskexecutor;
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
			System.out.println("Running Application runner 1");
			args.getOptionNames().stream().forEach(option->System.out.println(option+":"+args.getOptionValues(option).get(0)));
	}

}
