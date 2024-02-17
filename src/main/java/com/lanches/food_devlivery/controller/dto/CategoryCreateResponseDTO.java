package com.lanches.food_devlivery.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record CategoryCreateResponseDTO(String id, String title, String description, String ownerId) {
}
