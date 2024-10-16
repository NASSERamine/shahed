package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Dao.EpisodeDAO;
import Dao.RatingDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class NotificationsController implements Initializable {
	
	List<String> list;

    @FXML
    private Label label;

    @FXML
    private ListView<String> listview;

    @FXML
    private Button ruturnbuttn;

    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("AcceuilUser");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			int id =  Session.getConnecteduser().getId();
		
		list = EpisodeDAO.getallFavoriteEpisode(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listview.getItems().addAll(list);
		
		
		
	}

}
