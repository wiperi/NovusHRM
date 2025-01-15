package com.wiperi.novuscrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovusCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovusCrmApplication.class, args);
		System.out.println("NovusCRM Started!");
	}

}
