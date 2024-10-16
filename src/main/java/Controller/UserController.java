package Controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import Entities.Serie;
import Entities.User;
import Services.UserService;

public class UserController {
    private UserService userService;

    public UserController() {
		this.userService = new UserService();
	}

    public boolean authenticateUser(String email, String password) throws SQLException {
        return userService.authenticateUser(email, password);
    }
    public boolean signup(String username, String password, String email, java.time.LocalDate date_brith) throws SQLException {
    	return userService.signup(username, password, email, date_brith);
   }
    
    public   User getUser(String email) throws SQLException {
		return userService.getUser(email);
    	
    }
    
    public  boolean updateUser(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
        
    	return userService.updateUser(username, newPassword, newEmail, newBirthdate);
    }

    public boolean updateUser(User user) throws SQLException {
    	return userService.updateUser(user);
    
}
    
    
    public  List<Serie> ConsultSerieParGenre( String genre) throws SQLException {
		
		  return UserService.ConsultSerieParGenre(genre);
	}
public  List<Serie> ConsultSerieParYear( int year) throws SQLException {
		
	  return UserService.ConsultSerieParYear(year);
}public  List<Serie> ConsultSerieParCountry( String country) throws SQLException {
	
	  return UserService.ConsultSerieParCountry(country);
}public  List<Serie> ConsultSerieParLanguage( String language) throws SQLException {
	
	  return UserService.ConsultSerieParLanguage(language);
}
public  List<Serie> ConsultSerieParActeur( String ActorName) throws SQLException {
	
	  return UserService.ConsultSerieParActor(ActorName);
}}
    

