package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SeasonUserController  implements Initializable{
	EpisodeDAO episodedao = new EpisodeDAO();

    @FXML
    private ImageView affiche;

    @FXML
    private ComboBox<Integer> episodecombobox;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label31;

    @FXML
    private Label nametext;

    @FXML
    private Label numbreepisodetext;

    @FXML
    private Button ruturnbuttn;

    @FXML
    private Label seasonnumtext;

    @FXML
    private Label startyeartext;

	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	int nbre_episode = SeasonSession.getSeasonrechrche().getNbr_episode();
    	ObservableList<Integer> saisons = FXCollections.observableArrayList();
    	for (int i = 1; i <= nbre_episode; i++) {
    	    saisons.add(i);
    	}
    	episodecombobox.setItems(saisons);
    	
    	
    	
    	
    	int nbreepisode =SeasonSession.getSeasonrechrche().getNbr_episode();
    	String nbrepisode = Integer.toString(nbreepisode);
    	int numseason = SeasonSession.getSeasonrechrche().getNum();
    	String numero_season = Integer.toString(numseason);
    	int startyear= SeasonSession.getSeasonrechrche().getStart_year();
    	String start_year = Integer.toString(startyear);
    	String image_url = MediaSession.getSerierecherche().getUrlaffiche();
    	
    			
    	
    	nametext.setText(MediaSession.getSerierecherche().getNom1());
    	numbreepisodetext.setText(nbrepisode);
    	seasonnumtext.setText(numero_season);
    	startyeartext.setText(start_year);
    	Image image1 = new Image(image_url);
    	affiche.setImage(image1);
    	
    	
    	
    	
	}
    @FXML
    void ruturn(ActionEvent event) throws IOException {
    	App.setRoot("moreuserserie");

    }
    
   


    
    
    
    @FXML
    public void handleLseasonButtonAction() throws IOException, SQLException {
    	int numepisode = episodecombobox.getValue();
    	Episode episode = episodedao.getEpisode(numepisode, MediaSession.getSerierecherche().getId());
    	EpisodeSession.setEpisoderecherche(episode);
    	App.setRoot("episodeuser");
    	
    	
    	
    }

}
