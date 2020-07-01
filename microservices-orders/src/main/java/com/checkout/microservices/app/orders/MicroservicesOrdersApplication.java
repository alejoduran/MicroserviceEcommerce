package com.checkout.microservices.app.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.checkout.commons.models.entity", "com.checkout.microservices.app.orders.models.entity"})
public class MicroservicesOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesOrdersApplication.class, args);
	}

}
