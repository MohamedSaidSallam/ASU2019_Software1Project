package com.company.ui;

import com.company.Main;
import com.company.cinema.Genre;
import com.company.cinema.MPAA;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
import com.company.ui.sections.Header;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import static com.company.cinema.Genre.Musical;
import static com.company.cinema.Genre.Thriller;
import static com.company.cinema.ViewingOption.Normal;

public class BrowseMovies extends VBox implements Updatable {

    private Stage window;

    public BrowseMovies(Stage window) {
        this.window = window;


        // region Header
        Header header = new Header(window);
        // endregion Header

        // region Movies
        // region Content
        HBox hbx_movies = new HBox();

        hbx_movies.setSpacing(10);//todo magic numbers

        Movie[] movieArr = new Movie[9];
        int test = 0;
        for (Movie movie : movieArr) {
            test++;

            movie = new Movie(test, true, new int[]{0, 1},
                    new ViewingOption[]{Normal}, String.format("Movie %d", test), MPAA.PG,
                    90, "trailer", "Tincidunt eget adipiscing cubilia vel purus potenti senectus tristique, praesent egestas torquent lectus placerat nullam curae arcu nostra, iaculis erat commodo consectetur class potenti posuere pretium pulvinar libero id curabitur class lacinia nostra luctus.",
                    9, 20, 20, new Genre[]{Musical, Thriller}, new String[]{"Actor1", "Actor2"}, new String[]{"Writer1", "Writer2"}, "Director");

            hbx_movies.getChildren().add(createMovieVBox(movie));
        }
        // endregion Content

        // region ScrollPane
        ScrollPane sp_movies = new ScrollPane();
        sp_movies.setContent(hbx_movies);

        sp_movies.setPadding(new Insets(10, 0, 10, 0)); //todo magic numbers

        sp_movies.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp_movies.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp_movies.setPannable(true);

        sp_movies.prefWidthProperty().bind(window.widthProperty());
        sp_movies.maxHeightProperty().bind(window.heightProperty());

        sp_movies.getStyleClass().addAll("NoFocus", "scroll");
        // endregion ScrollPane
        // endregion Movies

        VBox vbx_main = new VBox();

        this.getStyleClass().add("main");

        this.getChildren().addAll(header, sp_movies);
    }


    private VBox createMovieVBox(Movie movie) {
        Label lbl_movieTitle = new Label(movie.getInfo().getName());
        lbl_movieTitle.getStyleClass().add("MovieTitle");

        Image image = new Image(String.format("file:" + Main.PATH_RESOURCES_IMG_POSTER + "/%d.jpg", movie.getId()));
        ImageView imageView = new ImageView(image);
        imageView.fitHeightProperty().bind(window.heightProperty().multiply(0.62));
        imageView.fitWidthProperty().bind(imageView.fitHeightProperty().multiply(image.getWidth() / image.getHeight()));

        Label lbl_caption = new Label(movie.getGenresString());
        lbl_caption.getStyleClass().add("MovieCaption");

        HBox hbx_caption = new HBox();
        hbx_caption.setAlignment(Pos.CENTER);
        hbx_caption.getChildren().add(lbl_caption);

        Button btn_buy = new Button("Buy ticket");
        btn_buy.setOnAction(e -> {
            Main.setCurrentMovie(movie);
            Main.switchScene(1);
        });
        btn_buy.getStyleClass().add("btn");
        btn_buy.prefWidthProperty().bind(imageView.fitWidthProperty());
        btn_buy.prefHeightProperty().bind(window.heightProperty().multiply(0.05));

        VBox vbx = new VBox();
        vbx.setPadding(new Insets(10, 50, 50, 50));//todo magic numbers
        vbx.setSpacing(10);//todo magic numbers
        vbx.getStyleClass().add("MovieCard");

        vbx.prefHeightProperty().unbind();

        vbx.getChildren().addAll(lbl_movieTitle, imageView, hbx_caption, btn_buy);

        return vbx;
    }

    public void updateScene() {
        //todo implement
        throw new UnsupportedOperationException();
    }
}
