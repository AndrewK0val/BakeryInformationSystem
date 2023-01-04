package com.example.bakeryinformationsystem.Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientsTest {

    public Ingredients ingIsValid,ingInvalidData;

    @BeforeEach
    void setUp() {
        ingIsValid = new Ingredients("flour",345F,"nice");
        ingInvalidData = new Ingredients(null,null,null);
    }

    @AfterEach
    void tearDown() {
        ingIsValid = ingInvalidData = null;
    }

    @Test
    void getName() {
        assertEquals("flour",ingIsValid.getName());
        assertEquals(null,ingInvalidData.getName());
    }

    @Test
    void setName() {
        ingIsValid.setName("flour");
        assertEquals("flour",ingIsValid.getName());
    }

    @Test
    void getCalories() {
        assertEquals(345F,ingIsValid.getCalories());
        assertEquals(null,ingInvalidData.getCalories());
    }

    @Test
    void setCalories() {
        ingIsValid.setCalories(345F);
        assertEquals(345F,ingIsValid.getCalories());
    }

    @Test
    void getTexture() {
        assertEquals("nice",ingIsValid.getTexture());
        assertEquals(null,ingInvalidData.getTexture());
    }

    @Test
    void setTexture() {
        ingIsValid.setTexture("nice");
        assertEquals("nice",ingIsValid.getTexture());
    }

    @Test
    void testToString() {
        Ingredients ing = new Ingredients("flour",345F,"nice");;
        String stringContents = ing.toString();

        assertTrue(stringContents.contains("Ingredients { " + "name = " + ing.getName()));
        assertTrue(stringContents.contains(", calories = " + ing.getCalories()));
        assertTrue(stringContents.contains(", texture = " + ing.getTexture() + " }"));
    }
}