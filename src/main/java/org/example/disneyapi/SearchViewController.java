package org.example.disneyapi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

// class for control search-view.fxml
public class SearchViewController {

    public static String searchWord;
    // FXML components
    @FXML
    private Label welcomeLabel;

    @FXML
    private TextField searchBar;
    @FXML
    private Button searchBtn;



    // on click function for search button
    @FXML
    public void onSearchBtnClick(ActionEvent event) throws IOException {
        // call capitalizeFirstLetter method and assign it to searchWord
        searchWord = capitalizeFirstLetter(searchBar.getText());
        SceneChanger.changeScenes(event, "movie-list.fxml");
    }

    // a method to capitalize first letter of user input so that API can read a query properly
    public static String capitalizeFirstLetter(String input) {
        // split the input string into words
        String[] words = input.split("\\s+"); // Split by whitespace

        // create a StringBuilder to construct the transformed string
        StringBuilder result = new StringBuilder();

        // iterate through the words
        for (String word : words) {
            // Capitalize the first letter of each word and append it to the result
            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }
        // Remove space and return the transformed string
        return result.toString().trim();
    }

    public static String getSearchWord() {
        return searchWord;
    }

    public static void setSearchWord(String searchWord) {
        SearchViewController.searchWord = searchWord;
    }
}