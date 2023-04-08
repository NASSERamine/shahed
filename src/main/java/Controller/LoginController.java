package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView lago;

    @FXML
    private Button loginbutton;

    @FXML
    private ImageView passwordicon;

    @FXML
    private PasswordField passwordtextf;

    @FXML
    private Button signupbutton;

    @FXML
    private ImageView usericon;

    @FXML
    private TextField usertextf;

    @FXML
    void switchToSecondary(ActionEvent event) throws IOException {
    	App.setRoot("SignUp");

    }

    @FXML
    void switchTouserInterface(ActionEvent event) throws IOException {
    	App.setRoot("MainUserInterface");

    }

}



