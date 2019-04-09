package com.company;

import com.company.cinema.Genre;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.company.cinema.Genre.Musical;
import static com.company.cinema.ViewingOption.Normal;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vb_main = new VBox();
        ScrollPane sp = new ScrollPane();

        Scene scene = new Scene(vb_main, 1440, 720);
        scene.getStylesheets().add("file:src/com/company/media/styles.css");

        sp.prefWidthProperty().bind(scene.widthProperty());
        sp.prefHeightProperty().bind(scene.heightProperty());
        HBox topMenu = new HBox();// never use HBox for menus
        topMenu.getStyleClass().add("top");
        Button btn_temp1 = new Button("temp1");
        btn_temp1.getStyleClass().add("my-butt");
        topMenu.getChildren().addAll(btn_temp1);
        vb_main.getChildren().add(topMenu);

        vb_main.getChildren().add(sp);
        HBox hBox = new HBox(17);
        hBox.getStyleClass().add("scroll");
        Text t = new Text("Cinema ticket dispenser");

        sp.setContent(hBox);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setFitToHeight(true);

        sp.setPannable(true);
        sp.getStyleClass().add("scroll");
        //testing
        int arr[] = {0, 1};
        Movie movieArr[] = new Movie[9];
        int test = 0;
        for (Movie m : movieArr) {
            test++;
            m = new Movie(true, arr,
                    new ViewingOption[]{Normal},
                    String.format("Movie%d", test), 90,
                    "trailer", "plot", 9, new Genre[]{Musical});
//            hBox.add(m.getVb(),test,0);
//            m.getVb().prefHeightProperty().bind();
            hBox.getChildren().add(m.getVb());

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