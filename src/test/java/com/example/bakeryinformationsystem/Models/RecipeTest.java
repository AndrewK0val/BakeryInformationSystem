package com.example.bakeryinformationsystem.Models;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.Models.Ingredients;
import com.example.bakeryinformationsystem.Models.Recipe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    public Recipe risValid,rInvalidData;
    LinkedList<Ingredients> allIngredients;
    LinkedList<Ingredients> recipeIngredients;

    @BeforeEach
    void setUp() {
        risValid = new Recipe("Donal",23,recipeIngredients,30F);
        rInvalidData = new Recipe(null,0,null,null);
    }

    @AfterEach
    void tearDown() {
        risValid = rInvalidData = null;

    }

    @Test
    void getName() {
        assertEquals("Donal",risValid.getName());
        assertEquals(null,rInvalidData.getName());
    }

    @Test
    void setName() {
        risValid.setName("flour");
        assertEquals("flour",risValid.getName());
    }

    @Test
    void testToString() {
        Recipe recipe = new Recipe("Donal",23,recipeIngredients,30F);
        String stringContents = recipe.toString();

        assertTrue(stringContents.contains( "Recipe { " + "name = " + recipe.getName()));
    }
}