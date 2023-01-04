package com.example.bakeryinformationsystem.Controllers;

import com.example.bakeryinformationsystem.ADT.LinkedList;
import com.example.bakeryinformationsystem.MainPageApplication;
import com.example.bakeryinformationsystem.Models.BakedGoods;
import com.example.bakeryinformationsystem.Models.Ingredients;
import com.example.bakeryinformationsystem.Models.Recipe;
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



public class BakeAnItemController implements Initializable
{

    public static LinkedList<BakedGoods> bakedGoods = new LinkedList<BakedGoods>();
    public static LinkedList<Recipe> recipeLinkedList = AddRecipeController.recipeLinkedList;
//    public static LinkedList<Ingredients> allIngredients = AddIngredientsController.ingredient;

    @FXML
    private TextField OriginInput;

    @FXML
    private TextField imageInput;
    @FXML
    private Button addToListButton;

    @FXML
    private Button backToHomeButton;

    @FXML
    private TextField itemNameInput;

    @FXML
    private ChoiceBox<String> recipeDropDown;

    @FXML
    private ChoiceBox<String> typeDropDown;

    @FXML
    public ListView<String> viewOfAddedItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        typeDropDown.getItems().addAll("Cake","Bread","Pastry");
        recipeDropDown(recipeLinkedList);
        viewOfBakedGoods();
    }

    public void addGoods(BakedGoods bakedGood){
        bakedGoods.addElement(bakedGood);
    }

    public void addBakedGoodsButton(ActionEvent actionEvent)
    {
        String name = itemNameInput.getText();
        String origin = OriginInput.getText();
        String type = typeDropDown.getSelectionModel().getSelectedItem();
        String imageText = imageInput.getText();

//        LinkedList<Recipe> recipeLinkedList = new LinkedList<>();
        BakedGoods bakedGood = new BakedGoods(name,origin,type,imageText,recipeLinkedList);
        //frontend adding of goods
        bakedGoods.addElement(bakedGood);


        viewOfAddedItem.getItems().add(bakedGood.toString());
        addGoods(bakedGood);
        System.out.println(itemNameInput.getText() + "\n" + OriginInput.getText() + "\n" + recipeDropDown.getAccessibleText() + "\n" + typeDropDown.getValue() +"\n" + imageInput.getText());

//        public void addRecipeToList()
//        {

//            String name = nameInput.getText();
//            String quantityAsString = quantityInput.getText();
//            int quantityAsInt = Integer.valueOf(quantityAsString);
//
//
//            Recipe recipe = new Recipe(name,quantityAsInt,allIngredients, recipeIngredients);
//            //frontend adding of goods
//            //addRecipe(recipe);
////    recipeIngredients.addElement();
//            recipeLinkedList.addElement(recipe);
//
//            recipeLinkedList.addToListView(viewOfRecipes);
//            viewOfRecipes(recipe);
//            // viewOfRecipes.getItems().add(recipe.toString());
//
//            System.out.println(nameInput.getText() + "\n" + quantityInput.getText() + "\n" + originInput.getText());
    }

    public void deleteAllGoods() {
        bakedGoods.resetList();
    }

    public void recipeDropDown(LinkedList<Recipe> recipeLinkedList)
    {
        recipeDropDown.getItems().clear();

        for(int i = 0 ; i < recipeLinkedList.listLength() ; i ++)
        {
            recipeDropDown.getItems().add(recipeLinkedList.get(i).toString());
        }
    }

    public int numberOfGoods() {
        int x = bakedGoods.listLength();
        return x;
    }

    public void viewOfBakedGoods()
    {
        viewOfAddedItem.getItems().clear();

        for(int i = 0 ; i < bakedGoods.listLength(); i++)
        {
            viewOfAddedItem.getItems().add(bakedGoods.get(i).toLongString());
        }
    }

//    public void viewOfRecipes()
//    {
//        viewOfRecipes.getItems().clear();
//
//        for(int i = 0 ; i < recipeLinkedList.listLength(); i++)
//        {
//            viewOfRecipes.getItems().add(recipeLinkedList.get(i).toLongString());
//        }
//    }


    public void deleteGood() {
        for (int i = 0; i < bakedGoods.listLength(); i++) {
            if (bakedGoods.isEmpty()) { // stops nullPointerException
                if (viewOfAddedItem.getSelectionModel().getSelectedIndex() == i) {

                    bakedGoods.deleteElement(i);
                    viewOfAddedItem.getItems().remove(i);

                }
            }
        }
    }


    public void resetGoods() {
        //frontend
        viewOfAddedItem.getItems().clear();
        //backend
        deleteAllGoods();
    }


    public void returnToHomePage(ActionEvent actionEvent)
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
