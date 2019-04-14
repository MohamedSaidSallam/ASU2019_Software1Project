package com.company;

import com.company.ui.SelectionScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new SelectionScene(stage));
        scene.getStylesheets().add("file:src/resources/style.css");
        stage.setScene(scene);

        stage.show();
        stage.setFullScreen(true);
    }
}