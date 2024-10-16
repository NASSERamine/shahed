package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Dao.RatingDAO;
import Entities.Raiting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RaitingActorController implements Initializable {

	private List<Raiting> list = new ArrayList<>();
    @FXML
    private Label label;

    @FXML
    private ListView<Raiting> listview;

    @FXML
    private Button ruturnbuttn;
    

    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("serieactor");
    }
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int mediaid = MediaSession.getSerierecherche().getId();

		try {
		list = RatingDAO.getnNoteMedia(mediaid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listview.getItems().addAll(list);
		
		
		
	}

}
