package com.checkout.mircroservices.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.checkout.commons.models.entity"})
public class MicroservicesProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesProductsApplication.class, args);
	}

}
