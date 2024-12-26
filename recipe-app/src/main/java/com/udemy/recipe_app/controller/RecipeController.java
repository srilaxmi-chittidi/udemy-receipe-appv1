package com.udemy.recipe_app.controller;

import com.udemy.recipe_app.domain.Recipe;
import com.udemy.recipe_app.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @RequestMapping({"/recipes","/recipes.html"})
    public String getRecipe(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes";
    }

}
