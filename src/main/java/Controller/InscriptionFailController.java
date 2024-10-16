package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InscriptionFailController {

    @FXML
    private Label text1;

    @FXML
    private Button trybuttn;
    
    @FXML
    void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("SignUp");
    }



}
