package com.gustavosaron.transactionsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import lombok.AllArgsConstructor;

@Configuration
@EnableMongoRepositories(basePackages = "com.gustavosaron.transactionsapi.repository")
@AllArgsConstructor
public class MongoConfig {

    @Bean
    public MongoClient mongo() throws Exception {
        final ConnectionString connectionString = new ConnectionString("mongodb://root:root@localhost:27017/bank-db?authSource=admin");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
        		.applyConnectionString(connectionString)
        		.build();
        return MongoClients.create(mongoClientSettings);
    }

}
