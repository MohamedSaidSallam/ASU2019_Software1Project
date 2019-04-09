package com.company.cinema;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Movie {



    private int id;
    private int movieNum = 0; //is that the best practice ?
    private boolean available;
    private float price;
    private int[] availableSessionsIndices;

    private ViewingOption[] viewingOptions;
    private Info info;

    private VBox vb;
    private Button bt;
    private Image poster;

    //endregion Variables

    // region Constructor

    public Movie(boolean available, float price, int[] availableSessionsIndices, ViewingOption[] viewingOptions, Info info) {
        movieNum++;
        this.id = movieNum;
        this.available = available;
        this.price = price;
        this.availableSessionsIndices = availableSessionsIndices;
        this.viewingOptions = viewingOptions;
        this.info = info;

        vb = new VBox();
        vb.setPadding(new Insets(10, 50, 50, 50));
        vb.setSpacing(10);

        poster = new Image(String.format("file:src/com/company/media/images/%d.jpg", id));
        ImageView imageView = new ImageView(poster);
        imageView.setFitHeight(455); //magicNumber
        imageView.setFitWidth(300);  //magicNumber

        Label lb = new Label(info.getName());
        lb.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        lb.setTextFill(Color.web("#ff9933"));
        bt = new Button("Buy ticket");
        bt.getStyleClass().add("my-butt");
        bt.setPrefWidth(imageView.getFitWidth());

        vb.getChildren().add(lb);
        vb.getChildren().add(imageView);
        vb.getChildren().add(bt);
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

    public float getPrice() {
        return price;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public void setViewingOptions(ViewingOption[] viewingOptions) {
        this.viewingOptions = viewingOptions;
    }

    public void setAvailableSessionsIndices(int[] availableSessionsIndices) {
        this.availableSessionsIndices = availableSessionsIndices;
    }
    //endregion mutators
    //region Variables

}
