package com.lanches.food_devlivery.repositories;

import com.lanches.food_devlivery.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
  
}
