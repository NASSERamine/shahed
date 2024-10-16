package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SignUpController implements Initializable {
	 private UserController userSercontroller = new UserController();
	 private ActorController actorcontroller = new ActorController();
	 private ProducteurController producteurcontroller = new ProducteurController();


    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField emailtextfield;

    

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
    
    @FXML
    private ImageView iconcin;
    @FXML
    private ImageView dateiconimage;
    @FXML
    private TextField cintext;

    @FXML
    private DatePicker datefield;
    
    @FXML
    void switchToLoginInterface(ActionEvent event) throws IOException {
    	App.setRoot("Login");

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList("User","Acteur","Producer");
		rolebox.setItems(list);
	}
	
	
	@FXML
	public void handlSignupButtonAction() throws IOException {
	    String texteSelectionne = rolebox.getSelectionModel().getSelectedItem().toString();
	    String name = usertextfield.getText();
	    String password = passwordtextfield.getText();
	    String email = emailtextfield.getText();
	    java.time.LocalDate date = datefield.getValue();
	    
	    if (password.length() < 8) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Password error");
	        alert.setHeaderText(null);
	        alert.setContentText("The password must be at least 8 characters long");
	        alert.showAndWait();
	        return;
	    }
	    
	    // Validation de saisie d'email
	    if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Invalid email");
	        alert.setHeaderText(null);
	        alert.setContentText("Please enter a valid email address.");
	        alert.showAndWait();
	        return;
	    }
	    
	    // Vérifier que tous les champs ont été saisis
	    if (name.isEmpty() || password.isEmpty() || email.isEmpty() || date == null) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Missing information");
	        alert.setHeaderText(null);
	        alert.setContentText("Please fill all required fields.");
	        alert.showAndWait();
	        return;
	    }

	    switch (texteSelectionne) {
	        case "User":
	            try {
	                if (userSercontroller.signup(name, password, email, date)) {
	                    App.setRoot("SuccessInscription");
	                } else {
	                    App.setRoot("InscriptionFail");

	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            break;

	        case "Acteur":
	            try {
	                if (actorcontroller.signup(name, password, email, date)) {
	                    App.setRoot("SuccessInscription");
	                } else {
	                    App.setRoot("InscriptionFail");

	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            break;
	        case "Producer":

	            try {
	                if (producteurcontroller.signup(name, password, email, date)) {
	                    App.setRoot("SuccessInscription");
	                } else {
	                    App.setRoot("InscriptionFail");

	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            break;

	        default:
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("Login error");
	            alert.setHeaderText(null);
	            alert.setContentText("Incorrect choice");
	            alert.showAndWait();
	            break;
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}