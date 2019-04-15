package com.company;

import com.company.cinema.Movie;
import com.company.ui.BrowseMovies;
import com.company.ui.MovieDetails;
import com.company.ui.SelectionScene;
import com.company.ui.Updatable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    // region Constants
    // region Files
    private static final String PATH_RESOURCES = "src/resources/";

    public static final String PATH_RESOURCES_IMG = PATH_RESOURCES + "img/";
    public static final String PATH_RESOURCES_IMG_POSTER = PATH_RESOURCES_IMG + "poster/";
    public static final String PATH_RESOURCES_IMG_RATINGS = PATH_RESOURCES_IMG + "ratings/";

    private static final String FILE_STYLES = PATH_RESOURCES + "styles.css";
    // endregion Files
    // endregion Constants

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
        panes[2] = new SelectionScene(primaryStage);
//        panes[3] = new MovieDetails(primaryStage);

        window = primaryStage;

        scene = new Scene(panes[0]);
        scene.getStylesheets().add("file:" + FILE_STYLES);

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

    public static Button createButton(String text, float widthScale, float heightScale) {
        Button button = new Button(text);

        button.prefWidthProperty().bind(window.widthProperty().multiply(widthScale));
        button.prefHeightProperty().bind(window.heightProperty().multiply(heightScale));

        button.getStyleClass().add("btn");

        return button;
    }
}
