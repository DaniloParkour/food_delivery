package com.lanches.food_devlivery.service;

import com.lanches.food_devlivery.controller.dto.CategoryListRequestDTO;
import com.lanches.food_devlivery.domain.model.Category;
import com.lanches.food_devlivery.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public Category create(Category category) {
    return repository.save(category);
  }

  public Category update(Category updateCategory) {

    Optional<Category> category = repository.findById(updateCategory.getId());

    if(category.isPresent()) {
      Category updatedCategory = repository.save(updateCategory);
      return updatedCategory;
    }

    return null;
  }

  public List<Category> find(CategoryListRequestDTO request) {
    return repository.findAll();
  }
}
