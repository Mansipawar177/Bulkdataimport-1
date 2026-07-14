package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAsync
public class Bulkdataimport1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bulkdataimport1Application.class, args);
	}

}
