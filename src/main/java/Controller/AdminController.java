package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminController {

    @FXML
    private Button acceuilbuttn;

    @FXML
    private ImageView acceuilimage;

    @FXML
    private BorderPane borderpane;

    @FXML
    private HBox hbox1;

    @FXML
    private HBox hboxcross;

    @FXML
    private HBox hboxentaite;

    @FXML
    private Button logoutbuttn;

    @FXML
    private ImageView logoutimage;

    @FXML
    private Button morebuttn;

    @FXML
    private ImageView morelist;

    @FXML
    private Button profilebuttn;

    @FXML
    private ImageView profileimage;

    @FXML
    private Button recherchebuttn;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextField searchtext;

    @FXML
    private Separator separator1;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vboxmain;

    @FXML
    void Logout(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }

    @FXML
    void handleSearchButtonAction(ActionEvent event) {

    }

    @FXML
    void rechercheavance(ActionEvent event) {

    }

    @FXML
    void switchToProfile(ActionEvent event) {

    }

}