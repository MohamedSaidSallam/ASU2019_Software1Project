package com.company.ui.sections;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Header extends HBox {

    public Header()
    {
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

        this.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        this.setSpacing(10);//todo magic numbers
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(img_logo, lbl_title, region, btn_temp1, btn_temp2);
        // endregion HBox
        // endregion Header
    }
}
