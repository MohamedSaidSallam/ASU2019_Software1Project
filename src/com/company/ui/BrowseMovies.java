package com.company.ui;

import com.company.Main;
import com.company.cinema.Genre;
import com.company.cinema.MPAA;
import com.company.cinema.Movie;
import com.company.cinema.ViewingOption;
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

public class BrowseMovies extends VBox {

    private Stage window;

    public BrowseMovies(Stage window) {
        this.window = window;


        // region Header
        // region Content
//        ImageView img_logo = new ImageView(new Image("file:src/resources/img/placeholder/logo.png"));
        ImageView img_logo = new ImageView(new Image("file:src/resources/img/CTD_Logo.png"));
        img_logo.fitWidthProperty().bind(window.widthProperty().multiply(0.07));
        img_logo.fitHeightProperty().bind(img_logo.fitWidthProperty());

        Label lbl_title = new Label("Cinema Ticket Dispenser");
        lbl_title.getStyleClass().add("Title");

        Button btn_temp1 = createButton("temp1", 0.1f, 0.05f);

        Button btn_temp2 = createButton("temp2", 0.1f, 0.05f);

        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        // endregion Header

        // region HBox
        HBox hbx_header = new HBox();

        hbx_header.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        hbx_header.spacingProperty().bind(window.widthProperty().multiply(0.01));
        hbx_header.setAlignment(Pos.CENTER);

        hbx_header.getChildren().addAll(img_logo, lbl_title, region, btn_temp1, btn_temp2);
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

        this.getChildren().addAll(hbx_header, sp_movies);
    }


    private VBox createMovieVBox(Movie movie) {
        Label lbl_movieTitle = new Label(movie.getInfo().getName());
        lbl_movieTitle.getStyleClass().add("MovieTitle");

        Image image = new Image(String.format("file:src/resources/img/%d.jpg", movie.getId()));
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

    private Button createButton(String text, float widthScale, float heightScale) {
        Button button = new Button(text);

        button.prefWidthProperty().bind(window.widthProperty().multiply(widthScale));
        button.prefHeightProperty().bind(window.heightProperty().multiply(heightScale));

        button.getStyleClass().add("btn");

        return button;
    }
}
