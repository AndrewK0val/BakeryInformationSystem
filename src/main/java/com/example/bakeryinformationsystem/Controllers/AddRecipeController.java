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
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddRecipeController implements Initializable
{
    public static LinkedList<Ingredients> recipeIngredients = new LinkedList<Ingredients>();
    public static LinkedList<Ingredients> allIngredients = AddIngredientsController.ingredient;
//    public static LinkedList<Ingredients> ingredients

    public static LinkedList<Recipe> recipeLinkedList = new LinkedList<Recipe>();
    @FXML
    private Button addRecipeButton;
    @FXML
    Label recipeName;

    @FXML
    private ChoiceBox<Ingredients> ingredientDropDown;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField originInput;

    @FXML
    private TextField quantityInput;

    @FXML
    private Button returnHomeButton;

    @FXML
    private ListView<Recipe> viewOfRecipes;

    @FXML
    private ListView<Ingredients> viewOfRecipeIngredients;

    private Recipe chosenRecipe;



    // for 1st ingredient, run a while loop to find all ingredients and add to dropdown

//    public void ingredients


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
//        ingredientDropDown.getItems().addAll(String.valueOf(allIngredients));
        ingredientDropDown(allIngredients);
        viewOfRecipes();
    }
    public void addIngredientToRecipe()
    {

        if(chosenRecipe!=null)
        {
            String name = ingredientDropDown.getSelectionModel().getSelectedItem().getName();
            float calories = ingredientDropDown.getSelectionModel().getSelectedItem().getCalories();
            String texture = ingredientDropDown.getSelectionModel().getSelectedItem().getTexture();
            Ingredients ing = new Ingredients( name, calories, texture);
            chosenRecipe.recipeIngredients.addElement(ing);
            chosenRecipe.recipeIngredients.addToListView(viewOfRecipeIngredients);
            System.out.println(ingredientDropDown.getSelectionModel().getSelectedItem().getName());
        }


    }

    public void addRecipeToList() {


    String name = nameInput.getText();
    String quantityAsString = quantityInput.getText();
    int quantityAsInt = Integer.valueOf(quantityAsString);
    float totalCalories = 0;

    Recipe recipe = new Recipe(name,quantityAsInt, recipeIngredients, totalCalories);
    //frontend adding of goods

    recipeLinkedList.addElement(recipe);
    recipeLinkedList.addToListView(viewOfRecipes);
//    viewOfRecipes(recipe);
   // viewOfRecipes.getItems().add(recipe.toString());
    System.out.println(nameInput.getText() + "\n" + quantityInput.getText() + "\n" + originInput.getText());
}



//    ingredientDropDown.getItems().clear();

   // for (int i = allIngredients.listLength() - 1; i >=0; i-- ) {
    //     ingredientDropDown.getItems().add(ingredients.get(i).getName());
    // }
//    LinkedNode<Ingredients> temp = allIngredients.head;
//    while(temp != null)
//    {
//        ingredientDropDown.getItems().add(temp.toString());

//    }


//    }


    public void ingredientDropDown(LinkedList<Ingredients> allIngredients)
    {
        ingredientDropDown.getItems().clear();

        for(int i = 0 ; i < allIngredients.listLength() ; i ++)
        {
            ingredientDropDown.getItems().add(allIngredients.get(i));
        }
    }

//    public void addRecipe(Recipe recipe) //button for adding the ingredients to the linked list
//    {
//        recipeLinkedList.addElement(recipe);
//    }

    public void deleteAllRecipes() {
        recipeLinkedList.resetList();
    }

    public int numberOfRecipes() {
        int x = recipeLinkedList.listLength();
        return x;
    }
    public void deleteRecipe() {
        for (int i = 0; i < recipeLinkedList.listLength(); i++) {
            if (recipeLinkedList.isEmpty()) { // stops nullPointerException
                if (viewOfRecipes.getSelectionModel().getSelectedIndex() == i) {

                    recipeLinkedList.deleteElement(i);
                    viewOfRecipes.getItems().remove(i);

                }
            }
        }
    }


    public void viewOfRecipes()
    {
        viewOfRecipes.getItems().clear();

        for(int i = 0 ; i < recipeLinkedList.listLength(); i++)
        {
            viewOfRecipes.getItems().add(recipeLinkedList.get(i));
        }
    }
//    public void viewOfIngredients() //updates the listview with the linked list
//    {
//        viewOfIngredients.getItems().clear();
//
//        for(int i = 0 ; i < ingredient.listLength(); i++)
//        {
//            viewOfIngredients.getItems().add(ingredient.get(i).toString());
//
//        }
//    }

    public void chooseRecipe(){ // when you click on a recipe in the  recipes listview, it takes the name of that recipe and sets the text of the recipe ingredients label to that name
    chosenRecipe = viewOfRecipes.getSelectionModel().getSelectedItem();
    recipeName.setText(chosenRecipe.getName());
    }


    public void resetRecipes() {
        //frontend
        viewOfRecipes.getItems().clear();
        //backend
        deleteAllRecipes();
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
