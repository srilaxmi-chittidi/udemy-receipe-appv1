package com.udemy.recipe_app.controller;

import com.udemy.recipe_app.domain.Recipe;
import com.udemy.recipe_app.service.RecipeService;
import com.udemy.recipe_app.service.RecipeServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;


    @Test
    public void testMockMvc() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        //given
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);

        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);

        recipes.add(recipe1);
        recipes.add(recipe2);
        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        //when
        String viewName =  indexController.getIndexPage(model);

        //then
        assertEquals("index",viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}