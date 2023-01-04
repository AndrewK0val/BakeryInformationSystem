package com.example.bakeryinformationsystem.Controllers;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.MainPageApplication;
import com.example.bakeryinformationsystem.Models.BakedGoods;
import com.example.bakeryinformationsystem.Models.Ingredients;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

public class SearchIngredientsController implements Initializable
{

    public static LinkedList<Ingredients> ingredients;

    @FXML
    private ChoiceBox<Integer> caloriesDropDown;

    @FXML
    private ChoiceBox<String> textureDropDown;

    @FXML
    private ChoiceBox<String> typeDropDown;

    @FXML
    private ListView<String> viewOfIngredients;


    public void typeDropDown()
    {
        textureDropDown.getItems().clear();

        for(int i = 0 ; i < ingredients.listLength(); i++)
        {
            textureDropDown.getItems().add(ingredients.get(i).getName());
        }
    }

    public void caloriesDropDown()
    {
        caloriesDropDown.getItems().clear();

        for(int i = 0; i< ingredients.listLength(); i++)
        {
            caloriesDropDown.getItems().add(i);
        }
    }


    public void searchForIngredients(ActionEvent actionEvent)
    {
       // searchIngredients(ingredients);
    }

    public void searchIngredients(LinkedList<Ingredients> ingredients , LinkedList<BakedGoods> bakedGoods)
    {
        viewOfIngredients.getItems().clear(); //clear the view of ingredients ...

        if(typeDropDown.getSelectionModel().getSelectedItem() != null) //if the type dropdown is not empty ...
        {
            for(int i = 0; i< ingredients.listLength(); i++)
            {
               // if(typeDropDown.getSelectionModel().getSelectedItem() == bakedGoods.get(i).getType()) //if the type drop down is the same as the name of the ingredient
                {
                    viewOfIngredients.getItems().add(ingredients.get(i).toString()); //add that ingredient to the view ...
                }
            }
        }
        else if (caloriesDropDown.getSelectionModel().getSelectedItem() != null) //or if calorieDropDown is not empty ...
        {
            for(int i = 0; i< ingredients.listLength(); i++)
            {
//                if (caloriesDropDown.getSelectionModel().getSelectedItem() == i.getCalories()) //if the calories is the same as the ingredients calories ...
//                {
//                    viewOfIngredients.getItems().add(ingredients.get(i).toString()); //add that ingredient to the view
//                }
            }
        }
        else //else ...
        {
            if(textureDropDown.getSelectionModel().getSelectedItem() != null) //if the texture dropdown is not equal to null ...
            {
                for(int i = 0; i< ingredients.listLength(); i++)
                {
                    viewOfIngredients.getItems().add(ingredients.get(i).toString()); //add that ingredient to the view
                }
            }
        }
    }

    public void ReturnToHomePage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("BakeryMainPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Kovallmore Bakery & Son");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        typeDropDown();
        caloriesDropDown();
        textureDropDown.getItems().addAll("Ruffles","Florals","Confetti");
    }
}
