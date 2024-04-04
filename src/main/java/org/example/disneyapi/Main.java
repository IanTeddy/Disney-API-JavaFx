package org.example.disneyapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("search-view.fxml"));
        Scene scene = new Scene(root,755 , 510);

        // add stylesheet to scene
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Load the icon image
        Image iconImage = new Image(getClass().getResource("images/disney-logo.png").toExternalForm());
        // Set the stage icon
        stage.getIcons().add(iconImage);
        stage.setTitle("Disney Movie Library");
        stage.setScene(scene);
        stage.show();
    }

    // main method
    public static void main(String[] args) {
        launch();
    }
}

