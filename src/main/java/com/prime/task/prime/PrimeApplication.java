package com.prime.task.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PrimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeApplication.class, args);
	}

}