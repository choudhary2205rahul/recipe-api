package com.recipe.api.services;

import com.recipe.api.dtos.RecipeDto;
import com.recipe.api.dtos.RecipeListDto;
import com.recipe.api.entities.Recipe;

import java.util.List;

public interface RecipeService {

    public RecipeDto save(RecipeDto recipeRequestDto);

    public RecipeDto update(RecipeDto Recipe);

    public void delete(Long id);

    public RecipeDto findById(Long id);

    public List<RecipeListDto> findAll();

    List<RecipeListDto> findByCategory(String name);

    List<RecipeListDto> findByServings(int servings);

    List<RecipeListDto> findByIngredients(List<String> ingredients);

    List<RecipeListDto> findByInstructions(String instructions);

//    public List<Recipe> findByCategory(CategoryDto categoryDto);
//
//    public List<Recipe> findByIngredients(IngredientsDto ingredientsDto);
//
//    public List<Recipe> findByServingsAndIngredients(String serving, IngredientsDto ingredientsDto);
//
//    public List<Recipe> findByIngredientsAndInstructions(IngredientsDto ingredientsDto, String instructions);

}
