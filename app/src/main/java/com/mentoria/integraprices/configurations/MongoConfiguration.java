package com.mentoria.integraprices.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {
    "com.mentoria.integraprices.gateways.outputs.mongodb.repositories"})
public class MongoConfiguration {

}
