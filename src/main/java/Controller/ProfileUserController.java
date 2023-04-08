package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProfileUserController {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label datelabel;

    @FXML
    private Label emaillabel;

    @FXML
    private ImageView imageusericon;

    @FXML
    private Button modifierbutton;

    @FXML
    private Label passwordlabel;

    @FXML
    private Button ruturnbutton;

    @FXML
    private Label usernamelabel;
    @FXML
    void switchTouserInterface(ActionEvent event) throws IOException {
    	App.setRoot("MainUserInterface");

    }

}
