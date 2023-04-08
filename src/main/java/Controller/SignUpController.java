package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SignUpController implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField emailtextfield;

    @FXML
    private ImageView iconcin;

    @FXML
    private ImageView image;

    @FXML
    private Label label1;

    @FXML
    private Button loginbutton;

    @FXML
    private ImageView mailicon;

    @FXML
    private ImageView passwordicon;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private ComboBox<String> rolebox;

    @FXML
    private Button signupbuutn;

    @FXML
    private ImageView usericon;

    @FXML
    private TextField usertextfield;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList("User","Acteur","Producteur");
		rolebox.setItems(list);
	}

}