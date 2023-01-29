package com.recipe.api.repositories;

import com.recipe.api.entities.Ingredients;
import com.recipe.api.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    List<Recipe> findByName(String name);
}
