package Services;


import java.sql.SQLException;

import java.util.Date;

import Dao.ActorDao;
import Dao.UserDao;
import Entities.Actor;
import Entities.User;
public class ActorServices {
	
	
	private ActorDao actordao = new ActorDao();
	
	 public boolean authenticateActor(String email, String password) throws SQLException {
	        return actordao.checkActor(email, password);
	    }
	 
	 public boolean signup(String username, String password, String email, java.time.LocalDate date_brith) throws SQLException {
	    	return actordao.signup(username, password, email, date_brith);
	   }
	 
	 public   Actor getActor(String email) throws SQLException {
			return actordao.getActor(email);
	    	
	    }
	 
	 public  boolean updateActor(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
		    
	    	return actordao.updateActor(username, newPassword, newEmail, newBirthdate);
	    }
	 
	 public boolean updateActor(Actor actor) throws SQLException {
	    	return actordao.updateActor(actor);
	    }
	    

}
