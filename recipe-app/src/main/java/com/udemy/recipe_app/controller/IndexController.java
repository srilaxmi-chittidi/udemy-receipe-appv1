package com.udemy.recipe_app.controller;

import com.udemy.recipe_app.domain.Category;
import com.udemy.recipe_app.domain.Recipe;
import com.udemy.recipe_app.domain.UnitOfMeasure;
import com.udemy.recipe_app.repo.CategoryRepo;
import com.udemy.recipe_app.repo.RecipeRepo;
import com.udemy.recipe_app.repo.UnitOfMeasureRepo;
import com.udemy.recipe_app.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @RequestMapping({"/","/index","/index.html"})
    public String getIndexPage(Model model){

        log.debug("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
