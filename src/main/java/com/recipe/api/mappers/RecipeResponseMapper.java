package com.recipe.api.mappers;

import com.recipe.api.dtos.RecipeListDto;
import com.recipe.api.entities.Recipe;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeResponseMapper {
    Recipe toEntity(RecipeListDto recipeListDto);

    RecipeListDto toDto(Recipe recipe);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recipe partialUpdate(RecipeListDto recipeListDto, @MappingTarget Recipe recipe);
}