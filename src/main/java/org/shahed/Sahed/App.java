package org.shahed.Sahed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import Controller.ActorController;
import Controller.ProfileActorController;
import Controller.UserController;
import Dao.EpisodeDAO;
import Dao.MediaDao;
import Dao.NotificationDAO;

/**
 * JavaFX App
 */
public class App extends Application {
	
	

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"), 900, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws SQLException {
    	    	
        launch();

    	}}

