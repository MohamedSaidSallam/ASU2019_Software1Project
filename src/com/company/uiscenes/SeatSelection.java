
package com.company.uiscenes;

import com.company.Main;
import com.company.cinema.Hall;
import com.company.cinema.Seat;
import com.company.cinema.ViewingOption;
import com.company.cinema.ticket.Order;
import com.company.cinema.ticket.Ticket;
import com.company.uiscenes.sections.Header;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.company.Main.PATH_RESOURCES_IMG_POSTER;


public class SeatSelection extends BorderPane implements Updatable {


    // region Constants
    // region Colors
    private static final Color SEAT_UNAVAILABLE_COLOR = Color.LIGHTCORAL;
    private static final Color SEAT_SELECTED_COLOR = Color.LIGHTSTEELBLUE;
    private static final Color SEAT_NOT_SELECTED_COLOR = Color.WHITE;
    private static final Color SEAT_STROKE_COLOR = Color.BLACK;
    // endregion Colors
    // endregion Constants

    // region Variables
    private Stage window;
    private int numSeatsSelected = 0;
    private Label lbl_noGlassesValue;

    private HBox hbx_top;
    private Image img_moviePoster;
    private ImageView imgV_moviePoster;
    private Label lbl_movieTitle;
    ComboBox<ViewingOption> cbo_viewingOptions;


