package Controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EpisodeuserController implements Initializable {

    @FXML
    private ImageView affiche;

    @FXML
    private Label airdatetext;

    @FXML
    private Label episodenumtext;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label nametext;

    @FXML
    private Button ruturnbuttn;

    @FXML
    private Label startyeartext;

    @FXML
    private Label titletext;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		    Date airdate = EpisodeSession.getEpisoderecherche().getAire_date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        String air_date = dateFormat.format(airdate);
	        String image_url = MediaSession.getSerierecherche().getUrlaffiche();
	        String name = MediaSession.getSerierecherche().getNom1();
		
		
		int numeroepisode = EpisodeSession.getEpisoderecherche().getNumero();
		String title = EpisodeSession.getEpisoderecherche().getTitle();
		episodenumtext.setText(title);
		titletext.setText(title);
		airdatetext.setText(air_date);
		Image image1 = new Image(image_url);
    	affiche.setImage(image1);
    	nametext.setText(name);
		
		
	}
	
	 @FXML
	    void ruturn(ActionEvent event) throws IOException {
	    	App.setRoot("SeasonUser");

	    }


}

