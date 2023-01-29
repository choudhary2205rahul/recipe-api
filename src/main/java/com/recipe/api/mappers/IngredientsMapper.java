package com.recipe.api.mappers;

import com.recipe.api.dtos.IngredientsDto;
import com.recipe.api.entities.Ingredients;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IngredientsMapper {
    Ingredients toEntity(IngredientsDto ingredientsDto);

    IngredientsDto toDto(Ingredients ingredients);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Ingredients partialUpdate(IngredientsDto ingredientsDto, @MappingTarget Ingredients ingredients);
}