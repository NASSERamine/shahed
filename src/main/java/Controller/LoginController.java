package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LoginController  implements Initializable {

    @FXML
    PasswordField passwrd = new PasswordField();
    @FXML
    TextField text2 = new TextField();
    @FXML
    ImageView img = new ImageView();
    @FXML
    ImageView img2 = new ImageView();
    @FXML
    ImageView img3 = new ImageView();
    @FXML
    ImageView img4 = new ImageView();
    @FXML
    Button btnsignUp = new Button();
    @FXML
    Button btn2 = new Button();
    @FXML
    VBox vbox = new VBox();
    

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("SignUp");
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
