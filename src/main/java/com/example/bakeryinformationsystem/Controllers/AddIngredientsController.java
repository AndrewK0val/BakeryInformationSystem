package com.example.bakeryinformationsystem.Controllers;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.ADT.LinkedNode;
import com.example.bakeryinformationsystem.MainPageApplication;
import com.example.bakeryinformationsystem.Models.Ingredients;
import com.example.bakeryinformationsystem.Models.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileReader;

import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class AddIngredientsController implements Initializable
{

    public static LinkedList<Ingredients> ingredient = new LinkedList<Ingredients>();
    @FXML
    private Button AddIngredientButton;

    @FXML
    private TextField caloriesInput;

    @FXML
    private TextField itemNameInput;

    @FXML
    private ChoiceBox<String> textureDropDown;

    @FXML
    private ListView<String> viewOfIngredients;
    private Ingredients chosenIngredient;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        textureDropDown.getItems().addAll("Ruffles","Florals","Confetti");
        viewOfIngredients();

    }

    public void addIngredient()
    {
        float calories = Float.valueOf(caloriesInput.getText());
        String name = itemNameInput.getText();
        String texture = textureDropDown.getSelectionModel().getSelectedItem().toString();
        Ingredients is = new Ingredients(name, calories, texture);
        //frontend adding of ingredients


        ingredient.addElement(is);
//        viewOfIngredients.getItems().add(is.toString());
        ingredient.addToListView(viewOfIngredients);

        System.out.println(name + "\n" + calories + "\n" + texture);

    }

//    public void chooseIngredient()
//    {
//        chosenIngredient = viewOfIngredients.getSelectionModel().getSelectedItem();
//    }

    public void addIngredient(Ingredients ingredients) //button for adding the ingredients to the linked list
    {

    }

    public void viewOfIngredients() //updates the listview with the linked list
    {
        viewOfIngredients.getItems().clear();

        for(int i = 0 ; i < ingredient.listLength(); i++)
        {
            viewOfIngredients.getItems().add(ingredient.get(i).toString());

        }
    }

    public void deleteAllIngredients() {
        ingredient.resetList();
        viewOfIngredients.getItems().clear();
    }

    public void viewOfIngredient()
    {
        viewOfIngredients.getItems().clear();

        for(int i = 0 ; i < ingredient.listLength(); i++)
        {
//            viewOfIngredients.getItems().add(String.valueOf(ingredient));
        }
    }

    public int numberOfIngredients() {
        int x = ingredient.listLength();
        return x;
    }
    public void deleteIngredient() {
        for (int i = 0; i < ingredient.listLength(); i++) {
            if (ingredient.isEmpty()) { // stops nullPointerException
                if (viewOfIngredients.getSelectionModel().getSelectedIndex() == i) {

                    ingredient.deleteElement(i);
                    viewOfIngredients.getItems().remove(i);

                }
            }
        }
    }

    public void resetIngredients() {
        //frontend
        viewOfIngredients.getItems().clear();
        //backend
        deleteAllIngredients();
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






//    public void addIngredient(ActionEvent actionEvent)
//    {
////        ingredient.addToListView(viewOfIngredients);
//    }
}
