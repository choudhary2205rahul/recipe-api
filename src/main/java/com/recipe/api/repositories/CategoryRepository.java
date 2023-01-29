package com.recipe.api.repositories;

import com.recipe.api.entities.Category;
import com.recipe.api.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
