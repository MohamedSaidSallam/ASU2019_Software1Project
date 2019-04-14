package com.company.ui;


import com.company.payment.CardType;
import com.company.payment.Cash;

import com.company.payment.Payment;

import com.company.payment.PaymentMethod;

import com.jfoenix.controls.JFXComboBox;

import com.sun.rowset.internal.Row;

import javafx.application.Application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.shape.Line;

import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;


import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXSpinner;

import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;

import javafx.scene.text.Font;

import java.awt.event.ActionEvent;


public class PaymentScene extends Application {

    public void start(Stage primaryStage) {

        VBox vbx_main = new VBox();

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
        ImageView img_logo = new ImageView(new Image("file:src/com/company/media/images/placeholder/logo.png"));
        img_logo.setFitHeight(75); //todo magicNumber
        img_logo.setFitWidth(75);  //todo magicNumber
        hbx_top.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        hbx_top.setSpacing(10);//todo magic numbers
        hbx_top.setAlignment(Pos.CENTER);

        hbx_top.getChildren().addAll(img_logo, lbl_title, region, btn_temp1, btn_temp2);

        Scene scene = new Scene(vbx_main);

        scene.getStylesheets().add("file:src/com/company/media/styles.css");

        HBox hBox = new HBox();


        Label label = new Label();


        Line line = new Line();

        HBox hBox0 = new HBox();

        GridPane gridPane = new GridPane();

        ColumnConstraints columnConstraints = new ColumnConstraints();

        ColumnConstraints columnConstraints0 = new ColumnConstraints();

        ColumnConstraints columnConstraints1 = new ColumnConstraints();

        RowConstraints rowConstraints = new RowConstraints();

        RowConstraints rowConstraints0 = new RowConstraints();

        RowConstraints rowConstraints1 = new RowConstraints();

        RowConstraints rowConstraints2 = new RowConstraints();

        RowConstraints rowConstraints3 = new RowConstraints();

        RowConstraints rowConstraints4 = new RowConstraints();

        RowConstraints rowConstraints5 = new RowConstraints();

        RowConstraints rowConstraints6 = new RowConstraints();

        Label label0 = new Label();

        Label label1 = new Label();

        Label label2 = new Label();

        Label label3 = new Label();

        Label label4 = new Label();

        Label label5 = new Label();

        Label label6 = new Label();

        Label label7 = new Label();

        Label label8 = new Label();

        Label label9 = new Label();

        Label label10 = new Label();

        Label label11 = new Label();

        Label label12 = new Label();

        Label label13 = new Label();

        Label label14 = new Label();

        Label label15 = new Label();

        Label label16 = new Label();

        Label label17 = new Label();

        Line line0 = new Line();

        VBox vBox = new VBox();

        VBox vBox1 = new VBox();

        GridPane gridPane7=new GridPane();

        GridPane gridPane0 = new GridPane();

        ColumnConstraints columnConstraints2 = new ColumnConstraints();

        ColumnConstraints columnConstraints3 = new ColumnConstraints();

        ColumnConstraints columnConstraints4 = new ColumnConstraints();

        RowConstraints rowConstraints7 = new RowConstraints();

        RowConstraints rowConstraints8 = new RowConstraints();

        RowConstraints rowConstraints9 = new RowConstraints();


        Label label18 = new Label();

        JFXComboBox jFXComboBox = new JFXComboBox();

        JFXComboBox jFXComboBox2 = new JFXComboBox();

        JFXButton jFXButton = new JFXButton("Confirm");

        Label label19 = new Label();


        vbx_main.setMaxHeight(1000);

        vbx_main.setMaxWidth(1000);

        vbx_main.setMinHeight(500);

        vbx_main.setMinWidth(500);

        vbx_main.setPrefHeight(1000);

        vbx_main.setPrefWidth(1000);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        hBox.setPrefHeight(300);

        hBox.setPrefWidth(1000);


        label.setPrefHeight(300);

        label.setPrefWidth(1200);

        label.setText("                                              Payment  ");

        label.setFont(new Font("Century Gothic", 64.0));


/*
        line.setEndX(0);

        line.setEndY(0);

        line.setStartX(0);

        line.setStartY(0);*/
        line.setEndX(primaryScreenBounds.getWidth());
        line.setStartX(primaryScreenBounds.getMinX());
        line.setEndY(300);
        line.setStartY(300);


        hBox0.setPrefHeight(primaryScreenBounds.getHeight() - 300);

        hBox0.setPrefWidth(primaryScreenBounds.getWidth());


        gridPane.setPrefHeight(primaryScreenBounds.getHeight() - 450);

        gridPane.setPrefWidth(primaryScreenBounds.getWidth() / 2);

        GridPane gridPane1 = new GridPane();

        gridPane1.setPrefHeight(primaryScreenBounds.getHeight() - 850);

        gridPane1.setPrefWidth(primaryScreenBounds.getWidth() / 2);

        gridPane0.setPrefHeight(primaryScreenBounds.getHeight() / 2);

        gridPane0.setPrefWidth(primaryScreenBounds.getHeight() / 2);


        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints.setMaxWidth(422.0);

        columnConstraints.setMinWidth(10.0);

        columnConstraints.setPrefWidth(210.0);


        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints0.setMaxWidth(298.0);

        columnConstraints0.setMinWidth(10.0);

        columnConstraints0.setPrefWidth(283.0);


        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints1.setMaxWidth(291.0);

        columnConstraints1.setMinWidth(10.0);

        columnConstraints1.setPrefWidth(76.0);


        rowConstraints.setMaxHeight(166.0);

        rowConstraints.setMinHeight(0.0);

        rowConstraints.setPrefHeight(108.0);

        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints0.setMaxHeight(343.0);

        rowConstraints0.setMinHeight(9.0);

        rowConstraints0.setPrefHeight(51.0);

        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints1.setMaxHeight(377.0);

        rowConstraints1.setMinHeight(0.0);

        rowConstraints1.setPrefHeight(50.0);

        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints2.setMaxHeight(407.0);

        rowConstraints2.setMinHeight(10.0);

        rowConstraints2.setPrefHeight(44.0);

        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints3.setMaxHeight(407.0);

        rowConstraints3.setMinHeight(10.0);

        rowConstraints3.setPrefHeight(37.0);

        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints4.setMaxHeight(407.0);

        rowConstraints4.setMinHeight(10.0);

        rowConstraints4.setPrefHeight(42.0);

        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints5.setMaxHeight(407.0);

        rowConstraints5.setMinHeight(10.0);

        rowConstraints5.setPrefHeight(41.0);

        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints6.setMaxHeight(407.0);

        rowConstraints6.setMinHeight(10.0);

        rowConstraints6.setPrefHeight(153.0);

        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        GridPane.setRowIndex(label0, 1);

        label0.setPrefHeight(21.0);

        label0.setPrefWidth(300);

        label0.setText("  Movie Name                 :");

        label0.setFont(new Font(25));


        GridPane.setRowIndex(label1, 2);

        label1.setPrefHeight(21.0);

        label1.setPrefWidth(300);

        label1.setText("  Number of tickets         :");

        label1.setFont(new Font(25));


        GridPane.setRowIndex(label2, 3);

        label2.setPrefHeight(21.0);

        label2.setPrefWidth(300);

        label2.setText("  Viewing Option             :");

        label2.setFont(new Font(25));


        GridPane.setRowIndex(label3, 4);

        label3.setPrefHeight(21.0);

        label3.setPrefWidth(300);

        label3.setText("  Ticket Price                    :");

        label3.setFont(new Font(25));


        GridPane.setRowIndex(label4, 5);

        label4.setPrefHeight(21.0);

        label4.setPrefWidth(300);

        label4.setText("  Hall                                :");

        label4.setFont(new Font(25));


        label7.setPrefHeight(63.0);

        label7.setPrefWidth(300);

        label7.setText("  Total Price           :");

        label7.setFont(new Font(34));


        GridPane.setColumnIndex(label8, 1);

        label8.setPrefHeight(35.0);

        label8.setPrefWidth(131.0);

        label8.setText("150");
        label8.setFont(new Font(34));


        GridPane.setColumnIndex(label10, 1);

        label10.setPrefHeight(35.0);

        label10.setPrefWidth(157.0);

        label10.setText("Receipt");

        label10.setFont(new Font(36.0));


        GridPane.setColumnIndex(label11, 2);

        label11.setPrefHeight(21.0);

        label11.setPrefWidth(131.0);

        label11.setText("L E");

        label11.setFont(new Font(24.0));


        GridPane.setColumnIndex(label12, 2);

        GridPane.setRowIndex(label12, 4);

        label12.setPrefHeight(21.0);

        label12.setPrefWidth(116.0);

        label12.setText("L.E");
        label12.setFont(new Font(25));


        GridPane.setColumnIndex(label13, 1);

        GridPane.setRowIndex(label13, 1);

        label13.setPrefHeight(21.0);

        label13.setPrefWidth(235.0);

        label13.setText("Avengers End game");


        label13.setFont(new Font(25));


        GridPane.setColumnIndex(label14, 1);

        GridPane.setRowIndex(label14, 2);

        label14.setLayoutX(217.0);

        label14.setLayoutY(130.0);

        label14.setPrefHeight(21.0);

        label14.setPrefWidth(235.0);

        label14.setText("5");
        label14.setFont(new Font(25));


        GridPane.setColumnIndex(label15, 1);

        GridPane.setRowIndex(label15, 3);

        label15.setLayoutX(217.0);

        label15.setLayoutY(179.0);

        label15.setPrefHeight(21.0);

        label15.setPrefWidth(235.0);

        label15.setText("IMAX");
        label15.setFont(new Font(25));


        GridPane.setColumnIndex(label16, 1);

        GridPane.setRowIndex(label16, 4);

        label16.setLayoutX(217.0);

        label16.setLayoutY(224.0);

        label16.setPrefHeight(21.0);

        label16.setPrefWidth(235.0);

        label16.setText("30");
        label16.setFont(new Font(25));


        Line line2 = new Line();

        line2.setStartX(primaryScreenBounds.getMinX());


        line2.setEndX(primaryScreenBounds.getWidth() / 2);


        GridPane.setColumnIndex(label17, 1);

        GridPane.setRowIndex(label17, 5);

        label17.setLayoutX(217.0);

        label17.setLayoutY(263.0);

        label17.setPrefHeight(21.0);

        label17.setPrefWidth(235.0);

        label17.setText("1");
        label17.setFont(new Font(25));


        line0.setEndY(primaryScreenBounds.getHeight());


        line0.setStartY(primaryScreenBounds.getMinY());


        vBox.setPrefHeight(700);

        vBox.setPrefWidth(1000);


        vBox1.setPrefHeight(700);

        vBox1.setPrefWidth(1000);


        gridPane0.setPrefHeight(primaryScreenBounds.getHeight()*0.25);
        gridPane0.setPadding(new Insets(50,0,0,0));


        gridPane0.setPrefWidth(1000);


        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints2.setMaxWidth(600);

        columnConstraints2.setMinWidth(10.0);

        columnConstraints2.setPrefWidth(600);


        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints3.setMaxWidth(700);

        columnConstraints3.setMinWidth(10.0);

        columnConstraints3.setPrefWidth(700);


        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints4.setMaxWidth(500);

        columnConstraints4.setMinWidth(10.0);

        columnConstraints4.setPrefWidth(500);


        rowConstraints7.setMinHeight(10.0);

        rowConstraints7.setPrefHeight(30.0);

        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints8.setMaxHeight(101.0);

        rowConstraints8.setMinHeight(10.0);

        rowConstraints8.setPrefHeight(90.0);

        rowConstraints8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        rowConstraints9.setMaxHeight(300);

        rowConstraints9.setMinHeight(10.0);

        rowConstraints9.setPrefHeight(300);

        rowConstraints9.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        GridPane.setRowIndex(label18, 1);

        label18.setPrefHeight(27.0);

        label18.setPrefWidth(500);

        label18.setText("        Payment Method :");

        label18.setFont(new Font(23));

Label label20=new Label();
        GridPane.setRowIndex(label20, 1);

        label20.setPrefHeight(27.0);

        label20.setPrefWidth(500);

        label20.setText("        Card Type :");

        label20.setFont(new Font(23));

        GridPane.setColumnIndex(jFXComboBox, 1);

        GridPane.setRowIndex(jFXComboBox, 1);

        jFXComboBox.getItems().setAll(PaymentMethod.values());

        GridPane.setColumnIndex(jFXComboBox2, 1);

        GridPane.setRowIndex(jFXComboBox2, 1);


        jFXComboBox2.getItems().setAll(CardType.values());

        GridPane.setColumnIndex(jFXButton, 2);

        GridPane.setRowIndex(jFXButton, 2);

        jFXButton.setFont(new Font(25));

        jFXButton.getStyleClass().add("btn");


        gridPane7.setPrefHeight(primaryScreenBounds.getHeight()*0.25);

        gridPane7.setPrefWidth(1000);

        label19.setPrefHeight(primaryScreenBounds.getHeight()*0.1);

        label19.setPrefWidth(1200);

        label19.setText("");
        label19.setFont(new Font(34));
        //label19.setPadding(new Insets(0,0,0,30));
        label19.setAlignment(Pos.CENTER);


        hBox.getChildren().add(label);
        vbx_main.getChildren().add(hbx_top);


        vbx_main.getChildren().add(hBox);

        vbx_main.getChildren().add(line);

        gridPane.getColumnConstraints().add(columnConstraints);

        gridPane.getColumnConstraints().add(columnConstraints0);

        gridPane.getColumnConstraints().add(columnConstraints1);

        gridPane1.getColumnConstraints().add(columnConstraints);

        gridPane1.getColumnConstraints().add(columnConstraints0);

        gridPane1.getColumnConstraints().add(columnConstraints1);

        gridPane.getRowConstraints().add(rowConstraints);

        gridPane.getRowConstraints().add(rowConstraints0);

        gridPane.getRowConstraints().add(rowConstraints1);

        gridPane.getRowConstraints().add(rowConstraints2);

        gridPane.getRowConstraints().add(rowConstraints3);

        gridPane.getRowConstraints().add(rowConstraints4);

        gridPane.getRowConstraints().add(rowConstraints5);

        gridPane1.getRowConstraints().add(rowConstraints6);

        gridPane.getChildren().add(label0);

        gridPane.getChildren().add(label1);

        gridPane.getChildren().add(label2);

        gridPane.getChildren().add(label3);

        gridPane.getChildren().add(label4);

        gridPane.getChildren().add(label5);

        gridPane.getChildren().add(label6);

        gridPane1.getChildren().add(label7);

        gridPane1.getChildren().add(label8);

        gridPane.getChildren().add(label9);

        gridPane.getChildren().add(label10);

        gridPane1.getChildren().add(label11);

        gridPane.getChildren().add(label12);

        gridPane.getChildren().add(label13);

        gridPane.getChildren().add(label14);

        gridPane.getChildren().add(label15);

        gridPane.getChildren().add(label16);

        gridPane.getChildren().add(label17);

        vBox1.getChildren().add(gridPane);

        vBox1.getChildren().add(line2);

        vBox1.getChildren().add(gridPane1);

          gridPane7.setVisible(false);
        hBox0.getChildren().add(vBox1);

        hBox0.getChildren().add(line0);

        gridPane0.getColumnConstraints().add(columnConstraints2);

        gridPane0.getColumnConstraints().add(columnConstraints3);

        gridPane0.getColumnConstraints().add(columnConstraints4);

        gridPane0.getRowConstraints().add(rowConstraints7);

        gridPane0.getRowConstraints().add(rowConstraints8);

        gridPane0.getRowConstraints().add(rowConstraints9);

        gridPane0.getChildren().add(label18);

        gridPane0.getChildren().add(jFXComboBox);


        vBox.getChildren().add(gridPane0);
        gridPane7.getColumnConstraints().add(columnConstraints2);

        gridPane7.getColumnConstraints().add(columnConstraints3);

        gridPane7.getColumnConstraints().add(columnConstraints4);

        gridPane7.getRowConstraints().add(rowConstraints7);

        gridPane7.getRowConstraints().add(rowConstraints8);

        gridPane7.getRowConstraints().add(rowConstraints9);

        gridPane7.getChildren().add(label20);

        gridPane7.getChildren().add(jFXComboBox2);

        gridPane7.getChildren().add(jFXButton);

        vBox.getChildren().add(gridPane7);


        vBox.getChildren().add(label19);

        hBox0.getChildren().add(vBox);

        vbx_main.getChildren().add(hBox0);


        primaryStage.setFullScreen(true);

        primaryStage.setTitle("Cinema Booking Robot");

        primaryStage.setScene(scene);

        primaryStage.show();

        jFXComboBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue==PaymentMethod.Cash) {
                gridPane7.setVisible(true);
                jFXComboBox2.setVisible(false);
                label20.setVisible(false);
            }
            else if(newValue==PaymentMethod.CreditCard)
            {
                gridPane7.setVisible(true);
                jFXComboBox2.setVisible(true);
                label20.setVisible(true);

            }

        });
        jFXButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
               String newValue = String.valueOf(jFXComboBox.getSelectionModel().selectedItemProperty().getValue());
                            if (newValue.equals("Cash")) {
                                label19.setText("Please insert your money in machine" +"\n"+
                                        "Note:Our Machine only take 10 L.E, 20 L.E, 50 L.E or 100 L.E");

                            } else
                                label19.setText("Please insert your credit card in machine");



            }
        });
    }
}