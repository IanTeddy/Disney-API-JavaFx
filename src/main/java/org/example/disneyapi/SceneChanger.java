package org.example.disneyapi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneChanger {

    // function for change scenes
    public static void changeScenes(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(SceneChanger.class.getResource(fxmlFile)));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(SceneChanger.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
