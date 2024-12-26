package com.udemy.recipe_app.repo;

import com.udemy.recipe_app.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepoTest4 {

    @Autowired
    CategoryRepo categoryRepo;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {
        Optional<Category> categoryOptional = categoryRepo.findByDescription("American");
        assertEquals("American",categoryOptional.get().getDescription());
    }
    @Test
    public void findByDescriptionMexican() {
        Optional<Category> categoryOptional = categoryRepo.findByDescription("Mexican");
        assertEquals("Mexican",categoryOptional.get().getDescription());
    }
}