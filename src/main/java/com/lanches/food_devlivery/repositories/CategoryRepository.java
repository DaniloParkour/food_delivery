package com.lanches.food_devlivery.repositories;

import com.lanches.food_devlivery.domain.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
