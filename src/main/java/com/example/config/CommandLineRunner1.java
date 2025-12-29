package com.example.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class CommandLineRunner1 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running commandline runner 1 with arguments:"+Arrays.toString(args));
	}

}
