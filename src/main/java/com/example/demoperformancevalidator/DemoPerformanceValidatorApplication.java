package com.example.demoperformancevalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class DemoPerformanceValidatorApplication {
	static {
		BlockHound.install();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoPerformanceValidatorApplication.class, args);
	}

}
