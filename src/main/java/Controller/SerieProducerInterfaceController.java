package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.shahed.Sahed.App;

import Entities.Media;
import Entities.Serie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SerieProducerInterfaceController  {

    @FXML
    private TextField Synopsistext;
    
    
    @FXML
    private TextField countrytext;

    @FXML
    private TextField idtext;

    @FXML
    private ImageView image;

    @FXML
    private TextField languagetext;

    @FXML
    private Button modifierbuttn;

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
    private TextField nbrsaisontext;
    @FXML
    private TextField nametext;
    @FXML
    private TextField name;

    @FXML
    private Button addseasonbuttn;

    
    
  
    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("ProducterHome");
    }
    
    @FXML
    void addseason(ActionEvent event) throws IOException {
        App.setRoot("ajouterseason");
    }
    
    @FXML
    void addepisode(ActionEvent event) throws IOException {
        App.setRoot("ajouterepisodes");
    }
    
    @FXML
    void viewcomments(ActionEvent event) throws IOException {
        App.setRoot("commentaireproducer");
    }
    
    @FXML
    void viewrating(ActionEvent event) throws IOException {
        App.setRoot("ratingproducer");
    }
    
    
    

   
   /** void modifier(ActionEvent event) {
    	String nbrsaison = nbrsaisontext.getText();
    	int nbre_saison =Integer.parseInt(nbrsaison);
        String date = yeartext.getText();
        String producer =producerid.getText();
        int producer_id=Integer.parseInt(producer);
        int nvdate = Integer.parseInt(date);
        String country = countrytext.getText();
        String synopsis = Synopsistext.getText();
        

        if (nbrsaison.isEmpty() || date.isEmpty() || synopsis.isEmpty() || nbrsaison == null||country.isEmpty()||producer_id==0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs vides");
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();
        } else {
            MediaSession.getSerierecherche().setNbre_de_saison(nbre_saison);
            MediaSession.getSerierecherche().setAnnne_sortie(nvdate);
            MediaSession.getSerierecherche().setSynopsis(synopsis);
            MediaSession.getSerierecherche().setNbre_de_saison(nbre_saison);
            MediaSession.getSerierecherche().setPays_origine(country);
            MediaSession.getSerierecherche().setId_producer(producer_id);
            
            
           /** try {
                boolean updated = usercontroller.updateUser(us);
                if (updated) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Modification avec succès");
                    alert.setContentText("Votre profil a été modifié avec succès.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Échec de la modification");
                    alert.setContentText("La modification du profil a échoué. Veuillez réessayer plus tard.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
           
            	
        }}**/
    


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
    	
    	yeartext.setText(stringyear);
    	languagetext.setText(language);

    	Synopsistext.setText(synopsis);
    	nbrsaisontext.setText(nbrsaison);
    	name.setText(nom);
    	producerid.setText(prodcid);
    	Image image1 = new Image(image_url);
    	image.setImage(image1);
    	
    	
    	
    	
    	
    	
    	
    	
    }
    	
    	
    
    	
    	
    	
        /**Date dateNaissance = us.getDate_de_naissance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateNaissanceStr = dateFormat.format(dateNaissance);

        datenaisstext.setText(dateNaissanceStr);

        emailtext.setText(us.getEmail());

        nametext.setText(us.getNom());
        passwordtext.setText(us.getPassword());
    
    	  
    	 
    	 
    	 
    	 
        
    	  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    **/
    

}