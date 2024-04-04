module org.example.disneyapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens org.example.disneyapi to com.google.gson, javafx.fxml;
    exports org.example.disneyapi;
}