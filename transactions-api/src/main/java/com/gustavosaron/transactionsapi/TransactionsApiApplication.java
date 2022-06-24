package com.gustavosaron.transactionsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.gustavosaron.transactionsapi.repository")
public class TransactionsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApiApplication.class, args);
	}

}
