package com.example.Klinik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KlinikApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlinikApplication.class, args);
	}

}
