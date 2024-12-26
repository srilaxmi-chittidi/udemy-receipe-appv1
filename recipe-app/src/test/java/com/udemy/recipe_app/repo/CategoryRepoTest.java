package com.udemy.recipe_app.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CategoryRepoTest {

    CategoryRepo categoryRepo;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescription() {
    }
}