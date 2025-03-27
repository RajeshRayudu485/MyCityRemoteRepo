package com.mycity.categoryplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CategoryplaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryplaceServiceApplication.class, args);
	}

}
