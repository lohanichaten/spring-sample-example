package com.example.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
@Order(2)
public class ApplicationRunner2 implements ApplicationRunner{

	
	
	
	@Async
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Running Application runner 2");
		heavyProcess();
	}
	
	
	public void heavyProcess() {
		try {
			Thread.sleep(10000);
			System.out.println("Heavy process completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
