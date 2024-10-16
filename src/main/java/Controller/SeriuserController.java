package Controller;

import java.io.IOException;
import java.sql.SQLException;

import org.shahed.Sahed.App;

import Dao.MediaDao;
import Entities.Serie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SeriuserController {

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
    private Button morebuttn;

    @FXML
    void more(ActionEvent event) throws IOException {
        App.setRoot("moreuserserie");
    }
    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("AcceuilUser");
    }
    
    @FXML
    void show(ActionEvent event) throws IOException, SQLException {
    	
    	App.setRoot("seasontrailer");

    }
    
    
    public void initialize() {
    	Serie serie = MediaSession.getSerierecherche();
    	int id = serie.getId();
    	String nom = serie.getNom1();
    	int anne_sortie= serie.getAnnne_sortie();
    	String language=serie.getLangue();
    	String country= serie.getPays_origine();
    	int id_producer =serie.getId_producer();
    	String image_url=serie.getUrlaffiche();
    	String synopsis= serie.getSynopsis();
    	int nbre_vu=serie.getNbr_vu();
    	int nbre_votant= serie.getNbr_votant();
    	int nbre_saison= serie.getNbre_de_saison();
    	String stringid = Integer.toString(id);
    	String stringyear = Integer.toString(anne_sortie);
    	String nbrvottant = Integer.toString(nbre_votant);
    	String nbrsaison = Integer.toString(nbre_saison);
    	String prodcid=Integer.toString(id_producer);
    	
    	Synopsistext.setText(synopsis);
    	countrytext.setText(country);
    	idtext.setText(stringid);
    	yeartext.setText(stringyear);
    	languagetext.setText(language);
    	nbrvottanttext.setText(nbrvottant);
    	Synopsistext.setText(synopsis);
    	nbrsaisontext.setText(nbrsaison);
    	name.setText(nom);
    	producerid.setText(prodcid);
    	Image image1 = new Image(image_url);
    	image.setImage(image1);
    	
    	
    	
    	
    	
    	
    	
    	
    }

}

