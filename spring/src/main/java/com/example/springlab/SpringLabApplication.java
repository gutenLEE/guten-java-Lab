package com.example.springlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLabApplication.class, args);
	}

}
