package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.shahed.Sahed.App;

import Entities.Producteur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProfileProducteurController {
	
	public static Producteur pr = new Producteur();
	ProducteurController producteurcontroller = new ProducteurController();

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
    void modifier(ActionEvent event) {

    }

    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("ProducterHome");
    }
    
    @FXML
    void modifier2(ActionEvent event) {
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
        	pr.setNom(nom);
        	pr.setEmail(email);
        	pr.setPassword(password);
        	pr.setDate_de_naissance(dateNaissance);
          
            
            try {
                boolean updated = producteurcontroller.updateProducteur(pr);
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
    	
    	
        Date dateNaissance = pr.getDate_de_naissance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateNaissanceStr = dateFormat.format(dateNaissance);

        datenaisstext.setText(dateNaissanceStr);

        emailtext.setText(pr.getEmail());

        nametext.setText(pr.getNom());
        passwordtext.setText(pr.getPassword());
    
    	  
    	 
    	 
    	 
    	 
        
    	  }


}
