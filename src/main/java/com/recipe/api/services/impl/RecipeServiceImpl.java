package com.recipe.api.services.impl;

import com.recipe.api.dtos.RecipeDto;
import com.recipe.api.entities.Recipe;
import com.recipe.api.dtos.RecipeListDto;
import com.recipe.api.exceptions.RecipeNotFoundException;
import com.recipe.api.mappers.CategoryMapper;
import com.recipe.api.mappers.IngredientsMapper;
import com.recipe.api.mappers.RecipeMapper;
import com.recipe.api.mappers.RecipeResponseMapper;
import com.recipe.api.repositories.RecipeRepository;
import com.recipe.api.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeResponseMapper recipeResponseMapper;
    private final RecipeMapper recipeMapper;
    private final IngredientsMapper ingredientsMapper;
    private final CategoryMapper categoryMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeResponseMapper recipeResponseMapper, RecipeMapper recipeMapper, IngredientsMapper ingredientsMapper, CategoryMapper categoryMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeResponseMapper = recipeResponseMapper;
        this.recipeMapper = recipeMapper;
        this.ingredientsMapper = ingredientsMapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public RecipeDto save(RecipeDto recipe) {
        Recipe recipeEntity = recipeMapper.toEntity(recipe);
        Recipe savedRecipe = recipeRepository.save(recipeEntity);
        return recipeMapper.toDto(savedRecipe);
    }

    @Override
    public RecipeDto update(RecipeDto recipeDto) {

        if(recipeDto.getId() == null) {
            throw new IllegalArgumentException("Recipe ID is missing");
        }
        ;
        Recipe recipeEntity = recipeRepository.findById(recipeDto.getId())
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + recipeDto.getId()));

        recipeMapper.partialUpdate(recipeDto, recipeEntity);

        return recipeMapper.toDto(recipeEntity);
    }

    @Override
    public void delete(Long id) {
        Recipe recipeEntity = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
        if(recipeEntity.getId() != null) {
            recipeRepository.deleteById(id);
        }
    }

    @Override
    public RecipeDto findById(Long id) {
        Recipe recipeEntity = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with id: " + id));
        return recipeMapper.toDto(recipeEntity);
    }

    @Override
    public List<RecipeListDto> findAll() {
        List<Recipe> recipeList = recipeRepository.findAll();
        return recipeList.stream()
                .map(recipeResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeListDto> findByCategory(String name) {
        List<Recipe> recipeList = recipeRepository.findByCategories(name);
        return recipeList.stream()
                .map(recipeResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeListDto> findByServings(int servings) {
        List<Recipe> recipeList = recipeRepository.findByServing(servings);
        return recipeList.stream()
                .map(recipeResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeListDto> findByIngredients(List<String> ingredients) {
        AtomicReference<List<Recipe>> recipeList = new AtomicReference<>();
        ingredients.stream().forEach(ingredient -> {
            recipeList.set(recipeRepository.findByIngredients(ingredient));
        });
        return recipeList.get().stream()
                .map(recipeResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeListDto> findByInstructions(String instructions) {
        List<Recipe> recipeList = recipeRepository.findByInstructionsContaining(instructions);
        return recipeList.stream()
                .map(recipeResponseMapper::toDto)
                .collect(Collectors.toList());
    }

}
