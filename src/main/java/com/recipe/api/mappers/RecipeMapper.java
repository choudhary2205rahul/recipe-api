package com.recipe.api.mappers;

import com.recipe.api.dtos.CategoryDto;
import com.recipe.api.dtos.RecipeDto;
import com.recipe.api.entities.Recipe;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {IngredientsMapper.class})
public interface RecipeMapper {
    Recipe toEntity(RecipeDto saveRecipeRequestDto);

    RecipeDto toDto(Recipe recipe);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recipe partialUpdate(RecipeDto saveRecipeRequestDto, @MappingTarget Recipe recipe);

    @AfterMapping
    default void afterMapping(@MappingTarget Recipe recipe) {
        recipe.getIngredients().forEach(ingredients -> recipe.addIngredients(ingredients));
        recipe.getCategories().forEach(category -> recipe.addCategories(category));
    }
}