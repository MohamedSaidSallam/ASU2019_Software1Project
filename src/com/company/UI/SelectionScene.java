package com.company.UI;

import com.company.cinema.Hall;
import com.company.cinema.Seat;
import com.company.cinema.ViewingOption;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SelectionScene extends Application {

    // region Constants
    private static final Color SEAT_UNAVAILABLE_COLOR = Color.LIGHTCORAL;
    private static final Color SEAT_SELECTED_COLOR = Color.LIGHTSTEELBLUE;
    private static final Color SEAT_NOT_SELECTED_COLOR = Color.WHITE;
    private static final Color SEAT_STROKE_COLOR = Color.BLACK;
    // endregion Constants

    // region Variables
    private Stage window;
    private int numberS = 0;
    // endregion Variables

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Label lbl_noSeat = createOptionLabel("0");//todo change this line's location

        // region TESTING
        Seat seats[] = new Seat[100];

        int c = 1;
        char r = 'A';
        for (int s = 0; s < 100; s++) {
            seats[s] = new Seat(String.valueOf(c), String.valueOf(r));
            c++;
            if ((s + 1) % 10 == 0) {
                c = 1;
                r++;
            }
        }
        Hall hall = new Hall(1, "Hall A", 100, seats);

        //random seats
        seats[5].setAvailable(false);
        seats[7].setAvailable(false);
        seats[10].setAvailable(false);
        seats[77].setAvailable(false);
        seats[78].setAvailable(false);
        seats[80].setAvailable(false);
        seats[90].setAvailable(false);

        Seat[] choice;
        choice = seats.clone();
        // endregion TESTING

        BorderPane brd_main = new BorderPane();

        Scene scene = new Scene(brd_main);
        scene.getStylesheets().add("file:src/resources/style.css");

        brd_main.getStyleClass().add("main");

        // region Header
        // region Content
        ImageView img_logo = new ImageView(new Image("file:src/resources/img/placeholder/logo.png"));
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
        // endregion Header

        // region MoviePanel
        Image img_moviePoster = new Image("file:src/resources/Interstellar_film_poster.jpg");
        ImageView imgV_moviePoster = new ImageView(img_moviePoster);
        imgV_moviePoster.fitHeightProperty().bind(window.heightProperty().multiply(0.63));
        imgV_moviePoster.fitWidthProperty().bind(imgV_moviePoster.fitHeightProperty().multiply(img_moviePoster.getWidth() / img_moviePoster.getHeight()));

        Label lbl_movieTitle = new Label("Interstellar this is a very long title made for just testing purposes nothing else");
        lbl_movieTitle.getStyleClass().add("MovieTitleBig");

        lbl_movieTitle.prefWidthProperty().bind(imgV_moviePoster.fitWidthProperty());
        lbl_movieTitle.setWrapText(true);

        VBox vbx_left = new VBox();
        vbx_left.getStyleClass().add("temp1");

        vbx_left.setPadding(new Insets(20, 20, 20, 20));//todo Magic Numbers

        vbx_left.getChildren().addAll(imgV_moviePoster, lbl_movieTitle);
        // endregion MoviePanel

        // region SeatSelection

        GridPane grd_seats = new GridPane();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                int counter = 10 * j + i;
                Rectangle rectangle = new Rectangle();

                rectangle.widthProperty().bind(window.widthProperty().multiply(0.035));
                rectangle.heightProperty().bind(window.heightProperty().multiply(0.035));

                rectangle.setStroke(SEAT_STROKE_COLOR);
                rectangle.setStrokeWidth(3.0);

                if (!seats[counter].isAvailable()) {
                    rectangle.setFill(SEAT_UNAVAILABLE_COLOR);
                } else {
                    rectangle.setFill(SEAT_NOT_SELECTED_COLOR);

                    rectangle.setOnMouseClicked(e -> {
                        if (rectangle.getFill() == SEAT_SELECTED_COLOR) {
                            rectangle.setFill(SEAT_NOT_SELECTED_COLOR);
                            numberS--;
                        } else {
                            rectangle.setFill(SEAT_SELECTED_COLOR);
                            choice[counter].setAvailable(false);
                            numberS++;
                        }
                        lbl_noSeat.setText(String.valueOf(numberS));
                    });
                }

                GridPane.setConstraints(rectangle, i, j);

                Label lbl_seatPos = new Label(seats[counter].getRow() + seats[counter].getColumn());
                GridPane.setConstraints(lbl_seatPos, i, j);
                GridPane.setHalignment(lbl_seatPos, HPos.CENTER);

                grd_seats.getChildren().addAll(rectangle, lbl_seatPos);
            }
        }

        grd_seats.setPadding(new Insets(20, 20, 20, 20)); //todo Magic Numbers
        grd_seats.hgapProperty().bind(window.widthProperty().multiply(0.01));
        grd_seats.vgapProperty().bind(window.heightProperty().multiply(0.01));
        grd_seats.setAlignment(Pos.BOTTOM_CENTER);

        grd_seats.getStyleClass().add("temp4");
        // endregion SeatSelection

        // region Options

        // region noSeats
        Label lbl_stringSeats = createOptionLabel("Number of seats: ");
        // endregion noSeats

        // region viewingOptions
        Label lbl_viewingOptions = createOptionLabel("Movie type:");

        ComboBox<ViewingOption> cbo_viewingOptions = new ComboBox<>();

        cbo_viewingOptions.getItems().addAll(ViewingOption.values());
        cbo_viewingOptions.getSelectionModel().selectFirst();

        cbo_viewingOptions.prefWidthProperty().bind(window.widthProperty().multiply(0.13));
        cbo_viewingOptions.prefHeightProperty().bind(window.heightProperty().multiply(0.04));

        cbo_viewingOptions.getStyleClass().add("NoFocus");
        // endregion viewingOptions

        // region noGlasses
        Label lbl_noGlasses = createOptionLabel("Number of glasses:");
        lbl_noGlasses.setVisible(false);

        HBox hbx_noGlasses = new HBox();

        Label lbl_noGlassesValue = createOptionLabel("0");

        Button btn_addGlasses = createButton("+",  0.01f, 0.05f);
        btn_addGlasses.setOnAction(e -> lbl_noGlassesValue.setText(String.valueOf(Math.min(Integer.parseInt(lbl_noGlassesValue.getText()) + 1, numberS))));
        btn_addGlasses.getStyleClass().add("NoFocus");

        Button btn_removeGlasses = createButton("-", 0.01f, 0.05f);
        btn_removeGlasses.setOnAction(e -> lbl_noGlassesValue.setText(String.valueOf(Math.max(Integer.parseInt(lbl_noGlassesValue.getText()) - 1, 0))));
        btn_removeGlasses.getStyleClass().add( "NoFocus");

        hbx_noGlasses.setAlignment(Pos.TOP_CENTER);
        hbx_noGlasses.setSpacing(10);

        hbx_noGlasses.getChildren().addAll(btn_addGlasses, btn_removeGlasses, lbl_noGlassesValue);
        hbx_noGlasses.setVisible(false);

        cbo_viewingOptions.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == ViewingOption.IMAX) {
                lbl_noGlasses.setVisible(true);
                hbx_noGlasses.setVisible(true);
            }else{
                lbl_noGlasses.setVisible(false);
                hbx_noGlasses.setVisible(false);
            }
        });
        // endregion noGlasses

        VBox vbx_right = new VBox();

        vbx_right.setAlignment(Pos.TOP_CENTER);
        vbx_right.getStyleClass().add("temp3");

        vbx_right.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        vbx_right.spacingProperty().bind(window.heightProperty().multiply(0.01));

        vbx_right.getChildren().addAll(lbl_stringSeats, lbl_noSeat, lbl_viewingOptions, cbo_viewingOptions, lbl_noGlasses, hbx_noGlasses);
        // endregion Options

        // region Footer
        Button btn_btm = createButton("Next",  0.1f, 0.05f);

        HBox hbx_btm = new HBox();

        hbx_btm.setAlignment(Pos.CENTER_RIGHT);
        hbx_btm.getChildren().add(btn_btm);

        hbx_btm.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        hbx_btm.setSpacing(10);//todo magic numbers

        hbx_btm.getStyleClass().add("temp2");

        btn_btm.setOnAction(e -> {

            System.out.println("**********");
        });//todo remove this later
        // endregion Footer

        brd_main.setTop(hbx_top);
        brd_main.setLeft(vbx_left);
        brd_main.setCenter(grd_seats);
        brd_main.setRight(vbx_right);
        brd_main.setBottom(hbx_btm);

        window.setFullScreen(true);
        window.setTitle("CTD");
        window.setScene(scene);
        window.show();
    }

    private Label createOptionLabel(String text){
        Label label = new Label(text);

        label.getStyleClass().add("LabelOptions");

        return label;
    }

    private Button createButton(String text, float widthScale, float heightScale){
        Button button = new Button(text);

        button.getStyleClass().add("btn");

        button.prefWidthProperty().bind(window.widthProperty().multiply(widthScale));
        button.prefHeightProperty().bind(window.heightProperty().multiply(heightScale));

        return button;
    }
}
