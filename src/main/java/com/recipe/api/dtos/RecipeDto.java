package com.recipe.api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.recipe.api.entities.Recipe} entity
 */
@Data
public class RecipeDto implements Serializable {
    private final Long id;

    @NotNull(message = "Name is required")
    private final String name;
    @NotNull(message = "Description is required")
    private final String description;
    @NotNull(message = "Image is required")
    private final String image;
    private final int serving;
    private final String instructions;
    private final Set<IngredientsDto> ingredients;
    private final Set<CategoryDto> categories;
}