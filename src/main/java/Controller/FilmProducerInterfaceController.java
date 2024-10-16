package Controller;

import java.io.IOException;

import org.shahed.Sahed.App;

import Entities.Film;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FilmProducerInterfaceController {

    @FXML
    private TextField Synopsistext;

    @FXML
    private TextField countrytext;

    @FXML
    private TextField dure;

    @FXML
    private TextField idtext;

    @FXML
    private ImageView image;

    @FXML
    private TextField languagetext;

    @FXML
    private Button modifierbuttn;

    @FXML
    private TextField name;

    @FXML
    private TextField nbrsaisontext;

    @FXML
    private TextField nbrvottanttext;

    @FXML
    private TextField producerid;

    @FXML
    private Button rutrnbuttn;

    @FXML
    private TextField vuestext;

    @FXML
    private TextField yeartext;
    


    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("ProducterHome");
    }
    
    
    
    
    
    
    
    public void initialize() {
    	Film film = MediaSession.getFilmrecherche();
    	int id = film.getId();
    	String nom = film.getNom1();
    	int anne_sortie= film.getAnnne_sortie();
    	String language=film.getLangue();
    	String country= film.getPays_origine();
    	int id_producer =film.getId_producer();
    	String image_url=film.getUrlaffiche();
    	String synopsis= film.getSynopsis();
    	int nbre_vu=film.getNbr_vu();
    	int nbre_votant= film.getNbr_votant();
    	String duree = film.getDure();
    	String stringid = Integer.toString(id);
    	String stringyear = Integer.toString(anne_sortie);
    	String nbrvottant = Integer.toString(nbre_votant);
    	
    	String prodcid=Integer.toString(id_producer);
    	
    	Synopsistext.setText(synopsis);
    	countrytext.setText(country);
    	idtext.setText(stringid);
    	yeartext.setText(stringyear);
    	languagetext.setText(language);
    	nbrvottanttext.setText(nbrvottant);
    	Synopsistext.setText(synopsis);
    	name.setText(nom);
    	producerid.setText(prodcid);
    	dure.setText(duree);
    	
    	Image image1 = new Image(image_url);
    	image.setImage(image1);
    }
    	
    	 

}
