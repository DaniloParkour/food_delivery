package com.lanches.food_devlivery.config.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

  @Value("${spring.datasource.url}")
  private String dataSourceUrl;

  @Bean
  public MongoDatabaseFactory mongoConfigure() {
    return new SimpleMongoClientDatabaseFactory(dataSourceUrl);
  }

  @Bean
  public MongoTemplate mongoTemplate() {
    return new MongoTemplate(mongoConfigure());
  }

}
