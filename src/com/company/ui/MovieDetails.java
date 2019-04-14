package com.company.ui;

import com.company.cinema.Genre;
import com.company.cinema.MPAA;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
import resources.videos.MediaControl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import static com.company.cinema.Genre.Musical;
import static com.company.cinema.Genre.Thriller;
import static com.company.cinema.ViewingOption.Normal;

public class MovieDetails extends Application {

    @Override
    public void start(Stage primaryStage) {
        Movie movie = new Movie(1, true, new int[]{0, 1},
                new ViewingOption[]{Normal}, String.format("Movie %d", 0), MPAA.PG,
                90, "trailer", "Tincidunt eget adipiscing cubilia vel purus potenti senectus tristique, praesent egestas torquent lectus placerat nullam curae arcu nostra, iaculis erat commodo consectetur class potenti posuere pretium pulvinar libero id curabitur class lacinia nostra luctus.",
                9, 20, 99, new Genre[]{Musical, Thriller}, new String[]{"Actor1", "Actor2"}, new String[]{"Writer1", "Writer2"}, "Director");

        Scene movieDetails;
        Stage window;

        window = primaryStage;
        VBox vbx_main = new VBox();

        movieDetails = new Scene(vbx_main);
        movieDetails.getStylesheets().add("file:src/resources/styles.css");


        // region Top
        // region Content
        Image img_logo = new Image("file:src/com/company/media/images/placeholder/logo.png");
        ImageView imgV_logo = new ImageView(img_logo);

        imgV_logo.fitHeightProperty().bind(window.heightProperty().multiply(0.06));
        imgV_logo.fitWidthProperty().bind(imgV_logo.fitHeightProperty().multiply(img_logo.getWidth() / img_logo.getHeight()));


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

        hbx_top.getChildren().addAll(imgV_logo, lbl_title, region, btn_temp1, btn_temp2);
        // endregion HBox
        // endregion top

        //region Overview

        //region Poster
        Image img_movie = new Image("file:src/com/company/media/images/1.jpg");
        ImageView imgV_movie = new ImageView(img_movie);
        imgV_movie.fitHeightProperty().bind(window.heightProperty().multiply(0.52));
        imgV_movie.fitWidthProperty().bind(imgV_movie.fitHeightProperty().multiply(img_movie.getWidth() / img_movie.getHeight()));


        //endregion Poster

        //region VBOX Movie Description

        //region  HBox Title & Rating
        Label lbl_movieTitle = new Label(movie.getInfo().getName());
        lbl_movieTitle.getStyleClass().add("MovieDetailsTitle");


        Image img_star = new Image("file:src/com/company/media/images/ratings/imdb.png");
        ImageView imgV_star = new ImageView(img_star);
        imgV_star.fitHeightProperty().bind(window.heightProperty().multiply(0.045));
        imgV_star.fitWidthProperty().bind(imgV_star.fitHeightProperty().multiply(img_star.getWidth() / img_star.getHeight()));


        Region rgn_star = new Region();
        HBox.setHgrow(rgn_star, Priority.ALWAYS);


        Label lbl_IMDBscore = new Label(String.valueOf(movie.getInfo().getIMDBscore()));
        lbl_IMDBscore.getStyleClass().add("MovieDetailsIMDB");

        Label lbl_ten = new Label("/10");
        lbl_ten.getStyleClass().add("MovieDetailsTen");


        HBox hbx_title = new HBox();
        hbx_title.getChildren().addAll(lbl_movieTitle, rgn_star, imgV_star, lbl_IMDBscore, lbl_ten);
        hbx_title.setSpacing(1);
        hbx_title.setAlignment(Pos.CENTER);
        // endregion  HBox Title & Rating

        //region Plot

        Label lbl_specs = new Label(movie.getInfo().getRating() + " | " + movie.getInfo().getDuration() + " | " + movie.getGenresString());
        lbl_specs.getStyleClass().add("MovieDetailsSpecs");

        Label lbl_plot = new Label(movie.getInfo().getPlot());
        lbl_plot.getStyleClass().add("MovieDetailsPlot");
        lbl_plot.setWrapText(true);  // Makes text in multiple lines

        //endregion Plot


        //region Cast
        TextFlow txtFlow_director = new TextFlow();

        Text txt_director = new Text("Director: ");
        Text txt_directors = new Text(movie.getInfo().getDirector());

        txtFlow_director.getChildren().addAll(txt_director, txt_directors);
        txtFlow_director.setPadding(new Insets(25, 0, 0, 30)); //todo Magic Number


        txt_director.getStyleClass().add("MovieDetailsInfo");
        txt_directors.getStyleClass().add("MovieDetailsInfoItalic");


        TextFlow txtFlow_writers = new TextFlow();

        Text txt_writer = new Text("Writers: ");
        Text txt_writers = new Text(movie.getWritersString());

        txtFlow_writers.getChildren().addAll(txt_writer, txt_writers);

        txt_writer.getStyleClass().add("MovieDetailsInfo");
        txt_writers.getStyleClass().add("MovieDetailsInfoItalic");

        txtFlow_writers.setPadding(new Insets(0, 0, 0, 30)); //todo Magic Number


        TextFlow txtFlow_actors = new TextFlow();

        Text txt_actor = new Text("Actors: ");
        Text txt_actors = new Text(movie.getActorsString());

        txtFlow_actors.getChildren().addAll(txt_actor, txt_actors);
        txtFlow_actors.setPadding(new Insets(0, 0, 0, 30)); //todo Magic Number

        txt_actor.getStyleClass().add("MovieDetailsInfo");
        txt_actors.getStyleClass().add("MovieDetailsInfoItalic");

        //endregion Cast

        VBox vbx_plot = new VBox();
        vbx_plot.getChildren().addAll(lbl_plot, txtFlow_director, txtFlow_writers, txtFlow_actors);
        vbx_plot.getStyleClass().add("MovieDetailsVPlot");


        VBox vbx_description = new VBox();
        vbx_description.setMinHeight(300); //todo Magic Number
        vbx_description.setSpacing(2);  //todo Magic Number


        vbx_description.getChildren().addAll(hbx_title, lbl_specs, vbx_plot);

        VBox.setVgrow(vbx_plot, Priority.ALWAYS);
        HBox.setHgrow(vbx_description, Priority.ALWAYS);
        //endregion Movie Description

        Region rgn_overview = new Region();

        HBox hbx_overview = new HBox();
        hbx_overview.setPadding(new Insets(30, 10, 10, 50)); //todo Magic Number
        hbx_overview.setSpacing(15); //todo Magic Number
        hbx_overview.setAlignment(Pos.CENTER_LEFT);

        hbx_overview.getChildren().addAll(imgV_movie, vbx_description, rgn_overview);
        hbx_overview.getStyleClass().add("MovieDetailsOverview");

        //endregion Overview

        //region Bottom


        //region Media Player


        String path = "file:///C:/Users/Sameh/Desktop/Software%20Test/ASU2019_Software1Project/src/com/company/sample.mp4";

        //Stack Pane to set Padding

        FlowPane flow_mediaPlayer = new FlowPane();
        try {
            Media media = new Media(path);

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            MediaControl mediaControl = new MediaControl(mediaPlayer); //Class for control overlay


            mediaPlayer.setAutoPlay(true); //

            flow_mediaPlayer.getChildren().add(mediaControl);
            flow_mediaPlayer.setPadding(new Insets(15, 0, 0, 50));
            flow_mediaPlayer.setAlignment(Pos.CENTER);
        } catch (Exception e) {
            flow_mediaPlayer.setMinHeight(350);
            flow_mediaPlayer.setMinWidth(500);
        }

        //endregion Media Player

        //region Vbox Scores & Purchase

        //region Hbox scores
        HBox hbx_scores = new HBox();

        //region Metascore

        HBox hbx_metascore = new HBox();


        Label lbl_metascore = new Label(String.valueOf(movie.getInfo().getMetascore()));
        lbl_metascore.getStyleClass().add("MovieDetailsMetascore");
        if (movie.getInfo().getMetascore() > 60) {                //Changes background color according to Metascore
            String style = "-fx-background-color: #6c3;";
            lbl_metascore.setStyle(style);
        } else if (movie.getInfo().getMetascore() > 39) {
            String style = "-fx-background-color: #fc3;";
            lbl_metascore.setStyle(style);
        } else {
            String style = "-fx-background-color: #f00;";
            lbl_metascore.setStyle(style);
        }

        Image img_metascore = new Image("file:src/com/company/media/images/ratings/metacritic.png");
        ImageView imgV_metascore = new ImageView(img_metascore);
        imgV_metascore.fitHeightProperty().bind(window.heightProperty().multiply(0.07));
        imgV_metascore.fitWidthProperty().bind(imgV_metascore.fitHeightProperty().multiply(img_metascore.getWidth() / img_metascore.getHeight()));


        hbx_metascore.getChildren().addAll(lbl_metascore, imgV_metascore);
        hbx_metascore.setSpacing(20);
        hbx_metascore.setAlignment(Pos.TOP_LEFT);
        //endregion Metascore

        //region Tomatometer

        HBox hbx_rottenTomatoes = new HBox();


        Label lbl_rottenTomatoes = new Label(movie.getInfo().getTomatometer() + "%");
        lbl_rottenTomatoes.getStyleClass().add("MovieDetailsTomatometer");

        ImageView imgV_rottenTomatoes;
        Image img_rottenTomatoes;

        if (movie.getInfo().getTomatometer() > 59) {   //Changes image according to Tomatometer
            img_rottenTomatoes = new Image("file:src/com/company/media/images/ratings/fresh_tomato.png");
        } else {
            img_rottenTomatoes = new Image("file:src/com/company/media/images/ratings/fresh_tomato.png");
        }

        imgV_rottenTomatoes = new ImageView(img_rottenTomatoes);
        imgV_rottenTomatoes.fitHeightProperty().bind(window.heightProperty().multiply(0.055));
        imgV_rottenTomatoes.fitWidthProperty().bind(imgV_rottenTomatoes.fitHeightProperty().multiply(img_rottenTomatoes.getWidth() / img_rottenTomatoes.getHeight()));


        hbx_rottenTomatoes.getChildren().addAll(imgV_rottenTomatoes, lbl_rottenTomatoes);
        hbx_rottenTomatoes.setSpacing(20);
        hbx_rottenTomatoes.setPadding(new Insets(10, 0, 0, 100));
        hbx_rottenTomatoes.setAlignment(Pos.TOP_LEFT);
        //endregion Metascore


        hbx_scores.getChildren().addAll(hbx_metascore, hbx_rottenTomatoes);
        hbx_scores.setAlignment(Pos.CENTER);

        // Bottom Padding to make purchase button go down
        hbx_scores.setPadding(new Insets(40, 0, 30, 0)); //todo Magic Number


        //endregion Hbox scores


        Button btn_purchase = new Button("Purchase Tickets");

        btn_purchase.getStyleClass().add("purchaseBtn");
        btn_purchase.setFont(Font.font("Helvetica", 32));
        btn_purchase.setMinSize(500, 75); //todo Magic Number


        VBox vbx_purchase = new VBox();

        vbx_purchase.getChildren().addAll(hbx_scores, btn_purchase);
        vbx_purchase.setSpacing(20); //todo Magic Number
        vbx_purchase.setAlignment(Pos.TOP_CENTER);

        //endregion Vbox Scores & Purchase

        Region rg3 = new Region();
        HBox.setHgrow(vbx_purchase, Priority.ALWAYS);

        HBox hbx_bot = new HBox();

        hbx_bot.setAlignment(Pos.CENTER);
        hbx_bot.getChildren().addAll(flow_mediaPlayer, vbx_purchase, rg3);
        hbx_bot.setSpacing(30);  //todo Magic Number

        Region rgn_bot = new Region(); // To replace padding below media player


        //endregion Bottom


        VBox vbx_movieDetails = new VBox();
        movieDetails = new Scene(vbx_movieDetails);
        movieDetails.getStylesheets().add("file:src/com/company/media/styles.css");
        vbx_movieDetails.getChildren().addAll(hbx_top, hbx_overview, hbx_bot, rgn_bot);


        window.setFullScreen(true);
        window.setTitle("CTD");
        window.setScene(movieDetails);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
