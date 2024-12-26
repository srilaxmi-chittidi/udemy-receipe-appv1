package com.udemy.recipe_app.service;

import com.udemy.recipe_app.domain.Recipe;
import com.udemy.recipe_app.repo.RecipeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepo recipeRepo;

    @BeforeEach
    void setUp() throws  Exception{
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        when(recipeRepo.findAll()).thenReturn(recipes);
        Set<Recipe> recipeSet =  recipeService.getRecipes();
        assertEquals(1,recipeSet.size());
    }
}