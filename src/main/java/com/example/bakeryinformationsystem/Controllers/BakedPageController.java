package com.example.bakeryinformationsystem.Controllers;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.ADT.LinkedNode;
import com.example.bakeryinformationsystem.MainPageApplication;
import com.example.bakeryinformationsystem.Models.BakedGoods;
import com.example.bakeryinformationsystem.Models.Ingredients;
import com.example.bakeryinformationsystem.Models.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.XStream;

public class BakedPageController implements Initializable
{

    @FXML
    private ChoiceBox<String> originDropDown;

    @FXML
    private ChoiceBox<String> containsDropDown;

    @FXML
    private TextField maxCaloriesInput;

    @FXML
    private ChoiceBox<String> typeDropDown;

    @FXML
    private ListView<String> viewOfBakedGoods;

    public static LinkedList<Recipe> recipeLinkedList;
    public static LinkedList<Ingredients> ingredients;
    public static LinkedList bakedGoods = new LinkedList<Recipe>();

    public void findBakedGoods(ActionEvent actionEvent) //button for finding baked goods
    {
        viewOfBakedGoods.getItems().clear();//clear the view of any existing baked goods

        if(typeDropDown.getSelectionModel().getSelectedItem() != null) //if the type dropdown is not equal to null ...
        {
            searchType(bakedGoods);
        }
        else if(maxCaloriesInput.getText() != null) //else if the max calories input is not null ...
        {
            searchCalories(bakedGoods);
        }
        else if(containsDropDown.getSelectionModel().getSelectedItem() != null) //else if the contains drop down is not equal to null ...
        {
            searchContains(bakedGoods);
        }
        else if(originDropDown.getSelectionModel().getSelectedItem() != null) //else if the origin drop down is not equal to null ...
        {
            searchOrigin(bakedGoods);
        }
        else //else ...
        {
            viewOfBakedGoods.getItems().add("Please select a search option and try again"); //inform the user to select and option and try again
        }


        //this way of searching gives multiple option for searching, the user can search by calories OR origin etc
        //the structures if this method means you will search by one attribute of the baked good OR a different attribute of the same baked good
    }

    public void searchType(LinkedList<BakedGoods> bakedGoods)
    {
        for(int i = 0 ; i < bakedGoods.listLength(); i ++) //for every int i less that the size of the baked goods linked list ...
        {
            if(bakedGoods.get(i).type == typeDropDown.getSelectionModel().getSelectedItem()) //if 'i's type is the same as the drop down ...
            {
                viewOfBakedGoods.getItems().add(bakedGoods.get(i).toString()); //add the to string of that baked good to the view
            }
        }
    }

    public void searchCalories(LinkedList<BakedGoods> bakedGoods)
    {
//        for(int i = 0 ; i < bakedGoods.listLength();i++) //for every int i less that the size of the baked goods linked list ...
//        {
//            if(bakedGoods.get(i).getCalories() <= maxCaloriesInput.getText()) //if that baked goods calories are less than or equal to the calories in the input ...
//            {
//                viewOfBakedGoods.getItems().add(bakedGoods.get(i).toString()); //add the toString of that baked good to the view
//            }
//        }
    }

    public void searchOrigin(LinkedList<BakedGoods> bakedGoods)
    {
        for(int i = 0 ; i < bakedGoods.listLength();i++) //for every int i less that the size of the baked goods linked list ...
        {
            if(bakedGoods.get(i).country == originDropDown.getSelectionModel().getSelectedItem()) // if the baked goods country is the same as the selected dropdown in the drop down ...
            {
                viewOfBakedGoods.getItems().add(bakedGoods.get(i).toString()); //add that baked good to the view
            }
        }
    }

    public void searchContains(LinkedList<BakedGoods> bakedGoods)
    {
//        BakedGoods bG = bakedGoods.head;
//        for(int i = 0 ; i < bakedGoods.listLength();i++) //for every int i less that the size of the baked goods linked list ...
//        {
//            Recipe recipe = bg.
//        }
    }

    public void originDropDown(LinkedList<BakedGoods> bakedGoods)
    {
//        bG = bakedGoods.head
//        for(int i =0 ; i<bG.listLength(); i++)
//        {
//            Recipe = bG.
//            viewOfBakedGoods.getItems().add(bakedGoods.get(i).country);
//        }
    }


    public void containsDropDown(LinkedList<BakedGoods> bakedGoods)
    {
        for(int j = 0; j < bakedGoods.listLength(); j++)
        {
            for(int k = 0 ; k < recipeLinkedList.listLength(); k++)
            {
                for(int i =0 ; i< ingredients.listLength(); i++)
                {
                    //if statement
                    viewOfBakedGoods.getItems().add(ingredients.get(i).getName());
                }
            }
        }
    }

    public void findAll(LinkedList<BakedGoods> bakedGoods) //on start up run this method to load in all existing baked goods
    {
        viewOfBakedGoods.getItems().clear(); //clear the view of baked goods

        for(int i =0 ; i< bakedGoods.listLength(); i++)
        {
            viewOfBakedGoods.getItems().add(bakedGoods.get(i).toString()); //get that baked good and drop it in the view
        }
    }

    public void returnToHome(ActionEvent actionEvent)
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //textureDropDown.getItems().addAll("Ruffles","Florals","Confetti");
        findAll(bakedGoods);
        containsDropDown(bakedGoods);
        originDropDown(bakedGoods);
        typeDropDown.getItems().addAll("Cake","Bread","Pastry");
    }
}
