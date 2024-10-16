package Controller;

import java.io.IOException;
import java.sql.SQLException;

import org.shahed.Sahed.App;

import Dao.SeasonDAO;
import Entities.Season;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AjouterSeasonController {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private TextField annedesortietext;

    @FXML
    private ImageView image;

    @FXML
    private Label label1;

    @FXML
    private TextField nbreepisode;

    @FXML
    private TextField numerotext;

    @FXML
    private Button ruturnbuttn;

    @FXML
    private Button savebuttn;

    @FXML
    private Button savebuttn1;

    @FXML
    private TextField synopsistext;

    @FXML
    void hundelsavebuttn(ActionEvent event) throws SQLException {
    	
    	
    	int numero = Integer.parseInt(numerotext.getText()); 
    	int anne_sortie = Integer.parseInt(annedesortietext.getText());
    	String synopsis = synopsistext.getText();
    	int nbre_episode= Integer.parseInt(nbreepisode.getText());
    	int media_id = MediaSession.getSerierecherche().getId();
    	
    	
    	if(SeasonDAO.checkSeason(media_id, numero)) {
    		try {
    			SeasonDAO.ajouterSaison(numero, anne_sortie, media_id, synopsis, nbre_episode);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			
    		}
    		
    		
    		Season season = SeasonDAO.getSeasonByIdAndNumber(media_id, numero);
        	SeasonSession.setSeasonrechrche(season);
        	
        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Ajout avec succès");
                alert.setContentText("Votre saison a été Ajouté avec succès.");
                alert.showAndWait();
    		
    	}else {
    		 Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Erreur");
             alert.setHeaderText("Échec de l ajout");
             alert.setContentText("La saison déja  existe");
             alert.showAndWait();
    		
    	}
    	
    	
		
           
		
    	
    	

    }

    @FXML
    void switchToEpisode(ActionEvent event) throws IOException {
        App.setRoot("ajouterepisodes");
    }
    
    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("serie");
    }

}

