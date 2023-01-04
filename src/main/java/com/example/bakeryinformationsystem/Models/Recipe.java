package com.example.bakeryinformationsystem.Models;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.Controllers.AddIngredientsController;
import com.example.bakeryinformationsystem.Controllers.AddRecipeController;

public class Recipe
{
    //setting global variables
    private String name;
    private int quantity;
    private LinkedList<Ingredients> allIngredients = AddIngredientsController.ingredient;
    public LinkedList<Ingredients> recipeIngredients;

    public Float totalCalories;


    public Recipe(String name, Integer quantity, LinkedList<Ingredients> recipeIngredients, Float totalCalories)
    {
        this.name = name;
        this.quantity = quantity;
//        this.allIngredients = allIngredients;
        this.recipeIngredients = new LinkedList<Ingredients>();
        //this.totalCalories = totalCalories;
    }

//    public void getTotalCalories()
//    {
//        return totalCalories;
//    }

//    public void setTotalCalories(Double totalCalories)
//    {
//        for(int i = 0; i < recipeIngredients.listLength(); i++)
//        {
//            totalCalories += recipeIngredients.get(i).getCalories();
//        }
//
//        this.totalCalories = totalCalories;
//    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public LinkedList<Ingredients> getAllIngredients()
    {
        return allIngredients;
    }

    public void setAllIngredients(LinkedList<Ingredients> allIngredients)
    {
        this.allIngredients = allIngredients;
    }

    @Override
    public String toString() //this will be displayed in the list view
    {
        return
                "name= " + name;
    }


    public String toLongString() //this will be displayed in the interactive menu
    {
        return    name + "\n" +
                "   quantity=" + quantity +
                ", Ingredients=" + recipeIngredients;
    }
}
