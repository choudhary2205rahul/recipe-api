package com.recipe.api.dtos;

import com.recipe.api.entities.Ingredients;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Ingredients} entity
 */
@Data
public class IngredientsDto implements Serializable {
    private final Long id;
    private final String name;
    private final String quantity;
}