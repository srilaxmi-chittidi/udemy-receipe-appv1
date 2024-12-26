package com.udemy.recipe_app.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long id =4L;
        category.setId(id);
        assertEquals(id,category.getId());
    }

    @Test
    void getDescription() {
        String description = "Some description";
        category.setDescription(description);
        assertEquals(description,category.getDescription());
    }
}