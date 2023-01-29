package com.recipe.api.repositories;

import com.recipe.api.entities.Category;
import com.recipe.api.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r JOIN r.categories c WHERE c.name = ?1")
    List<Recipe> findByCategories(String name);

    List<Recipe> findByServing(int serving);

    @Query("SELECT r FROM Recipe r JOIN r.ingredients i WHERE i.name like ?1")
    List<Recipe> findByIngredients(String name);

    List<Recipe> findByInstructionsContaining(String instructions);
}
