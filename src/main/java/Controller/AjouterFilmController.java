package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Entities.Producteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AjouterFilmController implements Initializable {
	
	MediaController mediaController = new MediaController();
	LoginController loginController = new LoginController();
	Producteur connectedproducer = Session.getConnectedProducer();

    @FXML
    private TextField Synopsittext1;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private TextField annedesortietext;

    @FXML
    private TextField countrytext;

    @FXML
    private ComboBox<String> genrecombo;

    @FXML
    private ImageView image;

    @FXML
    private TextField imageurltext;

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
    @FXML
    private TextField duretext;
    @FXML
    void switchToProfile(ActionEvent event) throws IOException {
        App.setRoot("ProducterHome");
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	ObservableList<String> list = FXCollections.observableArrayList("comédie", "dramatique", "policier", "action", "historique"," science-fiction");
    	genrecombo.setItems(list);
    	
    }

    public void hundelsavebuttn()throws IOException, SQLException {
    	String name = namestext.getText();
    	int anne_sortie = Integer.parseInt(annedesortietext.getText());
    	String country = countrytext.getText();
    	String synopsistext= Synopsittext1.getText();
    	String language = languagetext.getText();
    	int id_producteur = connectedproducer.getId();
    	String type ="FILM";
    	String duré = duretext.getText();
    	String imageurl =  imageurltext.getText();
    	String genre = genrecombo.getSelectionModel().getSelectedItem().toString();
    	
    	if(mediaController.ajouterFilm(name, anne_sortie, language, country, imageurl, synopsistext, genre, duré, type, id_producteur)) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Ajout avec succès");
            alert.setContentText("Votre Film a été Ajouté avec succès.");
            alert.showAndWait();
		}
		else{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Échec d' ajout");
            alert.setContentText("L'ajout  a échoué. Veuillez réessayer plus tard.");
            alert.showAndWait();
			

		}
    	
    }

    
  

}