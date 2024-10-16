package Controller;

import java.sql.SQLException;
import java.util.Date;

import Entities.Actor;
import Services.ActorServices;

public class ActorController {
	
	private ActorServices actorservice = new ActorServices();
	

	public ActorController(ActorServices actorservice) {
		this.actorservice = actorservice;
	}
	
	 public ActorController() {
		// TODO Auto-generated constructor stub
	}

	public boolean authenticateActor(String email, String password) throws SQLException {
	        return actorservice.authenticateActor(email, password);
	    }
	 
	 public boolean signup(String username, String password, String email, java.time.LocalDate date_brith) throws SQLException {
	    	return actorservice.signup(username, password, email, date_brith);
	   }
	 
	 
	 public   Actor getActor(String email) throws SQLException {
			return actorservice.getActor(email);
	    	
	    }
	 
	 public  boolean updateActor(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
		    
	    	return actorservice.updateActor(username, newPassword, newEmail, newBirthdate);
	    }
	 
	 public boolean updateActor(Actor actor) throws SQLException {
	    	return actorservice.updateActor(actor);
	    }

}
