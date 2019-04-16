package com.company.uiscenes;

import com.company.Main;
import com.company.cinema.Movie;
import com.company.uiscenes.sections.Header;
import com.company.uiscenes.sections.MediaControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MovieDetails extends VBox implements Updatable {

    // region Constants
    // region Files
    private static final String FILE_TOMATO_FRESH = Main.PATH_RESOURCES_IMG_RATINGS + "fresh_tomato.png";
    private static final String FILE_TOMATO_ROTTEN = Main.PATH_RESOURCES_IMG_RATINGS + "rotten_tomato.png";
    private static final String FILE_IMDB = Main.PATH_RESOURCES_IMG_RATINGS + "imdb.png";
    private static final String FILE_METACRITIC = Main.PATH_RESOURCES_IMG_RATINGS + "metacritic.png";
    // endregion Files
    // endregion Constants

    private Stage window;
    private Label lbl_movieTitle;
    private ImageView imgV_movie;
    private Label lbl_IMDBscore;
    private Label lbl_specs;
    private Label lbl_plot;
    private Text txt_directors;
    private Text txt_writers;
    private Text txt_actors;
    private Label lbl_rottenTomatoes;
    private Image img_rottenTomatoes;
    private Label lbl_metascore;
    private ImageView imgV_rottenTomatoes;
    private MediaPlayer mediaPlayer = null;

    public MovieDetails(Stage window) {
        this.window = window;

        // region Header
        Header header = new Header(window);
        // endregion Header

        //region Overview

        //region Poster
        imgV_movie = new ImageView();
        //endregion Poster

        //region VBOX Movie Description

        //region  HBox Title & Rating
        lbl_movieTitle = new Label();
        lbl_movieTitle.getStyleClass().add("MovieDetailsTitle");

        Region rgn_star = new Region();
        HBox.setHgrow(rgn_star, Priority.ALWAYS);

        Image img_star = new Image("file:" + FILE_IMDB);
        ImageView imgV_star = new ImageView(img_star);

        imgV_star.fitHeightProperty().bind(window.heightProperty().multiply(0.045));
        imgV_star.fitWidthProperty().bind(imgV_star.fitHeightProperty().multiply(img_star.getWidth() / img_star.getHeight()));

        lbl_IMDBscore = new Label();
        lbl_IMDBscore.getStyleClass().add("MovieDetailsIMDB");

        Label lbl_ten = new Label("/10");
        lbl_ten.getStyleClass().add("MovieDetailsTen");


        HBox hbx_title = new HBox();
        hbx_title.getChildren().addAll(lbl_movieTitle, rgn_star, imgV_star, lbl_IMDBscore, lbl_ten);
        hbx_title.setAlignment(Pos.CENTER);
        // endregion  HBox Title & Rating

        //region Plot
        lbl_specs = new Label();
        lbl_specs.getStyleClass().add("MovieDetailsSpecs");

        lbl_plot = new Label();
        lbl_plot.getStyleClass().add("MovieDetailsPlot");
        lbl_plot.setWrapText(true);
        //endregion Plot

        //region Cast
        TextFlow txtFlow_director = new TextFlow();

        Text txt_director = new Text("Director: ");
        txt_director.getStyleClass().add("MovieDetailsInfo");

        txt_directors = new Text();
        txt_directors.getStyleClass().add("MovieDetailsInfoItalic");

        txtFlow_director.getChildren().addAll(txt_director, txt_directors);

        TextFlow txtFlow_writers = new TextFlow();

        Text txt_writer = new Text("Writers: ");
        txt_writer.getStyleClass().add("MovieDetailsInfo");

        txt_writers = new Text();

        txtFlow_writers.getChildren().addAll(txt_writer, txt_writers);

        txt_writers.getStyleClass().add("MovieDetailsInfoItalic");

        TextFlow txtFlow_actors = new TextFlow();

        Text txt_actor = new Text("Actors: ");
        txt_actors = new Text();

        txtFlow_actors.getChildren().addAll(txt_actor, txt_actors);

        txt_actor.getStyleClass().add("MovieDetailsInfo");
        txt_actors.getStyleClass().add("MovieDetailsInfoItalic");

        //endregion Cast

        VBox vbx_plot = new VBox();
        vbx_plot.getChildren().addAll(lbl_plot, txtFlow_director, txtFlow_writers, txtFlow_actors);
        vbx_plot.getStyleClass().add("MovieDetailsVPlot");

        vbx_plot.setPadding(new Insets(10, 20, 10, 20));//todo Magic Number

        VBox vbx_description = new VBox();
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
        String path = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

        FlowPane flow_mediaPlayer = new FlowPane();

        try {
            Media media = new Media(path);

            mediaPlayer = new MediaPlayer(media);

            MediaControl mediaControl = new MediaControl(mediaPlayer); //Class for control overlay


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

        //region Metascore

        HBox hbx_metascore = new HBox();

        lbl_metascore = new Label();
        lbl_metascore.getStyleClass().add("MovieDetailsMetascore");


        Image img_metascore = new Image("file:" + FILE_METACRITIC);
        ImageView imgV_metascore = new ImageView(img_metascore);
        imgV_metascore.fitHeightProperty().bind(window.heightProperty().multiply(0.07));
        imgV_metascore.fitWidthProperty().bind(imgV_metascore.fitHeightProperty().multiply(img_metascore.getWidth() / img_metascore.getHeight()));


        hbx_metascore.getChildren().addAll(lbl_metascore, imgV_metascore);
        hbx_metascore.setSpacing(20);
        hbx_metascore.setAlignment(Pos.CENTER);
        //endregion Metascore

        //region Tomatometer

        HBox hbx_rottenTomatoes = new HBox();


        lbl_rottenTomatoes = new Label();
        lbl_rottenTomatoes.getStyleClass().add("MovieDetailsTomatometer");

        img_rottenTomatoes = new Image("file:" + FILE_TOMATO_FRESH);
        imgV_rottenTomatoes = new ImageView(img_rottenTomatoes);

        imgV_rottenTomatoes.fitHeightProperty().bind(window.heightProperty().multiply(0.055));
        imgV_rottenTomatoes.fitWidthProperty().bind(imgV_rottenTomatoes.fitHeightProperty().multiply(img_rottenTomatoes.getWidth() / img_rottenTomatoes.getHeight()));


        hbx_rottenTomatoes.getChildren().addAll(imgV_rottenTomatoes, lbl_rottenTomatoes);
        hbx_rottenTomatoes.setSpacing(20);
        hbx_rottenTomatoes.setAlignment(Pos.CENTER);
        //endregion Metascore

        HBox hbx_scores = new HBox();
        hbx_scores.getChildren().addAll(hbx_metascore, hbx_rottenTomatoes);
        hbx_scores.setAlignment(Pos.CENTER);
        hbx_scores.setSpacing(20); //todo Magic Number

        // Bottom Padding to make purchase button go down
        hbx_scores.setPadding(new Insets(40, 0, 30, 0)); //todo Magic Number


        //endregion Hbox scores

        MediaPlayer lm_mdPLayer = mediaPlayer;

        Button btn_purchase = new Button("Purchase Tickets");
        btn_purchase.setOnAction(e -> {
            Main.switchScene(2);
            lm_mdPLayer.pause();
        });
        btn_purchase.getStyleClass().add("purchaseBtn");


        VBox vbx_purchase = new VBox();

        vbx_purchase.getChildren().addAll(hbx_scores, btn_purchase);
        vbx_purchase.setAlignment(Pos.TOP_CENTER);

        //endregion Vbox Scores & Purchase

        HBox.setHgrow(vbx_purchase, Priority.ALWAYS);

        HBox hbx_bot = new HBox();

        hbx_bot.setAlignment(Pos.CENTER);
        hbx_bot.getChildren().addAll(flow_mediaPlayer, vbx_purchase);


        //endregion Bottom

        this.getChildren().addAll(header, hbx_overview, hbx_bot);
    }

    public void updateScene() {
        mediaPlayer.play();


        Movie currentMovie = Main.getCurrentMovie();

        lbl_movieTitle.setText(currentMovie.getInfo().getName());
        lbl_IMDBscore.setText(String.valueOf(currentMovie.getInfo().getIMDBscore()));

        lbl_specs.setText(currentMovie.getInfo().getRating() + " | " + currentMovie.getInfo().getDuration() + " min | " + currentMovie.getGenresString());

        lbl_plot.setText(currentMovie.getInfo().getPlot());
        txt_directors.setText(currentMovie.getInfo().getDirector());
        txt_writers.setText(currentMovie.getWritersString());
        txt_actors.setText(currentMovie.getActorsString());

        lbl_metascore.setText(String.valueOf(currentMovie.getInfo().getMetascore()));
        String style;
        if (currentMovie.getInfo().getMetascore() > 60) {
            style = "-fx-background-color: #6c3;";//todo add to the css file
        } else if (currentMovie.getInfo().getMetascore() > 39) {
            style = "-fx-background-color: #fc3;";//todo add to the css file
        } else {
            style = "-fx-background-color: #f00;";//todo add to the css file
        }
        lbl_metascore.setStyle(style);

        lbl_rottenTomatoes.setText(currentMovie.getInfo().getTomatometer() + "%");
        if (currentMovie.getInfo().getTomatometer() > 59) {   //Changes image according to Tomatometer
            img_rottenTomatoes = new Image("file:" + FILE_TOMATO_FRESH);
        } else {
            img_rottenTomatoes = new Image("file:" + FILE_TOMATO_ROTTEN);
        }
        imgV_rottenTomatoes.setImage(img_rottenTomatoes);

        Image img_movie = new Image("file:" + Main.PATH_RESOURCES_IMG_POSTER + currentMovie.getImdbID() + ".jpg");
        imgV_movie.setImage(img_movie);

        imgV_movie.fitHeightProperty().bind(window.heightProperty().multiply(0.52));
        imgV_movie.fitWidthProperty().bind(imgV_movie.fitHeightProperty().multiply(img_movie.getWidth() / img_movie.getHeight()));
    }

}
