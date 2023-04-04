package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SignUpController {
	 @FXML
	 AnchorPane anchr = new AnchorPane();
	 @FXML
	 VBox vbx = new VBox();
	 @FXML
	 ImageView img21 = new ImageView();
	 @FXML
	 ImageView img22 = new ImageView();
	 @FXML
	 ImageView img23 = new ImageView();
	 @FXML
	 ImageView img24 = new ImageView();
	 @FXML
	 ImageView img25 = new ImageView();
	 @FXML
	 Label label1 = new Label();
	 @FXML
	 Button btn21 = new Button();
	 @FXML
	 Button btn212 = new Button();
	 @FXML
	 TextField tex1 = new TextField();
	 @FXML
	 TextField tex2 = new TextField();
	 @FXML
	 PasswordField pass = new PasswordField();
	 @FXML
	 TextField tex4 = new TextField();
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}