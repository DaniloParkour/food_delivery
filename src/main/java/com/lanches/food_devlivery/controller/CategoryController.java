package com.lanches.food_devlivery.controller;

import com.lanches.food_devlivery.controller.dto.*;
import com.lanches.food_devlivery.domain.model.Category;
import com.lanches.food_devlivery.service.CategoryService;
import com.lanches.food_devlivery.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  private CategoryService service;

  @PostMapping
  public ResponseEntity<CategoryCreateResponseDTO> create(@RequestBody CategoryCreateRequestDTO request) {

    Category saveCategory = MapperUtil.mapObject(request, Category.class);

    Category category = service.create(saveCategory);

    CategoryCreateResponseDTO categoryCreateResponse = MapperUtil.mapObject(category, CategoryCreateResponseDTO.class);

    return ResponseEntity.ok().body(categoryCreateResponse);
  }

  @PutMapping
  public ResponseEntity<CategoryUpdateResponseDTO> update(@RequestBody CategoryUpdateRequestDTO request) {

    if(request.id() == null) return ResponseEntity.badRequest().body(null);

    Category updateCategory = MapperUtil.mapObject(request, Category.class);

    Category updatedCategory = service.update(updateCategory);

    return ResponseEntity.ok().body(new CategoryUpdateResponseDTO(updatedCategory.getId(), updatedCategory.getTitle(), updatedCategory.getDescription(), updatedCategory.getOwnerId()));
  }

  @GetMapping
  //public ResponseEntity<List<CategoryListResponseDTO>> list(@RequestParam CategoryListRequestDTO request) {
  public ResponseEntity<List<CategoryListResponseDTO>> list() {
    //Category saveCategory = MapperUtil.mapObject(request, Category.class);
    //List<Category> categoryList = service.find(request);
    List<Category> categoryList = service.find(null);

    List<CategoryListResponseDTO> response = new ArrayList<CategoryListResponseDTO>();

    for(Category cat : categoryList) {
      CategoryListResponseDTO newCategory = new CategoryListResponseDTO(
        cat.getId(),
        cat.getTitle(),
        cat.getDescription(),
        cat.getOwnerId()
      );
      response.add(newCategory);
    }

    return ResponseEntity.ok().body(response);

  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryDetailResponseDTO> detail(@RequestBody CategoryDetailRequestDTO request) {
    return null;
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoryDeleteResponseDTO> update(@RequestBody CategoryDeleteRequestDTO request) {
    return null;
  }

}
