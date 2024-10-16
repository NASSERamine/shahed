package Controller;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.shahed.Sahed.App;

import Dao.MediaDao;
import Entities.Serie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class RechercheavancéController implements Initializable {

    private UserController userController = new UserController();
   
    private List<Serie> filteredSeriesList;

    @FXML
    private ComboBox<String> combochoice;

    @FXML
    private ListView<Serie> listview;

    @FXML
    private Button ruturnbuttn;

    @FXML
    private TextField actortext;

    @FXML
    private TextField countrytext;
    
    @FXML
    private TextField yeartext;

   
    
    @FXML
    private Button rechercheb;
    
    @FXML
    void ruturn(ActionEvent event) throws IOException {
        App.setRoot("AcceuilUser");
    }
    
   


        @Override
        public void initialize(URL location, ResourceBundle resources) {
        	

            // Set genre list
            ObservableList<String> genresList = FXCollections.observableArrayList(
                    "comédie", "dramatique", "policier", "action", "historique", "science-fiction");
            combochoice.setItems(genresList);

            // Set series list
            ObservableList<Serie> observableListeParGenre = FXCollections.observableArrayList();
            listview.setItems(observableListeParGenre);

            // Handle genre selection
            combochoice.setOnAction(event -> {
                String genre = combochoice.getSelectionModel().getSelectedItem();
                try {
                    filterSeries(genre);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            // Handle text fields changes
            actortext.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    filterSeriesByActor(newValue);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            countrytext.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    filterSeriesByCountry(newValue);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            yeartext.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    int filterYear = Integer.parseInt(newValue);
                    filterSeriesByYear(filterYear);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });}

        private void filterSeries(String genre) throws SQLException {
            if (genre == null || genre.isEmpty()) {
                filteredSeriesList = MediaDao.getallSeries();
            } else {
                filteredSeriesList = userController.ConsultSerieParGenre(genre);
            }
            updateSeriesListView();
        }

        private void filterSeriesByActor(String actor) throws SQLException {
            List<Serie> seriesList = userController.ConsultSerieParActeur(actor);
            filterSeriesList(seriesList);
        }

        private void filterSeriesByCountry(String country) throws SQLException {
            List<Serie> seriesList = userController.ConsultSerieParCountry(country);
            filterSeriesList(seriesList);
        }

        private void filterSeriesByYear(int year) throws SQLException {
        	String syear = yeartext.getText();
        	int year1 = Integer.parseInt(syear);
            List<Serie> seriesList = userController.ConsultSerieParYear(year1);
            filterSeriesList(seriesList);
        }

        private void filterSeriesList(List<Serie> seriesList) {
            if (filteredSeriesList == null) {
                filteredSeriesList = new ArrayList<>();
            } else {
                filteredSeriesList.clear();
            }
            for (Serie serie : seriesList) {
                if (!filteredSeriesList.contains(serie)) {
                    filteredSeriesList.add(serie);
                }
            }
            updateSeriesListView();
        }

        private void updateSeriesListView() {
            ObservableList<Serie> observableListeParGenre = FXCollections.observableArrayList();
            observableListeParGenre.setAll(filteredSeriesList);
            listview.setItems(observableListeParGenre);
        }
        
    	@FXML
        public void recherchebuttn() throws SQLException {
    		
        
     
    		try {
    		    String actor = actortext.getText();
    		    String country = countrytext.getText();
    		    String syear = yeartext.getText();
    		    int fieldsFilled = 0;

    		    if (!actor.isEmpty()) fieldsFilled++;
    		    if (!country.isEmpty()) fieldsFilled++;
    		    if (!syear.isEmpty()) fieldsFilled++;

    		    if (fieldsFilled == 0) {
    		        filteredSeriesList = MediaDao.getallSeries();
    		    } else if (fieldsFilled > 1) {
    		        Alert alert = new Alert(AlertType.ERROR);
    		        alert.setHeaderText(null);
    		        alert.setContentText("Veuillez choisir un seul champ à filtrer.");
    		        alert.showAndWait();
    		    } else {
    		        if (!actor.isEmpty()) {
    		            filterSeriesByActor(actor);
    		        } else if (!country.isEmpty()) {
    		            filterSeriesByCountry(country);
    		        } else if (!syear.isEmpty()) {
    		            int year = Integer.parseInt(syear);
    		            filterSeriesByYear(year);
    		        }
    		    }

    		} catch (SQLException e) {
    		    e.printStackTrace();
    		} catch (NumberFormatException e) {
    		    Alert alert = new Alert(AlertType.ERROR);
    		    alert.setHeaderText(null);
    		    alert.setContentText("L'année doit être un nombre entier.");
    		    alert.showAndWait();
    		}

    

    	}}
	
		
	