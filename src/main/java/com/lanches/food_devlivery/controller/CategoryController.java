package com.lanches.food_devlivery.controller;

import com.lanches.food_devlivery.controller.dto.CategoryCreateRequestDTO;
import com.lanches.food_devlivery.controller.dto.CategoryCreateResponseDTO;
import com.lanches.food_devlivery.domain.model.Category;
import com.lanches.food_devlivery.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryService service;

  @PostMapping
  public ResponseEntity<CategoryCreateResponseDTO> create(@RequestBody CategoryCreateRequestDTO request) {
    Category saveCategory = new Category();
    saveCategory.setTitle(request.title());
    saveCategory.setDescription(request.description());
    saveCategory.setOwnerId(request.ownerId());

    Category category = service.create(saveCategory);

    CategoryCreateResponseDTO categoryCreateResponse = new CategoryCreateResponseDTO(
      category.getId(),
      category.getTitle(),
      category.getDescription(),
      category.getOwnerId()
    );

    return ResponseEntity.ok().body(categoryCreateResponse);
  }

}
