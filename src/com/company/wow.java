package com.company;

import com.company.payment.Cash;
import com.company.payment.Payment;
import com.company.payment.PaymentMethod;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Vector;

public class wow extends Application {
 public void start(Stage primaryStage) {
  VBox vbx_main = new VBox();

  Scene scene = new Scene(vbx_main);
  scene.getStylesheets().add("file:src/com/company/media/styles.css");

  HBox hBox = new HBox();
  ImageView imageView = new ImageView();
  Label label = new Label();
  JFXSpinner jFXSpinner = new JFXSpinner();
  HBox hBox0 = new HBox();
  SplitPane splitPane = new SplitPane();
  AnchorPane anchorPane = new AnchorPane();
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
  AnchorPane anchorPane0 = new AnchorPane();
  Label label16 = new Label();
  Label label17 = new Label();

  JFXComboBox<PaymentMethod> jFXComboBox = new JFXComboBox<PaymentMethod>();
  JFXButton jFXButton = new JFXButton();


  vbx_main.setPrefHeight(818.0);
  vbx_main.setPrefWidth(1090.0);

  hBox.setPrefHeight(296.0);
  hBox.setPrefWidth(1056.0);

  imageView.setFitHeight(304.0);
  imageView.setFitWidth(302.0);
  imageView.setPickOnBounds(true);
  imageView.setPreserveRatio(true);

  label.setPrefHeight(307.0);
  label.setPrefWidth(550.0);
  label.setText("      Payment  ");
  label.setFont(new Font("Century Gothic", 64.0));

  hBox0.setPrefHeight(574.0);
  hBox0.setPrefWidth(1090.0);

  splitPane.setDividerPositions(0.5);
  splitPane.setPrefHeight(514.0);
  splitPane.setPrefWidth(1134.0);

  anchorPane.setMinHeight(0.0);
  anchorPane.setMinWidth(0.0);
  anchorPane.setPrefHeight(512.0);
  anchorPane.setPrefWidth(422.0);

  label0.setLayoutX(14.0);
  label0.setLayoutY(103.0);
  label0.setPrefHeight(21.0);
  label0.setPrefWidth(210.0);
  label0.setText("Movie Name                   :");
  label0.setFont(new Font(18.0));

  label1.setLayoutX(224.0);
  label1.setLayoutY(106.0);
  label1.setPrefHeight(21.0);
  label1.setPrefWidth(210.0);

  label2.setLayoutX(14.0);
  label2.setLayoutY(146.0);
  label2.setPrefHeight(21.0);
  label2.setPrefWidth(210.0);
  label2.setText("Number of tickets           :");
  label2.setFont(new Font(18.0));

  label3.setLayoutX(13.0);
  label3.setLayoutY(187.0);
  label3.setPrefHeight(21.0);
  label3.setPrefWidth(210.0);
  label3.setText("Viewing Option               :");
  label3.setFont(new Font(18.0));

  label4.setLayoutX(234.0);
  label4.setLayoutY(149.0);
  label4.setPrefHeight(21.0);
  label4.setPrefWidth(210.0);

  label5.setLayoutX(234.0);
  label5.setLayoutY(190.0);
  label5.setPrefHeight(21.0);
  label5.setPrefWidth(210.0);

  label6.setLayoutX(13.0);
  label6.setLayoutY(229.0);
  label6.setPrefHeight(21.0);
  label6.setPrefWidth(210.0);
  label6.setText("Ticket Price                      :");
  label6.setFont(new Font(18.0));

  label7.setLayoutX(224.0);
  label7.setLayoutY(232.0);
  label7.setPrefHeight(21.0);
  label7.setPrefWidth(154.0);

  label8.setLayoutX(396.0);
  label8.setLayoutY(232.0);
  label8.setPrefHeight(21.0);
  label8.setPrefWidth(116.0);
  label8.setText("L.E");

  label9.setLayoutX(13.0);
  label9.setLayoutY(269.0);
  label9.setPrefHeight(21.0);
  label9.setPrefWidth(210.0);
  label9.setText("Hall                                  :");
  label9.setFont(new Font(18.0));

  label10.setLayoutX(234.0);
  label10.setLayoutY(272.0);
  label10.setPrefHeight(21.0);
  label10.setPrefWidth(154.0);

  label11.setLayoutX(3.0);
  label11.setLayoutY(316.0);
  label11.setPrefHeight(21.0);
  label11.setPrefWidth(524.0);
  label11.setText("--------------------------------------------------------------------------------------");

  label12.setLayoutX(13.0);
  label12.setLayoutY(380.0);
  label12.setPrefHeight(63.0);
  label12.setPrefWidth(210.0);
  label12.setText("Total Price             :");
  label12.setFont(new Font(24.0));

  label13.setLayoutX(234.0);
  label13.setLayoutY(401.0);
  label13.setPrefHeight(35.0);
  label13.setPrefWidth(131.0);

  label14.setLayoutX(396.0);
  label14.setLayoutY(394.0);
  label14.setPrefHeight(21.0);
  label14.setPrefWidth(131.0);
  label14.setText("L E");
  label14.setFont(new Font(24.0));

  label15.setLayoutX(129.0);
  label15.setLayoutY(34.0);
  label15.setPrefHeight(51.0);
  label15.setPrefWidth(271.0);
  label15.setText("       Receipt");
  label15.setFont(new Font(37.0));

  anchorPane0.setPrefHeight(200.0);
  anchorPane0.setPrefWidth(200.0);

  label16.setLayoutX(35.0);
  label16.setLayoutY(360.0);
  label16.setPrefHeight(123.0);
  label16.setPrefWidth(416.0);

  label17.setLayoutX(35.0);
  label17.setLayoutY(158.0);
  label17.setPrefHeight(27.0);
  label17.setPrefWidth(168.0);
  label17.setText("Payment Method   :");
  label17.setFont(new Font(18.0));

  jFXComboBox.setLayoutX(223.0);
  jFXComboBox.setLayoutY(154.0);
 jFXComboBox.getItems().setAll(PaymentMethod.values());
  jFXButton.setLayoutX(385.0);
  jFXButton.setLayoutY(265.0);
  jFXButton.setFont(new Font(18.0));
  jFXButton.setText("Confirm");

  hBox.getChildren().add(imageView);
  hBox.getChildren().add(label);
  hBox.getChildren().add(jFXSpinner);
  vbx_main.getChildren().add(hBox);
  anchorPane.getChildren().add(label0);
  anchorPane.getChildren().add(label1);
  anchorPane.getChildren().add(label2);
  anchorPane.getChildren().add(label3);
  anchorPane.getChildren().add(label4);
  anchorPane.getChildren().add(label5);
  anchorPane.getChildren().add(label6);
  anchorPane.getChildren().add(label7);
  anchorPane.getChildren().add(label8);
  anchorPane.getChildren().add(label9);
  anchorPane.getChildren().add(label10);
  anchorPane.getChildren().add(label11);
  anchorPane.getChildren().add(label12);
  anchorPane.getChildren().add(label13);
  anchorPane.getChildren().add(label14);
  anchorPane.getChildren().add(label15);
  splitPane.getItems().add(anchorPane);
  anchorPane0.getChildren().add(label16);
  anchorPane0.getChildren().add(label17);
  anchorPane0.getChildren().add(jFXComboBox);
  anchorPane0.getChildren().add(jFXButton);
  splitPane.getItems().add(anchorPane0);
  hBox0.getChildren().add(splitPane);
  vbx_main.getChildren().add(hBox0);
  primaryStage.setFullScreen(true);
  primaryStage.setTitle("Cinema Booking Robot");
  primaryStage.setScene(scene);
  primaryStage.show();
 }

 public static void main(String[] args) {
  launch(args);
 }
}