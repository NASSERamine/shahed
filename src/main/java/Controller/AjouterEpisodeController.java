package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Dao.EpisodeDAO;
import Dao.SeasonDAO;
import Entities.Episode;
import Entities.Season;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AjouterEpisodeController implements Initializable {

    @FXML
    private DatePicker airdate;

    @FXML
    private AnchorPane anchorpane;
    
    @FXML
    private ComboBox<Integer> seasonnumber;

    @FXML
    private ImageView image;

    @FXML
    private Label label1;

    @FXML
    private TextField numerotext;

    @FXML
    private Button ruturnbuttn;

    @FXML
    private Button savebuttn;

    @FXML
    private TextField synopsistext;

    @FXML
    private TextField titletext;

    @FXML
    void hundelsavebuttn(ActionEvent event) throws SQLException {
    	
    	
    	int numero = Integer.parseInt(numerotext.getText()); 
    	LocalDate air_date = airdate.getValue();
    	String synopsis = synopsistext.getText();
    	String title = titletext.getText();
    	int nbreseason = seasonnumber.getValue();
    	Season season = SeasonDAO.getSeason(nbreseason, MediaSession.getSerierecherche().getId());
    	SeasonSession.setSeasonrechrche(season);
    	int media_id = MediaSession.getSerierecherche().getId();
    	int season_id = SeasonSession.getSeasonrechrche().getId();
    	
    	EpisodeDAO.addEpisode(season_id, air_date, media_id, synopsis, numero,title);
    	
    	EpisodeDAO.addEpisode(season_id, air_date, media_id, synopsis, numero,title);
    	
    	
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Ajout avec succès");
            alert.setContentText("Votre Serie a été Ajouté avec succès.");
            alert.showAndWait();
		
           
		
    	
    	

    }
    
    
   


    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("serie");
    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int nbre_saison = MediaSession.getSerierecherche().getNbre_de_saison();
    	ObservableList<Integer> saisons = FXCollections.observableArrayList();
    	for (int i = 1; i <= nbre_saison; i++) {
    	    saisons.add(i);
    	}
    	seasonnumber.setItems(saisons);
		
	}
    

}

