package com.udemy.recipe_app.repo;

import com.udemy.recipe_app.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CategoryRepo extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
