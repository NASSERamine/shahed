package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Dao.MediaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class SeasonTrailerController  implements Initializable{

    @FXML
    private Button buttn;

    @FXML
    private MediaView video;
    
    private File file;
    private Media media ;
    private MediaPlayer mediaplayer ;
    

    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("seriuser");
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		int id = MediaSession.getSerierecherche().getId();
		int nbrvu = MediaSession.getSerierecherche().getNbr_vu();
    	try {
			MediaDao.UpdateVuMedia(id,nbrvu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = MediaSession.getSerierecherche().getSynopsis();
		file = new File(url);
		media = new Media(file.toURI().toString());
		mediaplayer = new MediaPlayer(media);
		video.setMediaPlayer(mediaplayer);
		// TODO Auto-generated method stub
		
	}
	 @FXML
	void playvideo() {
		mediaplayer.play();
	}
    
    

}
