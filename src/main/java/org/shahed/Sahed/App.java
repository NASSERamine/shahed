package org.shahed.Sahed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Database.Dbconnection;

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

    public static void main(String[] args) {
    	try (Connection conn = Dbconnection.getConnection()) {
    	    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM hr.employees");
    	    ResultSet rs = pstmt.executeQuery();

    	    while (rs.next()) {
    	        int employeeId = rs.getInt("employee_id");
    	        String firstName = rs.getString("first_name");
    	        String lastName = rs.getString("last_name");
    	        String email = rs.getString("email");
    	        Date hireDate = rs.getDate("hire_date");
    	        double salary = rs.getDouble("salary");

    	        System.out.println(employeeId + " " + firstName + " " + lastName + " " + email + " " + hireDate + " " + salary);
    	    }
    	} catch (SQLException ex) {
    	    ex.printStackTrace();

        launch();

    	}}}

