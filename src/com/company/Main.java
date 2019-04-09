package com.company;

import com.company.cinema.Genre;
import com.company.cinema.Info;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static com.company.cinema.Genre.Musical;
import static com.company.cinema.ViewingOption.Normal;
import static java.awt.SystemColor.info;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        ObservableList list = root.getChildren();
        Scene scene = new Scene(root ,1280, 720);
        scene.getStylesheets().add("file:src/com/company/media/styles.css");
        GridPane  p1 = new GridPane();
        p1.setHgap(0);
        list.add(p1);

        //testing
        int arr[] = {0,1};
       // Movie.Info m1info = new Movie.Info("The greatest showman",90,
        //        "trailer","plot",9,Musical);
        Movie movieArr[] = new Movie[3];
        int test = 0;
        for(Movie m: movieArr)
        {
            test++;
            m = new Movie(true,40,arr,
                    new ViewingOption[]{Normal},
                    new Info(String.format("Movie%d",test),90,
                    "trailer","plot",9, new Genre[]{Musical}));
            p1.add(m.getVb(),test,0);
        }


        primaryStage.setTitle("Cinema application");
        scene.setFill(Color.BROWN);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}