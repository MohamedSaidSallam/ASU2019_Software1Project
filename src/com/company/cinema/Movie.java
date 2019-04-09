package com.company.cinema;

import com.company.Main;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

public class Movie {



    private int id;
    private static int movieNum = 0; //is that the best practice ?
    private boolean available;
    private int[] availableSessionsIndices;

    private ViewingOption[] viewingOptions;
    private Info info;

    private VBox vb;
    private Button bt;
    private Image poster;

    //endregion Variables

    // region Constructor

    public Movie(boolean available, int[] availableSessionsIndices, ViewingOption[] viewingOptions, String name, int duration, String trailer, String plot, float score, Genre[] genres) {
        this.id = ++movieNum; //todo zabat el id!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.available = available;
        this.availableSessionsIndices = availableSessionsIndices;
        this.viewingOptions = viewingOptions;
        this.info = new Info( name,  duration,  trailer,  plot ,score,  genres);
        initVBox();
    }

    private void initVBox() {
        vb = new VBox();
        vb.setPadding(new Insets(10, 50, 50, 50));
        vb.setSpacing(10);

        poster = new Image(String.format("file:src/com/company/media/images/%d.jpg", id));
        ImageView imageView = new ImageView(poster);

        imageView.setFitHeight(445); //todo magicNumber
        imageView.setFitWidth(300);  //todo magicNumber

        Label lb = new Label(info.getName());
        lb.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        lb.setTextFill(Color.web("#ff9933"));
        bt = new Button("Buy ticket");
        bt.getStyleClass().add("my-butt");
        bt.setPrefWidth(imageView.getFitWidth());

        vb.getChildren().add(lb);
        vb.getChildren().add(imageView);
        vb.getChildren().add(bt);
        vb.getStyleClass().add("vb");
        vb.prefHeightProperty().unbind();
    }

    // endregion Constructor

    //region accessors

    public int getId() {
        return id;
    }

    public VBox getVb() {
        return vb;
    }

    public boolean isAvailable() {
        return available;
    }

    public Info getInfo() {
        return info;
    }

    public ViewingOption[] getViewingOptions() {
        return viewingOptions;
    }

    public int[] getAvailableSessionsIndices() {
        return availableSessionsIndices;
    }
    //endregion accessors

    //region mutators

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setViewingOptions(ViewingOption[] viewingOptions) {
        this.viewingOptions = viewingOptions;
    }

    public void setAvailableSessionsIndices(int[] availableSessionsIndices) {
        this.availableSessionsIndices = availableSessionsIndices;
    }

    //endregion mutators

    public class Info {
        private String name;
        private int duration;
        private String trailer; //todo should be a url or relative path to the local video file
        private String plot;
        private float score;
        private Genre[] genres;


        //But wait!! There's more

        // region Constructor

        public Info(String name, int duration, String trailer, String plot, float score, Genre[] genres) {
            this.name = name;
            this.duration = duration;
            this.trailer = trailer;
            this.plot = plot;
            this.score = score;
            this.genres = genres;

        }

        // endregion Constructor

        // region accessors

        public float getScore() {
            return score;
        }

        public int getDuration() {
            return duration;
        }

        public String getName() {
            return name;
        }

        public String getPlot() {
            return plot;
        }

        public String getTrailer() {
            return trailer;
        }

        public Genre[] getGenres() {
            return genres;
        }
        // endregion accessors

        // region mutators

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPlot(String plot) {
            this.plot = plot;
        }

        public void setScore(float score) {
            this.score = score;
        }

        public void setTrailer(String trailer) {
            this.trailer = trailer;
        }

        public void setGenres(Genre[] genres) {
            this.genres = genres;
        }
        // endregion mutators
    }
}
