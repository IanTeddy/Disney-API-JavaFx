package org.example.disneyapi;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

// Controller clas of movie-list.fxml
public class MovieListController implements Initializable {

    public Button backBtn;
    // UI components
    @FXML
    private TextField keyword;
    @FXML
    private ListView<String> listView;
    @FXML
    private ImageView image;
    @FXML
    private Text movieCounts;
    @FXML
    private Button moreInfoBtn;

    // instance variable
    static int selectedMovieId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // set moreInfo button invisible
        moreInfoBtn.setVisible(false);
        keyword.setText("\uD83E\uDE84" + "  " + SearchViewController.searchWord);
        // display the entered keyword from the search-view scene
        String query = SearchViewController.searchWord;

        // prepare APIHandler object
        APIHandler apiHandler = new APIHandler();
        // create the endpoint for search movies
        String queryURL = "/search?query=" + query;

        // create apiResponse as String type
        String apiResponse;
        try {
            // assign the result from API to apiResponse
            apiResponse = apiHandler.callAPI(queryURL);
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        // parse JSON data(API response) to a list of DisneyMovie objects
        List<DisneyMovie> listOfMovies = apiHandler.parseJsonDisneyMovie(apiResponse);
        // If particular movies are found
        if (!listOfMovies.isEmpty()) {
            // loop through each DisneyMovie objects and add them to listview
            for (DisneyMovie movie : listOfMovies) {
                listView.getItems().addAll(movie.toString());

                // set the event handler of mouse click using a lambda expression
                listView.setOnMouseClicked(mouseEvent -> {
                    // get the selected movie
                    String selectedItem = listView.getSelectionModel().getSelectedItem();
                    // find the corresponding DisneyMovie object
                    DisneyMovie selectedMovie = null;
                    for (DisneyMovie movieInList : listOfMovies) {
                        if (movieInList.toString().equals(selectedItem)) {
                            selectedMovie = movieInList;
                            break;
                        }
                    }

                    if (selectedMovie != null) {
                        // get movie id for next step(displaying detail)
                        selectedMovieId = selectedMovie.getMovieId();
                        try { // call the displayImage method with the selected movie as a parameter
                            String selectedMovieImageUrl = selectedMovie.getImage();
                            // call checkImageUrl function and check if the url is not returning 404
                            String checkedUrl = ImageHandler.checkImageUrl(selectedMovieImageUrl);
                            // create an Image object, set it to imageView and make it visible
                            Image img = new Image(checkedUrl);
                            image.setImage(img);
                            image.setVisible(true);
                            moreInfoBtn.setVisible(true);

                        } catch (IllegalArgumentException e) {
                            // if URL is not correct or doesn't have image URL, display the default image
                            image.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/default-movie.png"))));
                            image.setVisible(true);
                        }
                        image.setVisible(true);
                    } else {
                        image.setVisible(false);
                    }
                });
                // display how many related movies are found
                movieCounts.setText("Movies Found: " + listView.getItems().size());
            }
        } else {
            // if no movies are found, display a message
            movieCounts.setText("No movies are found");
        }
    }


    // function for button click that send back to search view
    public void BackToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "search-view.fxml");
    }

    // function for button click that go to movie-detail view
    public void MoreInfo(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "movie-detail.fxml");
    }

}
