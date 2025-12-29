package com.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
@Order(2)
public class CommandLineRunner2 implements CommandLineRunner{

	@Async
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting heavy process");
		heavyTask();
		
	}

	public void heavyTask() {
		try {
			Thread.sleep(10000);
			System.out.println("Heavy Task completed in thread "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
