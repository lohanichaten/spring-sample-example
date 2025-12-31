package com.example.controller;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ActuatorExampleController {

	
	private ApplicationContext context;

	public ActuatorExampleController(ApplicationContext context) {
		super();
		this.context = context;
	}
	
	
	@PostMapping("/down")
	public void shutdonw() {
		AvailabilityChangeEvent.publish(context, LivenessState.BROKEN);
	}
	
	
	@PostMapping("/pause")
	public void pause() {
		log.warn("Starting system pause for {} seconds",30);
		AvailabilityChangeEvent.publish(context, ReadinessState.REFUSING_TRAFFIC);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AvailabilityChangeEvent.publish(context, ReadinessState.ACCEPTING_TRAFFIC);
	}
}
