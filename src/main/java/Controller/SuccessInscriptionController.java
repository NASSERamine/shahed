package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SuccessInscriptionController {

    @FXML
    private Button loginbuttn;

    @FXML
    private Label text1;
    @FXML
    void switchToLoginInterface(ActionEvent event) throws IOException {
    	App.setRoot("Login");

    }

}
