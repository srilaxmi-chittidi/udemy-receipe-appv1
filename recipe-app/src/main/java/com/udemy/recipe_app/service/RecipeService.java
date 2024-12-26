package com.udemy.recipe_app.service;


import com.udemy.recipe_app.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
