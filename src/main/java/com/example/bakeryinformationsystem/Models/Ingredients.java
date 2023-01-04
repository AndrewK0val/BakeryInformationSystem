package com.example.bakeryinformationsystem.Models;

import com.example.bakeryinformationsystem.ADT.LinkedList;

public class Ingredients
{
    private String name; //setting global variable
    private Float calories;
    private String texture;


    public Ingredients(String name, Float calories, String texture)
    {
        this.name = name;
        this.calories = calories;
        this.texture = texture;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Float getCalories()
    {
        return calories;
    }

    public void setCalories(Float calories)
    {
        this.calories = calories;
    }

    public String getTexture()
    {
        return texture;
    }

    public void setTexture(String texture)
    {
        this.texture = texture;
    }

    @Override
    public String toString() //this will be displayed in the list view
    {
        return   name +
                "   |  Calories: " + calories +
                "   |   Texture:  " + texture;
    }

    public String toLongString() //this will be displayed in the ineractive menu
    {
        return "name = " + name +
                ", calories = " + calories +
                ", texture = " + texture;
    }
}
