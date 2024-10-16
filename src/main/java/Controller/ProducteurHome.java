package Controller;

import java.io.IOException;
import java.sql.SQLException;

import org.shahed.Sahed.App;

import Entities.Actor;
import Entities.Film;
import Entities.Media;
import Entities.Producteur;
import Entities.Serie;
import Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProducteurHome {

	MediaController mediacontroller = new MediaController();

    @FXML
    private Button acceuilbuttn;

    @FXML
    private ImageView acceuilimage;

    @FXML
    private ImageView actorimage;

    @FXML
    private Button addfilmbuttn;

    @FXML
    private Button addseriebuttn;

    @FXML
    private BorderPane borderpane;

    @FXML
    private ImageView favoritegenreimage;

    @FXML
    private Label favoritelabel;

    @FXML
    private HBox hbox1;

    @FXML
    private HBox hboxcross;

    @FXML
    private HBox hboxentaite;

    @FXML
    private Button logoutbuttn;

    @FXML
    private ImageView logoutimage;

    @FXML
    private Button morebuttn;

    @FXML
    private ImageView morelist;

    @FXML
    private Button notifbuttn;

    @FXML
    private Button profilebuttn;

    @FXML
    private ImageView profileimage;

    @FXML
    private Button recherchebuttn;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextField searchtext;

    @FXML
    private Separator separator1;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vboxmain;

   


    @FXML
    void switchToProfile(ActionEvent event) throws IOException {
        App.setRoot("ProfileProducteur");
    }
    
    
    @FXML
    void switchtoAddserie(ActionEvent event) throws IOException {
        App.setRoot("AjouterseriInterface");
    }
   
    @FXML
    void switchtoAddfilms(ActionEvent event) throws IOException {
        App.setRoot("AjouterFilm");
    }

    
    @FXML
    void Logout(ActionEvent event) throws IOException {
        App.setRoot("Login");
    }
    
    @FXML
    void swirecherche(ActionEvent event) throws IOException {
        App.setRoot("serie");
    }
    
    @FXML
    public void handleSearchButtonAction() throws IOException, SQLException {
        String name = searchtext.getText();
        
        	
        	
        	  if(mediacontroller.chekMedia(name)) {
			  Media media = mediacontroller.getmedia(name);
			  if(media.getType().equals("SERIE")) {
				  Serie serie = mediacontroller.getSerie(name);
			   MediaSession.setSerierecherche( serie);
			   App.setRoot("serie");
			  } else {
				  
				 Film film = mediacontroller.getFilm(name);
				 MediaSession.setFilmrecherche(film);
				 App.setRoot("film");
			  }
			  
        	  }
			  else {
			  	Alert alert = new Alert(Alert.AlertType.ERROR);
			      alert.setTitle("Recherche error");
			      alert.setHeaderText(null);
			      alert.setContentText("media does not exist");
			      alert.showAndWait();
			  }
        	 
        	
        	  
        
}

       
    }
    
