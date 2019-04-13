package com.company.UI;

import com.company.cinema.Hall;
import com.company.cinema.Seat;
import com.company.cinema.ViewingOption;
import javafx.application.Application;
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
    private Stage window;
    private static int  numberS = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;

        Label lbl_noSeat = new Label("0");//todo change this line's location

        // region TESTING
        Seat seats[] = new Seat[100];

        int c = 1;
        char r = 'A';
        for(int s=0;s<100;s++){
          seats[s]= new Seat(String.valueOf(c),String.valueOf(r));
          c++;
          if((s+1)%10 == 0){
              c = 1;
              r++;
          }
        }
        Hall hall = new Hall(1,"Hall A",100,seats);

        //random seats
        seats[5].setAvailable(false);
        seats[7].setAvailable(false);
        seats[10].setAvailable(false);
        seats[77].setAvailable(false);
        seats[78].setAvailable(false);
        seats[80].setAvailable(false);
        seats[90].setAvailable(false);

        Seat choice[];
        choice = seats.clone();
        // endregion TESTING

        BorderPane brd_main = new BorderPane();

        Scene scene = new Scene(brd_main); //todo set another layout to scene
        scene.getStylesheets().add("file:src/resources/style.css");

        brd_main.getStyleClass().add("main");

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

        // region left
        Label lbl_movieTitle = new Label("Interstellar");

        Image img_movie = new Image("file:src/resources/Interstellar_film_poster.jpg");
        ImageView imageView = new ImageView(img_movie);
        imageView.fitHeightProperty().bind(window.heightProperty().multiply(0.35));
        imageView.fitWidthProperty().bind(imageView.fitHeightProperty().multiply(img_movie.getWidth() / img_movie.getHeight()));

        VBox vbx_left = new VBox();

        vbx_left.getStyleClass().add("temp1");

        vbx_left.getChildren().addAll(lbl_movieTitle, imageView);
        // endregion left

        // region Center

        GridPane grd_seats = new GridPane();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                int counter = 10*j + i;
                Rectangle rectangle = new Rectangle(50, 50);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(3.0);
                if (!seats[(10 * j + i)].isAvailable()) {
                    rectangle.setFill(Color.RED);
                } else{
                    rectangle.setFill(Color.WHITE);
                    rectangle.setOnMouseClicked(e ->{
                        rectangle.setWidth(50);
                        rectangle.setHeight(50);
                        if(rectangle.getFill()==Color.BLACK){
                            rectangle.setFill(Color.WHITE);
                            numberS--;
                            lbl_noSeat.setText(String.valueOf(numberS));
                        }
                        else{
                            rectangle.setFill(Color.BLACK);
                            choice[counter].setAvailable(false);
                            System.out.println(choice[counter].getColumn() + ' ' + choice[counter].getRow());
                            numberS++;
                            lbl_noSeat.setText(String.valueOf(numberS));

                        }
                    });
                }

                GridPane.setConstraints(rectangle, i, j);
//                Label lbl_seatTemp = new Label("temp");
//                GridPane.setConstraints(lbl_seatTemp, i, j);
//                grd_seats.getChildren().add(lbl_seatTemp);
                grd_seats.getChildren().add(rectangle);
            }
        }
        grd_seats.setPadding(new Insets(20, 20, 20, 20));
        grd_seats.setHgap(10);
        grd_seats.setVgap(10);
        grd_seats.setAlignment(Pos.BOTTOM_CENTER);

        grd_seats.getStyleClass().add("temp4");


        // endregion Center

        // region Right

        Label lbl_stringSeats = new Label("Number of seats: ");

        //region noSeats
        HBox hbx_noSeats = new HBox();//todo check method
        hbx_noSeats.getChildren().addAll(lbl_stringSeats, lbl_noSeat);
        hbx_noSeats.setSpacing(10);//todo magic numbers
        hbx_noSeats.setAlignment(Pos.CENTER);
        //endregion noSeats

        Label lbl_viewingOptions = new Label("Choose movie type");

        ComboBox<ViewingOption> cbo_viewingOptions = new ComboBox<>();
        cbo_viewingOptions.getItems().addAll(ViewingOption.Normal, ViewingOption.VIP, ViewingOption.IMAX, ViewingOption.Dolby);
        cbo_viewingOptions.prefWidthProperty().bind(window.widthProperty().multiply(0.1));
        cbo_viewingOptions.prefHeightProperty().bind(window.heightProperty().multiply(0.03));


        //region viewingOptions
        HBox hbx_viewingOptions = new HBox();//todo check method
        hbx_viewingOptions.getChildren().addAll(lbl_viewingOptions, cbo_viewingOptions);
        hbx_viewingOptions.setSpacing(10);//todo magic numbers
        hbx_viewingOptions.setAlignment(Pos.TOP_RIGHT);
        //endregion viewingOptions

        Label lbl_noGlasses = new Label("Number of needed glasses");
        lbl_noGlasses.setVisible(false);

        ComboBox<Integer> cbo_noGlasses = new ComboBox<>();
        cbo_noGlasses.setVisible(false);

        //listener for viewing options comboBox
        cbo_viewingOptions.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) ->{
            if(oldValue == ViewingOption.IMAX) {
                lbl_noGlasses.setVisible(false);
                cbo_noGlasses.setVisible(false);
            }
            else if(newValue == ViewingOption.IMAX) {
                lbl_noGlasses.setVisible(true);
                cbo_noGlasses.setVisible(true);
            }
        } );

        cbo_noGlasses.prefWidthProperty().bind(window.widthProperty().multiply(0.1));
        cbo_noGlasses.prefHeightProperty().bind(window.heightProperty().multiply(0.03));

        //region noGlasses
        HBox hbx_noGlasses = new HBox();
        hbx_noGlasses.getChildren().addAll(lbl_noGlasses, cbo_noGlasses);
        hbx_noGlasses.setSpacing(10);//todo magic numbers
        hbx_noGlasses.setAlignment(Pos.CENTER);

        //endregion noGlasses

        VBox vbx_right = new VBox();
        vbx_right.getChildren().addAll(hbx_noSeats, hbx_viewingOptions, hbx_noGlasses);
        vbx_right.setAlignment(Pos.TOP_CENTER);
        vbx_right.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        vbx_right.setSpacing(10);//todo magic numbers

        vbx_right.getStyleClass().add("temp3");
        // endregion Right

        // region Footer
        Button btn_btm = new Button("Next");
        btn_btm.getStyleClass().add("btn");

        btn_btm.prefWidthProperty().bind(window.widthProperty().multiply(0.1));
        btn_btm.prefHeightProperty().bind(window.heightProperty().multiply(0.05));

        HBox hbx_btm = new HBox();

        hbx_btm.setAlignment(Pos.CENTER_RIGHT);
        hbx_btm.getChildren().add(btn_btm);

        hbx_btm.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        hbx_btm.setSpacing(10);//todo magic numbers

        hbx_btm.getStyleClass().add("temp2");

        btn_btm.setOnAction(e ->{

            System.out.println("**********");
        });//todo remove this later
        // endregion Footer

        brd_main.setTop(hbx_top);
        brd_main.setLeft(vbx_left);
        brd_main.setCenter(grd_seats);
        brd_main.setRight(vbx_right);
        brd_main.setBottom(hbx_btm);

        primaryStage.setFullScreen(true);
        primaryStage.setTitle("CTD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
