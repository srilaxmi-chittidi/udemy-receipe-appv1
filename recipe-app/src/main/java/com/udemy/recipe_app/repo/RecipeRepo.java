package com.udemy.recipe_app.repo;

import com.udemy.recipe_app.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface RecipeRepo extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();
}
