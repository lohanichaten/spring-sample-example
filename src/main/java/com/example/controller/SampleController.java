package com.example.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PreDestroy;

@RestController
public class SampleController {

	
	@GetMapping("/waitAsync")
	@Async
	public void waitTesting() throws InterruptedException {
			System.out.println("Running in "+Thread.currentThread().getName());
			Thread.sleep(100000);
	}
	
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroying bean");
	}
	
	@GetMapping("/waitSync")
	public void waitSync() throws InterruptedException {
		System.out.println("Running in "+Thread.currentThread().getName());
		Thread.sleep(100000);
	}
}
