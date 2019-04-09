package com.company;

import com.company.cinema.Genre;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


import static com.company.cinema.Genre.Musical;
import static com.company.cinema.Genre.Thriller;
import static com.company.cinema.ViewingOption.Normal;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {


        VBox vbx_main = new VBox();

        Scene scene = new Scene(vbx_main);
        scene.getStylesheets().add("file:src/com/company/media/styles.css");

        // region Top
        // region Content
        ImageView img_logo = new ImageView(new Image("file:src/com/company/media/images/placeholder/logo.png"));
        img_logo.setFitHeight(75); //todo magicNumber
        img_logo.setFitWidth(75);  //todo magicNumber

        Label lbl_title = new Label("Cinema Ticket Dispenser");
        lbl_title.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));//todo magicNumber

        Button btn_temp1 = new Button("temp1");
        btn_temp1.getStyleClass().add("btn");

        Button btn_temp2 = new Button("temp2");
        btn_temp2.getStyleClass().add("btn");

        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        // endregion Content

        // region HBox
        HBox hbx_top = new HBox();

        hbx_top.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        hbx_top.setSpacing(10);//todo magic numbers
        hbx_top.setAlignment(Pos.CENTER);

        hbx_top.getChildren().addAll(img_logo, lbl_title, region, btn_temp1, btn_temp2);
        // endregion HBox
        // endregion Top

        // region Movies
        // region Content
        HBox hbx_movies = new HBox();

        hbx_movies.setSpacing(10);//todo magic numbers

        Movie[] movieArr = new Movie[9];
        int test = 0;
        for (Movie movie : movieArr) {
            test++;

            movie = new Movie(test, true, new int[]{0, 1},
                        new ViewingOption[]{Normal}, String.format("Movie %d", test),
                        90, "trailer", "plot",
                        9, new Genre[]{Musical, Thriller});

            hbx_movies.getChildren().add(createMovieVBox(movie));
        }
        // endregion Content

        // region ScrollPane
        ScrollPane sp_movies = new ScrollPane();
        sp_movies.setContent(hbx_movies);

        sp_movies.setPadding(new Insets(10, 0, 10, 0)); //todo magic numbers

        sp_movies.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp_movies.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);//todo auto-hide ?
        sp_movies.setPannable(true);

        sp_movies.setFitToHeight(true);

        sp_movies.prefWidthProperty().bind(scene.widthProperty());
        sp_movies.prefHeightProperty().bind(scene.heightProperty());

        sp_movies.getStyleClass().addAll("NoFocus", "scroll");
        // endregion ScrollPane
        // endregion Movies

        vbx_main.getChildren().addAll(hbx_top, sp_movies);

        vbx_main.getStyleClass().add("main");

        primaryStage.setFullScreen(true);
        primaryStage.setTitle("CTD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private VBox createMovieVBox(Movie movie){
        Label lbl_movieTitle = new Label(movie.getInfo().getName());
        lbl_movieTitle.getStyleClass().add("MovieTitle");

        ImageView imageView = new ImageView(new Image(String.format("file:src/com/company/media/images/%d.jpg", movie.getId())));
        imageView.setFitHeight(445); //todo magicNumber
        imageView.setFitWidth(300);  //todo magicNumber

        Label lbl_caption = new Label(movie.getGenresString());
        lbl_caption.getStyleClass().add("MovieCaption");

        HBox hbx_caption = new HBox();
        hbx_caption.setAlignment(Pos.CENTER);
        hbx_caption.getChildren().add(lbl_caption);

        Button btn_buy = new Button("Buy ticket");
        btn_buy.getStyleClass().add("btn");
        btn_buy.setPrefWidth(imageView.getFitWidth());

        VBox vbx = new VBox();
        vbx.setPadding(new Insets(10, 50, 50, 50));//todo magic numbers
        vbx.setSpacing(10);//todo magic numbers
        vbx.getStyleClass().add("MovieCard");

        vbx.prefHeightProperty().unbind();

        vbx.getChildren().addAll(lbl_movieTitle, imageView, hbx_caption, btn_buy);

        return vbx;
    }
}