    public SeatSelection(Stage primaryStage) {
        window = primaryStage;

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

        this.getStyleClass().add("main");

        // region Header
        Header header = new Header(window);
        // endregion Header

        // region MoviePanel

        img_moviePoster = new Image("file:" + Main.PATH_RESOURCES_IMG_POSTER + "1.jpg");
        imgV_moviePoster = new ImageView(img_moviePoster);


        imgV_moviePoster.fitHeightProperty().bind(window.heightProperty().multiply(0.43));
        imgV_moviePoster.fitWidthProperty().bind(imgV_moviePoster.fitHeightProperty().multiply(img_moviePoster.getWidth() / img_moviePoster.getHeight()));

        lbl_movieTitle = new Label();
        lbl_movieTitle.getStyleClass().add("MovieTitleBig");

        lbl_movieTitle.prefWidthProperty().bind(imgV_moviePoster.fitWidthProperty());
        lbl_movieTitle.setWrapText(true);

        VBox vbx_left = new VBox();
        vbx_left.getStyleClass().add("gray");

        vbx_left.setPadding(new Insets(20, 20, 20, 20));//todo Magic Numbers

        vbx_left.getChildren().addAll(imgV_moviePoster, lbl_movieTitle);
        // endregion MoviePanel

        // region Options

        // region noSeats
        Label lbl_stringSeats = createOptionLabel("Number of seats: ");
        Label lbl_noSeat = createOptionLabel("0");
        // endregion noSeats

        // region viewingOptions
        Label lbl_viewingOptions = createOptionLabel("Movie type:");

        cbo_viewingOptions = new ComboBox<>();


        // endregion viewingOptions

        // region noGlasses
        Label lbl_noGlasses = createOptionLabel("Number of glasses:");
        lbl_noGlasses.setVisible(false);

        HBox hbx_noGlasses = new HBox();

        lbl_noGlassesValue = createOptionLabel("0");

        Button btn_addGlasses = Main.createButton("+", 0.01f, 0.05f);
        btn_addGlasses.setOnAction(e -> lbl_noGlassesValue.setText(String.valueOf(Math.min(Integer.parseInt(lbl_noGlassesValue.getText()) + 1, numSeatsSelected))));
        btn_addGlasses.getStyleClass().add("NoFocus");

        Button btn_removeGlasses = Main.createButton("-", 0.01f, 0.05f);
        btn_removeGlasses.setOnAction(e -> lbl_noGlassesValue.setText(String.valueOf(Math.max(Integer.parseInt(lbl_noGlassesValue.getText()) - 1, 0))));
        btn_removeGlasses.getStyleClass().add("NoFocus");

        hbx_noGlasses.setAlignment(Pos.TOP_CENTER);
        hbx_noGlasses.setSpacing(10);

        hbx_noGlasses.getChildren().addAll(btn_addGlasses, btn_removeGlasses, lbl_noGlassesValue);
        hbx_noGlasses.setVisible(false);

        cbo_viewingOptions.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == ViewingOption.IMAX) {
                lbl_noGlasses.setVisible(true);
                hbx_noGlasses.setVisible(true);
            } else {
                lbl_noGlasses.setVisible(false);
                hbx_noGlasses.setVisible(false);
            }
        });
        // endregion noGlasses

        VBox vbx_right = new VBox();

        vbx_right.setAlignment(Pos.TOP_CENTER);
        vbx_right.getStyleClass().add("gray");

        vbx_right.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        vbx_right.spacingProperty().bind(window.heightProperty().multiply(0.01));

        vbx_right.getChildren().addAll(lbl_stringSeats, lbl_noSeat, lbl_viewingOptions, cbo_viewingOptions, lbl_noGlasses, hbx_noGlasses);
        // endregion Options

        // region SeatSelection

        ArrayList<Seat> selectedSeats = new ArrayList<>();
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
                            numSeatsSelected--;
                        } else {
                            rectangle.setFill(SEAT_SELECTED_COLOR);

                            choice[counter].setAvailable(false);
                            selectedSeats.add(new Seat(choice[counter].getColumn(), choice[counter].getRow(), true)); //todo Check Server Availability
                            numSeatsSelected++;
                        }
                        setNumber(lbl_noSeat);
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

        grd_seats.getStyleClass().add("silver");
        // endregion SeatSelection

        // region Footer
        Button btn_btm = Main.createButton("Next", 0.1f, 0.05f);

        HBox hbx_btm = new HBox();

        hbx_btm.setAlignment(Pos.CENTER_RIGHT);
        hbx_btm.getChildren().add(btn_btm);

        hbx_btm.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        hbx_btm.setSpacing(10);//todo magic numbers

        hbx_btm.getStyleClass().add("gray");

        btn_btm.setOnAction(e -> {
            ArrayList<Ticket> tickets = new ArrayList<>();
            for (int i = 0; i < numSeatsSelected; i++) {
                tickets.add(new Ticket(i, Main.getCurrentMovie(), selectedSeats.get(i), cbo_viewingOptions.getSelectionModel().getSelectedItem(), 1, 2));
            }
            Order order = new Order(tickets);
            Main.setCurrentOrder(order);
            Main.switchScene(3);

        });//todo remove this later
        // endregion Footer

        this.setTop(header);
        this.setLeft(vbx_left);
        this.setCenter(grd_seats);
        this.setRight(vbx_right);
        this.setBottom(hbx_btm);


    }

    private void setNumber(Label lbl_noSeat) {
        String s = String.valueOf(numSeatsSelected);
        lbl_noSeat.setText(s);
        if (Integer.parseInt(lbl_noGlassesValue.getText()) > numSeatsSelected) {
            lbl_noGlassesValue.setText(s);
        }
    }

    private Label createOptionLabel(String text) {
        Label label = new Label(text);

        label.getStyleClass().add("LabelOptions");

        return label;
    }


    public void updateScene() {
        img_moviePoster = new Image("file:" + PATH_RESOURCES_IMG_POSTER + Main.getCurrentMovie().getImdbID() + ".jpg");
        imgV_moviePoster.setImage(img_moviePoster);

        lbl_movieTitle.setText(Main.getCurrentMovie().getInfo().getName());


        cbo_viewingOptions.getItems().addAll(Main.getCurrentMovie().getViewingOptions());
        cbo_viewingOptions.getSelectionModel().selectFirst();

        cbo_viewingOptions.prefWidthProperty().bind(window.widthProperty().multiply(0.13));
        cbo_viewingOptions.prefHeightProperty().bind(window.heightProperty().multiply(0.04));

        cbo_viewingOptions.getStyleClass().add("NoFocus");
    }
}


