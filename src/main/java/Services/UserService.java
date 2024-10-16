package Services;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import Dao.MediaDao;
import Dao.UserDao;
import Entities.Serie;
import Entities.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public boolean authenticateUser(String email, String password) throws SQLException {
        return userDao.checkUser(email, password);
    }
   
    public boolean signup(String username, String password, String email, java.time.LocalDate date_brith) throws SQLException {
    	return userDao.signup(username, password, email, date_brith);
   }
    
    
    public   User getUser(String email) throws SQLException {
		return userDao.getUser(email);
    	
    }
    
    public  boolean updateUser(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
    
    	return userDao.updateUser(username, newPassword, newEmail, newBirthdate);
    }
    
    public boolean updateUser(User user) throws SQLException {
    	return userDao.updateUser(user);
    }
    
    
    public static  List<Serie> ConsultSerieParGenre( String genre) throws SQLException {
   	 List<Serie> series;
   	 List<Serie> values=MediaDao.getallSeries();

   	  series = values.stream()
   		        .filter(serie -> serie.getGenre().equals(genre))
   		        .collect(Collectors.toList());
   	  return series;
   }
   public static List<Serie> ConsultSerieParYear( int year) throws SQLException {
   	 List<Serie> series;
   	 List<Serie> values=MediaDao.getallSeries();

   	  series = values.stream()
   		        .filter(serie -> serie.getAnnne_sortie()==year)
   		        .collect(Collectors.toList());
   	  return series;
   }
   public static List<Serie> ConsultSerieParLanguage( String language) throws SQLException {
   	 List<Serie> series;
   	 List<Serie> values=MediaDao.getallSeries();

   	  series = values.stream()
   		        .filter(serie -> serie.getLangue().equals(language))
   		        .collect(Collectors.toList());
   	  return series;
   }
   public static List<Serie> ConsultSerieParCountry( String country) throws SQLException {
   	 List<Serie> series;
   	 List<Serie> values=MediaDao.getallSeries();

   	  series = values.stream()
   		        .filter(serie -> serie.getPays_origine().equals(country))
   		        .collect(Collectors.toList());
   	  return series;
   }
   public static List<Serie> ConsultSerieParActor( String actorname) throws SQLException {
   	 
   	  return MediaDao.getallSeriesParActor(actorname);
   }


    
}