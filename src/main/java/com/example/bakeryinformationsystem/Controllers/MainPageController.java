package com.example.bakeryinformationsystem.Controllers;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.ADT.LinkedNode;
import com.example.bakeryinformationsystem.MainPageApplication;
import com.example.bakeryinformationsystem.Models.BakedGoods;
import com.example.bakeryinformationsystem.Models.Ingredients;
import com.example.bakeryinformationsystem.Models.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class MainPageController implements Initializable
{
    @FXML
    private Button ResetAll;

    @FXML
    private Button addIngredientsButton;

    @FXML
    private Button addItemButton;

    @FXML
    private Button addRecipeButton;

    @FXML
    private Button saveAll;

    @FXML
    private Button searchBakedGood;

    @FXML
    private Button searchRecipeButton;

    @FXML
    private Button viewIngredientsButton;

    public LinkedList<Ingredients> ingredient;



    public void openAddItemPage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("BakeAnItemPage.fxml"));
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

    public void openBakedGoodsPage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("bakedGoodsPage.fxml"));
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

    public void openViewIngredientsPage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("SearchIngredientsPage.fxml"));
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

    public void openAddIngredientsPage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("AddIngredientsPage.fxml"));
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

    public void openSearchRecipePage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("SearchRecipePage.fxml"));
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

    public void openAddRecipePage(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("AddRecipePage.fxml"));
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
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }


    public void load(ActionEvent actionEvent) throws Exception //on start up load in all existing information from xstream file
    {
        Class<?>[] classes = new Class[]{BakedGoods.class, LinkedNode.class, Ingredients.class, Recipe.class};
        XStream xstream = new XStream(new DomDriver());
//        XStream.setupDefaultSecurity(xstream); no idea why this refuses to work

        xstream.allowTypes(classes);


        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("saveData.xml"));
        AddIngredientsController.ingredient.head = (LinkedNode<Ingredients>) is.readObject();
        is.close();
//        BakeAnItemController.bGoods.addToListView(BakeAnItemController.); -- find a way to target the list view: viewOfAddedItem in BakeAnItemController, this line populates that list view saved content
    }

    public void ResetAll(ActionEvent actionEvent)
    {
    BakeAnItemController.bakedGoods.head = null;
    AddRecipeController.recipeLinkedList.head = null;
    AddIngredientsController.ingredient.head = null;
    }

    public void saveAll(ActionEvent actionEvent) throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("saveData.xml"));


        out.writeObject(BakeAnItemController.bakedGoods.head);
        out.writeObject(AddRecipeController.recipeLinkedList.head);
        out.writeObject(AddIngredientsController.ingredient.head);
        out.close();

    }

}
