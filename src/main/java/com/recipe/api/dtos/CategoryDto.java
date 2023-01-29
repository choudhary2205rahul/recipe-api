package com.recipe.api.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.recipe.api.entities.Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}