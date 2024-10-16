package Controller;


import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Entities.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AfficheController {

    @FXML
    private ImageView affiche;

   

    @FXML
    private Button likebuttn;

    @FXML
    private ImageView likeimage;

    @FXML
    private Button morebtn;

    @FXML
    private ImageView moredetailimage;

    @FXML
    private TextField notetext;

    @FXML
    private ImageView showimage;

    @FXML
    private VBox vbox;

    @FXML
    private Button viewbuttn;
    @FXML
    private HBox hbox;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vboxmain;

    
    public void setData(Media media) {
        Image image = new Image(getClass().getResourceAsStream(media.getUrlaffiche()));
        affiche.setImage(image);
        
    }
}
