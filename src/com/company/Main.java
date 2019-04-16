package com.company;

import com.company.cinema.Genre;
import com.company.cinema.MPAA;
import com.company.cinema.Movie;
import com.company.cinema.ticket.Order;
import com.company.externalapi.imdb.IMDB;
import com.company.externalapi.imdb.response.IMDBResponse;
import com.company.externalapi.imdb.response.Rating;
import com.company.json.JsonParser;
import com.company.prototyping.APIData;
import com.company.prototyping.APIProto;
import com.company.uiscenes.*;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    // region Constants
    // region Files
    private static final String PATH_RESOURCES = "src/resources/";

    public static final String PATH_RESOURCES_IMG = PATH_RESOURCES + "img/";
    public static final String PATH_RESOURCES_IMG_POSTER = PATH_RESOURCES_IMG + "poster/";
    public static final String PATH_RESOURCES_IMG_RATINGS = PATH_RESOURCES_IMG + "ratings/";

    private static final String PATH_RESOURCES_JSON = PATH_RESOURCES + "json/";
    private static final String PATH_RESOURCES_JSON_MOVIES = PATH_RESOURCES_JSON + "movies/";

    private static final String FILE_STYLES = PATH_RESOURCES + "styles.css";
    private static final String FILE_ICON = PATH_RESOURCES_IMG + "CTD_Logo.png";
    // endregion Files
    // endregion Constants

    // region Variables
    private static Stage window;
    private static Scene scene;
    private static Pane[] panes = new Pane[4];

    private static Movie currentMovie;
    private static Order currentOrder;
    // endregion Variables

    // region accessors
    public static Movie getCurrentMovie() {
        return currentMovie;
    }

    public static Order getCurrentOrder() {
        return currentOrder;
    }
    // endregion accessors

    // region mutators
    public static void setCurrentMovie(Movie currentMovie) {
        Main.currentMovie = currentMovie;
    }

    public static void setCurrentOrder(Order currentOrder) {
        Main.currentOrder = currentOrder;
    }
    // endregion mutators

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Started.."); //todo delete me

        window = primaryStage;

        List<Movie> movies = getMoviesList();

        panes[0] = new BrowseMovies(primaryStage, movies);
        panes[1] = new MovieDetails(primaryStage);
        panes[2] = new SeatSelection(primaryStage);
        panes[3] = new TicketPayment(primaryStage);

        scene = new Scene(panes[0]);
        scene.getStylesheets().add("file:" + FILE_STYLES);

        window.getIcons().add(new Image("file:" + FILE_ICON));
        window.setFullScreen(true);
        window.setTitle("CTD");
        window.setScene(scene);
        window.show();
    }

    public static void switchScene(int index) {
        ((Updatable) panes[index]).updateScene();
        scene.setRoot(panes[index]);
    }

    private List<Movie> getMoviesList() {
        List<APIData> apiDataList = JsonParser.stringToAPIData(APIProto.getAPIData());
        List<Movie> movies = new ArrayList<>();
        List<String> localDataIDs = new ArrayList<>();

        File[] jsonFolder = new File(PATH_RESOURCES_JSON_MOVIES).listFiles();

        if (jsonFolder != null) {
            for (File file : jsonFolder) {
                if (!file.isDirectory()) {
                    localDataIDs.add(file.getName().substring(0, file.getName().length() - 5));
                }
            }
        }

        for (APIData apiData : apiDataList) {
            IMDBResponse imdbResponse;
            if (localDataIDs.contains(apiData.getImdbID())) {
                localDataIDs.remove(apiData.getImdbID());

                imdbResponse = JsonParser.readIMDBResponse(apiData.getImdbID());
            } else {
                imdbResponse = IMDB.getMovieDetails(apiData.getImdbID());

                JsonParser.writeMovie(imdbResponse);

                try {
                    Image image = new Image(imdbResponse.getPoster());
                    BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
                    File output = new File(PATH_RESOURCES_IMG_POSTER + imdbResponse.getImdbID() + ".jpg");
                    ImageIO.write(bufferedImage, "jpg", output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            movies.add(getMovieFromIMDBResponse(apiData, imdbResponse));
        }

        for (String name : localDataIDs) {
            new File(PATH_RESOURCES_JSON_MOVIES + name + ".json").delete();
        }

        return movies;
    }

    private Movie getMovieFromIMDBResponse(APIData apiData, IMDBResponse imdbResponse) {
        //todo move to IMDB class ?
        int rottenScore = getRottenScore(imdbResponse);

        List<Genre> genres = getGenres(imdbResponse);

        return new Movie(
                imdbResponse.getImdbID(),
                apiData.isAvailable(),
                new int[]{0}, //todo temp
                apiData.getViewingOptions(),
                new Movie.Info(
                        imdbResponse.getTitle(),
                        MPAA.valueOf(imdbResponse.getRated().replaceAll("-", "")),
                        Integer.parseInt(imdbResponse.getRuntime().substring(0, imdbResponse.getRuntime().length() - 4)),
                        apiData.getTrailer(),
                        imdbResponse.getPlot(),
                        Float.parseFloat(imdbResponse.getImdbRating()),
                        Integer.parseInt(imdbResponse.getMetascore()),
                        rottenScore,
                        genres,
                        imdbResponse.getActors().split(", "),
                        imdbResponse.getWriter().split(", "),
                        imdbResponse.getDirector()
                )
        );
    }

    private List<Genre> getGenres(IMDBResponse imdbResponse) {
        List<Genre> genres = new ArrayList<>();
        for (String genre : imdbResponse.getGenre().split(", ")) {
            genres.add(Genre.valueOf(genre.replaceAll("[- ]", "_")));
        }
        return genres;
    }

    private int getRottenScore(IMDBResponse imdbResponse) {
        int rottenScore = 0;
        for(Rating rating: imdbResponse.getRatings()){
            if(rating.getSource().equals("Rotten Tomatoes")){
                rottenScore = Integer.parseInt(rating.getValue().substring(0, rating.getValue().length()-1));
                break;
            }
        }
        return rottenScore;
    }

    // region Common UI
    public static Button createButton(String text, float widthScale, float heightScale) {
        Button button = new Button(text);

        button.prefWidthProperty().bind(window.widthProperty().multiply(widthScale));
        button.prefHeightProperty().bind(window.heightProperty().multiply(heightScale));

        button.getStyleClass().add("btn");

        return button;
    }
    // endregion Common UI
}
