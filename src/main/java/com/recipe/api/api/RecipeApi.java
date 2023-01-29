package com.recipe.api.api;

import com.recipe.api.dtos.RecipeListDto;
import com.recipe.api.dtos.RecipeDto;
import com.recipe.api.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/recipes")
public class RecipeApi {

    private final RecipeService recipeService;

    public RecipeApi(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<RecipeDto> save(@Valid @RequestBody RecipeDto recipeRequestDto) {
        RecipeDto recipe = recipeService.save(recipeRequestDto);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RecipeDto> update(@Valid @RequestBody RecipeDto recipeDto) {
        RecipeDto recipe = recipeService.update(recipeDto);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RecipeListDto>> findAll() {
        List<RecipeListDto> recipesList = recipeService.findAll();
        return new ResponseEntity<>(recipesList, recipesList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable Long id) {
        RecipeDto recipe = recipeService.findById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recipeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<RecipeListDto>> findByCategory(@PathVariable String name) {
        List<RecipeListDto> recipesList = recipeService.findByCategory(name);
        return new ResponseEntity<>(recipesList, recipesList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/servings/{servings}")
    public ResponseEntity<List<RecipeListDto>> findByServings(@PathVariable int servings) {
        List<RecipeListDto> recipesList = recipeService.findByServings(servings);
        return new ResponseEntity<>(recipesList, recipesList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/ingredients/{ingredients}")
    public ResponseEntity<List<RecipeListDto>> findByIngredients(@PathVariable List<String> ingredients) {
        List<RecipeListDto> recipesList = recipeService.findByIngredients(ingredients);
        return new ResponseEntity<>(recipesList, recipesList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/instructions/{instructions}")
    public ResponseEntity<List<RecipeListDto>> findByInstructions(@PathVariable String instructions) {
        List<RecipeListDto> recipesList = recipeService.findByInstructions(instructions);
        return new ResponseEntity<>(recipesList, recipesList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

}
