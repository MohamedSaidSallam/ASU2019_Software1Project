package com.company;

import com.company.cinema.Genre;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import static com.company.cinema.Genre.Musical;
import static com.company.cinema.ViewingOption.Normal;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


        VBox vbx_main = new VBox();

        Scene scene = new Scene(vbx_main);
        scene.getStylesheets().add("file:src/com/company/media/styles.css");

        // region Top
        // region Content
        Text txt_title = new Text("Cinema Ticket Dispenser");

        Button btn_temp1 = new Button("temp1");
        btn_temp1.getStyleClass().add("btn");

        Button btn_temp2 = new Button("temp2");
        btn_temp2.getStyleClass().add("btn");

        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        // endregion Content

        // region HBox
        HBox hbx_top = new HBox();

        hbx_top.getStyleClass().add("top");
        hbx_top.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        hbx_top.setSpacing(10);//todo magic numbers
        hbx_top.setAlignment(Pos.CENTER);

        hbx_top.getChildren().addAll(txt_title, region, btn_temp1, btn_temp2);
        // endregion HBox
        // endregion Top

        // region Movies
        // region Content
        HBox hbx_movies = new HBox(17);//todo magic numbers
        hbx_movies.getStyleClass().add("scroll");

        Movie[] movieArr = new Movie[9];
        int test = 0;
        for (Movie movie : movieArr) {
            test++;

            movie = new Movie(test, true, new int[]{0, 1},
                        new ViewingOption[]{Normal}, String.format("Movie%d", test),
                        90, "trailer", "plot",
                        9, new Genre[]{Musical});

            hbx_movies.getChildren().add(movie.getVbx());
        }
        // endregion Content

        // region ScrollPane
        ScrollPane sp_movies = new ScrollPane();
        sp_movies.setContent(hbx_movies);

        sp_movies.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp_movies.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);//todo auto-hide ?
        sp_movies.setPannable(true);

        sp_movies.setFitToHeight(true);

        sp_movies.prefWidthProperty().bind(scene.widthProperty());
        sp_movies.prefHeightProperty().bind(scene.heightProperty());

        sp_movies.getStyleClass().add("scroll");
        // endregion ScrollPane
        // endregion Movies

        vbx_main.getChildren().addAll(hbx_top, sp_movies);

        primaryStage.setFullScreen(true);
        primaryStage.setTitle("CTD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
