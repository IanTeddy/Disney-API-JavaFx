package org.example.disneyapi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class MovieDetailController {
    public Button backToList;
    // UI components
    @FXML
    private Label movieTitle;
    @FXML
    private ImageView image;
    @FXML
    private Text year;
    @FXML
    private Text runtime;
    @FXML
    private Text genre;
    @FXML
    private Text summary;
    @FXML
    private Text rating;
    @FXML
    private Text directors;
    @FXML
    private Text starts;

    public void initialize() {
        int id = MovieListController.selectedMovieId;
        DisneyMovieDetail movie = null;
        try {
            movie = APIHandler.getMovieDetails(id);

            movieTitle.setText(movie.getTitle());
            year.setText(movie.getYear());
            runtime.setText(movie.getRuntime());
            genre.setText(movie.getGenre());
            summary.setText(movie.getSummary());
            rating.setText(movie.getRating());
            directors.setText(movie.getDirectors());
            starts.setText(movie.getStars());

            if(movie.getImage() != null){
                // examine url by using checkImageUrl method before setting it to imageView
                String reviewedImageUrl = ImageHandler.checkImageUrl(movie.getImage());
                Image img = new Image(reviewedImageUrl);
                // set it to imageView  and make it visible
                image.setImage(img);
                image.setVisible(true);
            }
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            image.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/default-movie.png"))));
        }

    }


    // a button function to send back to previous page
    public void BackToList(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "movie-list.fxml");
    }
}
