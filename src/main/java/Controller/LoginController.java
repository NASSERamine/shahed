package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Dao.AdminDao;
import Entities.Actor;
import Entities.Admin;
import Entities.Producteur;
import Entities.User;
import Services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable {

    private UserController userSercontroller = new UserController();
    private ActorController actorcontroller = new ActorController();
    private ProducteurController producteurcontroller = new ProducteurController();
   

    
    
    public LoginController() {
    	
    }
    

	@FXML
    private ImageView image1;

    @FXML
    private ComboBox<String> comborole;

    @FXML
    private ImageView lago;

    @FXML
    private Button loginbutton;

    @FXML
    private ImageView passwordicon;

    @FXML
    private PasswordField passwordtextf;

    @FXML
    private Button signupbutton;

    @FXML
    private ImageView usericon;

    @FXML
    private TextField usertextf;

    @FXML
    void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("SignUp");
    }

    @FXML
    void switchToUserInterface(ActionEvent event) throws IOException {
        App.setRoot("AcceuilUser");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("User", "Actor", "Producer","Admin");
        comborole.setItems(list);
    }

    @FXML
    public void handleLoginButtonAction() throws IOException, SQLException {
        String email = usertextf.getText();
        String password = passwordtextf.getText();
        String texteSelectionne = comborole.getSelectionModel().getSelectedItem().toString();
        switch (texteSelectionne) {
        case "User":
        	
        	
        	  try {
                  if (userSercontroller.authenticateUser(email, password)) {
                  	User user = userSercontroller.getUser(usertextf.getText());
                  	Session.setConnecteduser(user);
                  	ProfileUserController profileuser = new ProfileUserController();
                  	profileuser.us.setId(user.getId());
                  	profileuser.us.setNom(user.getNom());
                  	profileuser.us.setEmail(user.getEmail());
                  	profileuser.us.setPassword(user.getPassword());
                  	profileuser.us.setDate_de_naissance(user.getDate_de_naissance());
                      // Authentication succeeded
                  	
                  	
                  	
                      App.setRoot("AcceuilUser");
                  } else {
                  	Alert alert = new Alert(Alert.AlertType.ERROR);
                      alert.setTitle("Login error");
                      alert.setHeaderText(null);
                      alert.setContentText("Invalid Email or password.");
                      alert.showAndWait();
                  }
              } catch (SQLException e) {
                  e.printStackTrace();
              }
        	  break;
        	  
        case "Actor": 
        	 try {
                 if (actorcontroller.authenticateActor(email, password)) {
                	 
                	 
                 	Actor actor = actorcontroller.getActor(usertextf.getText());
                 	Session.setConnectedactor(actor);
                 	ProfileActorController profileactor = new ProfileActorController();
                 	profileactor.act.setId(actor.getId());
                 	profileactor.act.setNom(actor.getNom());
                 	profileactor.act.setEmail(actor.getEmail());
                 	profileactor.act.setPassword(actor.getPassword());
                 	profileactor.act.setDate_de_naissance(actor.getDate_de_naissance());
                     // Authentication succeeded
                     App.setRoot("ActeurHome");
                 } else {
                 	Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setTitle("Login error");
                     alert.setHeaderText(null);
                     alert.setContentText("Invalid Email or password.");
                     alert.showAndWait();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
       	  break;
        case "Producer": 
       	 try {
                if (producteurcontroller.checkProducteur(email, password)) {
                	Producteur producteur =producteurcontroller.getproducteur(usertextf.getText());
                	Session.setConnectedProducer(producteur);
                	ProfileProducteurController profileproducteurcontroller = new ProfileProducteurController();
                	profileproducteurcontroller.pr.setId(producteur.getId());
                	profileproducteurcontroller.pr.setNom(producteur.getNom());
                	profileproducteurcontroller.pr.setEmail(producteur.getEmail());
                	profileproducteurcontroller.pr.setPassword(producteur.getPassword());
                	profileproducteurcontroller.pr.setDate_de_naissance(producteur.getDate_de_naissance());
                    // Authentication succeeded
                    App.setRoot("ProducterHome");
                } else {
                	Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login error");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid Email or password.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
       	 break;
       	 
        case "Admin": 
        	if(AdminDao.checkadmin(email, password)) {
        		Admin admin = AdminDao.getadmin(email);
        		Session.setConnectedadmin(admin);
        		App.setRoot("admin");
        		
				
			}
        	break;
        	
       	 
       	 default:
       		Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login error");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect choice");
            alert.showAndWait();
         break;
       		 
       	  
       	  
        	
        	  
        
        }

       
    }
    	

   
}














