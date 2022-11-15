package com.example.msreserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReservaApplication.class, args);
	}

}
