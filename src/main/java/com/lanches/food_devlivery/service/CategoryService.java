package com.lanches.food_devlivery.service;

import com.lanches.food_devlivery.domain.model.Category;
import com.lanches.food_devlivery.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public Category create(Category category) {
    Category savedCategory = repository.save(category);
    return savedCategory;
  }

}
