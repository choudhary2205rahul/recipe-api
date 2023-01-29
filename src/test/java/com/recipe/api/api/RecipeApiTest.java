package com.recipe.api.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.api.dtos.CategoryDto;
import com.recipe.api.dtos.IngredientsDto;
import com.recipe.api.dtos.RecipeDto;
import com.recipe.api.dtos.RecipeListDto;
import com.recipe.api.entities.Category;
import com.recipe.api.entities.Ingredients;
import com.recipe.api.entities.Recipe;
import com.recipe.api.services.impl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class RecipeApiTest {

    private static MockHttpServletRequest request;

    @Mock
    RecipeServiceImpl recipeService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    public static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;

    @BeforeAll
    public static void setup() {
        request = new MockHttpServletRequest();

    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/recipes")
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "    \"name\": \"Pancakes\",\n" +
                        "    \"description\": \"Delicious pancakes\",\n" +
                        "    \"image\": \"https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png\",\n" +
                        "    \"serving\": \"4\",\n" +
                        "    \"ingredients\": [\n" +
                        "        {\n" +
                        "            \"name\": \"Eggs\",\n" +
                        "            \"quantity\": \"2\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"categories\": [\n" +
                        "        {\n" +
                        "            \"name\": \"Breakfast\",\n" +
                        "            \"description\": \"Breakfast recipes\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void update() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/recipes")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content("{\n" +
                                "    \"name\": \"Pancakes\",\n" +
                                "    \"description\": \"Delicious pancakes\",\n" +
                                "    \"image\": \"https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png\",\n" +
                                "    \"serving\": 4,\n" +
                                "    \"ingredients\": [\n" +
                                "        {\n" +
                                "            \"name\": \"Eggs\",\n" +
                                "            \"quantity\": \"2\"\n" +
                                "        }\n" +
                                "    ],\n" +
                                "    \"categories\": [\n" +
                                "        {\n" +
                                "            \"name\": \"Breakfast\",\n" +
                                "            \"description\": \"Breakfast recipes\"\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/recipes")
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"Pancakes\",\n" +
                        "    \"description\": \"Delicious pancakes\",\n" +
                        "    \"image\": \"https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png\",\n" +
                        "    \"serving\": 5 \n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void findAll() throws Exception {

//        Set<CategoryDto> categories = new HashSet<>();
//        categories.add(new CategoryDto(1L, "Breakfast", "Breakfast recipes"));
//
//        Set<IngredientsDto> ingredients = new HashSet<>();
//        ingredients.add(new IngredientsDto(1L, "Eggs", "2"));
//
//        List<RecipeListDto> recipes = new ArrayList<>();
//        recipes.add(new RecipeListDto(1L,
//                "Pancakes",
//                "Delicious pancakes",
//                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
//        ));
//
//        when(recipeService.findAll()).thenReturn(recipes);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/v1/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Pancakes\",\"description\":\"Delicious pancakes\",\"image\":\"https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png\"}]"))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));

        resultActions.andReturn().getResponse().getContentAsString();

    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/recipes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/recipes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void findByCategory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/recipes/category/Breakfast"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void findByServings() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/recipes/servings/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    void findByIngredients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/recipes/ingredients/Flour"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    @Test
    void findByInstructions() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/recipes/instructions/cook"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }
}