package com.company.ui.sections;

import com.company.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Header extends HBox {

    // region Constants
    // region Files
    private static final String FILE_LOGO = Main.PATH_RESOURCES_IMG + "CTD_Logo.png";
    // endregion Files
    // endregion Constants

    public Header(Stage window) {
        // region Header
        ImageView img_logo = new ImageView(new Image("file:" + FILE_LOGO));
        img_logo.fitWidthProperty().bind(window.widthProperty().multiply(0.07));
        img_logo.fitHeightProperty().bind(img_logo.fitWidthProperty());

        Label lbl_title = new Label("Cinema Ticket Dispenser");
        lbl_title.getStyleClass().add("Title");

        Button btn_temp1 = Main.createButton("temp1", 0.1f, 0.05f);

        Button btn_temp2 = Main.createButton("temp2", 0.1f, 0.05f);

        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);

        this.setPadding(new Insets(10, 10, 10, 10));//todo magic numbers
        this.spacingProperty().bind(window.widthProperty().multiply(0.01));
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(img_logo, lbl_title, region, btn_temp1, btn_temp2);
        // endregion Header
    }
}
