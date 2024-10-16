package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.shahed.Sahed.App;
import java.sql.SQLException;

import Dao.UserDao;
import Entities.Actor;
import Entities.User;
import Entities.Visiteur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProfileUserController {
	

   
    private UserController usercontroller = new UserController();
    
    

    public static User us = new User();
    public ProfileUserController() {
    	
    }
   

    @FXML
    private AnchorPane anchor;


	@FXML
    private TextField datenaisstext;

    @FXML
    private TextField emailtext;

    @FXML
    private ImageView imageusericon;

    @FXML
    private ImageView imageview;

    @FXML
    private Button modifierbutton;

    @FXML
    private TextField nametext;

    @FXML
    private TextField passwordtext;

    @FXML
    private Button ruturnbutton;

    @FXML
    void switchTouserInterface(ActionEvent event) throws IOException {
        App.setRoot("AcceuilUser");
    }

    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("AcceuilUser");
    }

    @FXML
    void modifier(ActionEvent event) {
        String nom = nametext.getText();
        String email = emailtext.getText();
        String password = passwordtext.getText();
        String dateNaissanceStr = datenaisstext.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance = null;
        try {
            dateNaissance = dateFormat.parse(dateNaissanceStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (nom.isEmpty() || email.isEmpty() || password.isEmpty() || dateNaissance == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs vides");
            alert.setContentText("Veuillez remplir tous les champs!");
            alert.showAndWait();
        } else {
            us.setNom(nom);
            us.setEmail(email);
            us.setPassword(password);
            us.setDate_de_naissance(dateNaissance);
          
            
            try {
                boolean updated = usercontroller.updateUser(us);
                if (updated) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Modification avec succès");
                    alert.setContentText("Votre profil a été modifié avec succès.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Échec de la modification");
                    alert.setContentText("La modification du profil a échoué. Veuillez réessayer plus tard.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
           
            	
        }}
    }


    public void initialize() {
    	//ProfileUserController profilecontroller = new ProfileUserController();
    	
        Date dateNaissance = us.getDate_de_naissance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateNaissanceStr = dateFormat.format(dateNaissance);

        datenaisstext.setText(dateNaissanceStr);

        emailtext.setText(us.getEmail());

        nametext.setText(us.getNom());
        passwordtext.setText(us.getPassword());
    
    	  
    	 
    	 
    	 
    	 
        
    	  }
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

