package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AjouterserieController implements Initializable {

    @FXML
    private TextField Synopsittext;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private DatePicker datenox;

    @FXML
    private ComboBox<String> genrecombo;

    @FXML
    private TextField idproducteurname;

    @FXML
    private ImageView image;

    @FXML
    private Label label1;

    @FXML
    private TextField languagetext;

    @FXML
    private TextField namestext;

    @FXML
    private Button ruturnbuttn;

    @FXML
    private Button savebuttn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList("Action","Adventure","Comedy","Crime","Drama","Fantasy","Horror","Romance","Science Fiction");
		genrecombo.setItems(list);
		
	}

}
