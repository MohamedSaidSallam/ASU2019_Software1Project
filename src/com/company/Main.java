package com.company;

import com.company.cinema.Movie;
import com.company.ui.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage window;
    private static Scene scene;
    private static Pane[] panes = new Pane[4];

    private static Movie currentMovie;

    public static void main(String[] args) {
        launch(args);
    }

    public static void switchScene(int index) {
        ((Updatable) panes[index]).updateScene();
        scene.setRoot(panes[index]);


    }

    @Override
    public void start(Stage primaryStage) {
        panes[0] = new BrowseMovies(primaryStage);
        panes[1] = new MovieDetails(primaryStage);
        panes[2] = new SeatSelection(primaryStage);
        panes[3] = new TicketPayment(primaryStage);

        window = primaryStage;

        scene = new Scene(panes[0]);
        scene.getStylesheets().add("file:src/resources/styles.css");

        primaryStage.setScene(scene);

        window.setFullScreen(true);
        window.setTitle("CTD");
        window.setScene(scene);
        window.show();
    }

    public static Movie getCurrentMovie() {
        return currentMovie;
    }

    public static void setCurrentMovie(Movie currentMovie) {
        Main.currentMovie = currentMovie;
    }
}
