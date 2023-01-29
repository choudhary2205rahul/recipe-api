package com.recipe.api.dtos;

import com.recipe.api.entities.Recipe;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Recipe} entity
 */
@Data
public class RecipeListDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final String image;
}