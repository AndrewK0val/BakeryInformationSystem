package com.example.bakeryinformationsystem.Models;

import com.example.bakeryinformationsystem.ADT.LinkedList;



public class BakedGoods
{
    public String name;
    public String country;
    public String description;
    public String URL;
    public String type;
    public static LinkedList<Recipe> recipeLinkedList = new LinkedList<Recipe>();

    public Float calories;


    public BakedGoods(String name, String country, String type, String URL, LinkedList<Recipe> recipeLinkedList)
    {
        this.name = name;
        this.country = country;
        this.type = type;
        this.URL = URL;
        this.recipeLinkedList = recipeLinkedList;

    }

    public Float getCalories()
     {
        return calories;
    }

    public void setCalories(Float calories)
     {
        this.calories = calories;
     }

     public void totalCalories(LinkedList<Ingredients> ingredients)
     {
        float calories = 0;

        for(int i = 0 ; i < recipeLinkedList.listLength() ; i++)
        {
            calories += ingredients.get(i).getCalories();
        }
     }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getURL()
    {
        return URL;
    }

    public void setURL(String URL)
    {
        this.URL = URL;
    }

    public void addIngredient(Recipe newRecipe){
        recipeLinkedList.addElement(newRecipe);
    }

    public static LinkedList<Recipe> getRecipeLinkedList()
    {
        return recipeLinkedList;
    }

    public static void setRecipeLinkedList(LinkedList<Recipe> recipeLinkedList)
    {
        BakedGoods.recipeLinkedList = recipeLinkedList;
    }

    @Override
    public String toString()
    {
        return " name = " + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", URL='" + URL + '\'' +
                ", type='" + type + '\'' +
                ", recipe=" + recipeLinkedList; //this will be displayed in the list view
    }

    public String toLongString() //this will be displayed in the interactive menu
    {
        return " name = " + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", URL='" + URL + '\'' +
                ", type='" + type + '\'' + '\n' +
                " recipe=" + recipeLinkedList;
    }
}
