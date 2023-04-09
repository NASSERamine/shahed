package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable {

    private UserController userSercontroller = new UserController();

    @FXML
    private ImageView image1;

    @FXML
    private ComboBox<String> comborole;

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
    void switchToUserInterface(ActionEvent event) throws IOException {
        App.setRoot("MainUserInterface");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("User", "Actor", "Producer");
        comborole.setItems(list);
    }

    @FXML
    public void handleLoginButtonAction() throws IOException {
        String name = usertextf.getText();
        String password = passwordtextf.getText();

        try {
            if (userSercontroller.authenticateUser(name, password)) {
                // Authentication succeeded
                App.setRoot("MainUserInterface");
            } else {
            	App.setRoot("loginerreur");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
}










