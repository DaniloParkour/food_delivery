package com.lanches.food_devlivery.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@NoArgsConstructor
public class Product {
  @Id
  private String id;
  private String title;
  private String description;
  private String ownerId;
  private Float price;
  private Category category;
}
