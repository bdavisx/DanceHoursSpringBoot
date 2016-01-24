package com.tartner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = DanceHoursSpringBootApplication.class)
public class DanceHoursSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanceHoursSpringBootApplication.class, args);
	}
}
