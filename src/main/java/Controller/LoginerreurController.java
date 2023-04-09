package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginerreurController {

    @FXML
    private Label label1;

    @FXML
    private Button trybutton;

    @FXML
    void switchToLoginInterface(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }

}
