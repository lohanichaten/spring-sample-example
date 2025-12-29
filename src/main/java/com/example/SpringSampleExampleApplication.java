package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.config.DemoBeanNameGenerator;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableAsync
@ComponentScan(nameGenerator = DemoBeanNameGenerator.class)
public class SpringSampleExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringSampleExampleApplication.class, args);
		for(String beanName:context.getBeanDefinitionNames()) {
			if(beanName.startsWith("com.example")) {
				System.out.println(beanName);
			}
			
		}
	
	}
	
	
	@PostConstruct
	public void init() {
		System.out.println("Adding Hook");
		Runtime.getRuntime().addShutdownHook(new Thread(()->{
				System.out.println("Shutting down JVM");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}));
	}

	
	
	@EventListener(ApplicationReadyEvent.class)
	public void onReady(ApplicationReadyEvent ready) {
		System.out.println("Application is ready with "+ready);
	}
}
