package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainUserInterfaceController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button consultlist_button;

    @FXML
    private Button consultshudule_button;

    @FXML
    private Button favoriteactor_button;

    @FXML
    private Button favoriteseries_button;

    @FXML
    private ImageView logo;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button searchseries_button;

    @FXML
    private Button viewnotif_button;

    @FXML
    private Button viewprofile_button;

    @FXML
    void switchToLoginInterface(ActionEvent event) throws IOException {
    	App.setRoot("Login");

    }


    @FXML
    void switchToProfileuserInterface(ActionEvent event) {

    }

}