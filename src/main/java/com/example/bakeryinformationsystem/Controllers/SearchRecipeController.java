package com.example.bakeryinformationsystem.Controllers;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.MainPageApplication;
import com.example.bakeryinformationsystem.Models.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchRecipeController implements Initializable
{
    public static LinkedList<Recipe> recipeLinkedList ;

    @FXML
    private TextField maxCaloriesInput;

    @FXML
    private ChoiceBox<String> originDropDown;


    @FXML
    private ChoiceBox<String> typeDropDown;

    @FXML
    private ListView<String> viewOfRecipe;

    public void originDropDown()
    {
        ObservableList<String> locations = FXCollections.observableArrayList("Italy","America", "Ireland", "England" ,"Spain", "France");
        originDropDown.setItems(locations);
    }

    public void typeDropDown()
    {
        ObservableList<String> type = FXCollections.observableArrayList("Scone", "Cookie" , "Cake", "Bread", "Croissant" , "Bagel");
        originDropDown.setItems(type);
    }
    public void searchRecipes(ActionEvent actionEvent)
    {
        if(maxCaloriesInput.getText() != null)
        {
            for(int i = 0 ; i< recipeLinkedList.listLength(); i++)
            {
//                if(recipeLinkedList.get(i).getTotalCalories() <= maxCaloriesInput.getText()); //make method in recipe to total calories
//                {
//                    viewOfRecipe.getItems().add(recipeLinkedList.get(i).toLongString());
//                }
            }
        }
        else if(typeDropDown.getSelectionModel().getSelectedItem() != null)
        {
            for(int i = 0 ; i< recipeLinkedList.listLength(); i++)
            {
                if(recipeLinkedList.get(i).getName() == typeDropDown.getSelectionModel().getSelectedItem()); //make method in recipe to total calories
                {
                    viewOfRecipe.getItems().add(recipeLinkedList.get(i).toLongString());
                }
            }
        }
        else
        {
//            if(originDropDown.getSelectionModel().getSelectedItem() != null)
//            {
//                for(int i = 0 ; i < recipeLinkedList.listLength(); i++)
//                {
//                    originDropDown.getItems().add(recipeLinkedList.get(i).g);
//                }
//            }
        }

        /*
        linkedList<Recipe> allRecipes;

        Recipe r = allRecipes.Search(e -> e.getIngredients().search(j -> j.getCalories().equals(5) && e.get))


               ****preticate****



        public T search(Predicate<T> P)
        {
            for(T item : this)
            {
                if (p.test(item))
                {
                    return item;
                }
                return null;
            }
        }

         */
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        originDropDown();
    }


    public void ReturnToHomePage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("BakeryMainPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Kovallmore Bakery & Son");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
