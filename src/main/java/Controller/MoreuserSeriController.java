package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Dao.CommentDAO;
import Dao.MediaDao;
import Dao.RatingDAO;
import Dao.SeasonDAO;
import Entities.Season;
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

public class MoreuserSeriController implements Initializable {
	RatingDAO ratingdao= new RatingDAO();
	CommentDAO commentdao = new CommentDAO();
	SeasonDAO seasondao = new SeasonDAO();

    @FXML
    private TextField commenttext;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label namelabel;

    @FXML
    private TextField notetext;

    @FXML
    private Button returnbuttn;

    @FXML
    private Button savecomment;

    @FXML
    private Button saveraiting;

    @FXML
    private ComboBox<Integer> seasonbox;
    
    @FXML
    private Button updatecomment;

    @FXML
    private Button updateraiting;
    
    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("seriuser");
    }
    
    @FXML
    public void saveraiting() throws SQLException {
    	String sraiting = notetext.getText();
    	int raiting = Integer.parseInt(sraiting);
    	if(raiting<=10) {
    		int season_id = MediaSession.getSerierecherche().getId();
    		int id_user= Session.getConnecteduser().getId();
    		
    		if (ratingdao.checkRaiting(id_user)) {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    			 alert.setTitle("Erreur");
    	            alert.setHeaderText("Échec ");
    	            alert.setContentText("Tu as déja noté cette serie. Veuillez Modifier ");
    	            alert.showAndWait();
    			
    			
    		}else {
    		ratingdao.addNoteMedia(season_id, id_user, raiting);
    		int nbrvottant = MediaSession.getSerierecherche().getNbr_votant();
    		
    		MediaDao.UpdateNbreVOTANT(MediaSession.getSerierecherche().getId(),nbrvottant);
    		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Ajout avec succès");
            alert.setContentText("Votre note est enregistré succès.");
            alert.showAndWait();
    		}
    		
    		
    	}
    	else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Échec ");
            alert.setContentText("La note ne peut pas depasser 10. Veuillez réessayer ");
            alert.showAndWait();
    	}
    	}
    	
    	@FXML
        public void updateraiting() throws SQLException {
        	String sraiting = notetext.getText();
        	int raiting = Integer.parseInt(sraiting);
        	if(raiting<=10) {
        		int season_id = MediaSession.getSerierecherche().getId();
        		int id_user= Session.getConnecteduser().getId();
        		ratingdao.addNoteMedia(season_id, id_user, raiting);
        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Ajout avec succès");
                alert.setContentText("Votre note est enregistré succès.");
                alert.showAndWait();
        		}
        	else {
        		Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Échec ");
                alert.setContentText("La note ne peut pas depasser 10. Veuillez réessayer ");
                alert.showAndWait();
        	}
        	
    	
    }
    @FXML
    public void savecomment() throws SQLException {
    	String comment = commenttext.getText();
    	int season_id = MediaSession.getSerierecherche().getId();
		int id_user= Session.getConnecteduser().getId();
		commentdao.addAvisMedia(season_id, id_user, comment);
		if(commentdao.addAvisMedia(season_id, id_user, comment)) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			  alert.setTitle("Information");
	            alert.setHeaderText("Ajout avec succès");
	            alert.setContentText("Votre Commentaire est enregistré succès.");
	            alert.showAndWait();
			
		}
		
		
    	
    }
    
    

	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	int nbre_saison = MediaSession.getSerierecherche().getNbre_de_saison();
    	ObservableList<Integer> saisons = FXCollections.observableArrayList();
    	for (int i = 1; i <= nbre_saison; i++) {
    	    saisons.add(i);
    	}
    	seasonbox.setItems(saisons);
    	namelabel.setText(MediaSession.getSerierecherche().getNom1());
    	
		
		
	}
    
    @FXML
    public void handleLseasonButtonAction() throws IOException, SQLException {
    	int nbreseason = seasonbox.getValue();
    	Season season = SeasonDAO.getSeason(nbreseason, MediaSession.getSerierecherche().getId());
    	SeasonSession.setSeasonrechrche(season);
    	App.setRoot("SeasonUser");
    	
    	
    	
    }

}
