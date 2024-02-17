package com.lanches.food_devlivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FoodDevliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDevliveryApplication.class, args);
	}

}
