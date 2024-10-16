package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Database.Dbconnection;
import Entities.Episode;

public class EpisodeDAO {
	
	
	
	public static Episode getEpisode(int numEpisode, int idMedia) throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Episode episode = null;
	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.EPISODE WHERE NUMERO=? AND MEDIA_ID=?";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, numEpisode);
	        ps.setInt(2, idMedia);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("ID");
	            int seasonId = rs.getInt("SEASON_ID");
	            String title = rs.getString("TITLE");
	            Date airDate = rs.getDate("AIR_DATE");
	            int mediaId = rs.getInt("MEDIA_ID");
	            String synopsis = rs.getString("SYNOPSIS");
	            int numero = rs.getInt("NUMERO");
	            
	            episode = new Episode(id, seasonId, title, airDate, mediaId, synopsis, numero);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        // fermer les ressources
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return episode;
	}
	
	

	/**public static List<String> getallFavoriteEpisode(int userId) throws SQLException {
	    List<String> episodes = new ArrayList<>();
	    List<Integer> values = NotificationDAO.getallidMedia(userId);

	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.EPISODE WHERE MEDIA_ID = ?";
	        ps = conn.prepareStatement(query);

	        for (int id : values) {
	            ps.setLong(1, id);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                String name = rs.getString("TITLE");
	                Date date = rs.getDate("AIR_DATE");
	                LocalDate localDateToCompare = ((java.sql.Date) date).toLocalDate();


	                LocalDate currentDate = LocalDate.now();
	                LocalDate earlierDate = currentDate.minus(10, ChronoUnit.DAYS);

	                if (localDateToCompare.isAfter(earlierDate)) {
	                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	                    String strDate = dateFormat.format(date);         
	                    String episode = name + " -----------> " + strDate;
	                    episodes.add(episode);
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        // fermer les ressources
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    return episodes;
	}
**/

	 public static List<String>  getallFavoriteEpisode( int userid) throws SQLException {
		    List<String> episodes = new ArrayList<>();
		    List<Integer> values = NotificationDAO.getallidMedia(userid);

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = Dbconnection.getConnection();
	            String query="";
	            
	             query = "SELECT * FROM SYSTEM.EPISODE WHERE   MEDIA_ID=?";
	            ps = conn.prepareStatement(query);
	            for(int id : values) {

	            ps.setLong(1, id);

	            
	            rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                int num = rs.getInt("NUMERO");
	                String strNum = Integer.toString(num);
	                Date date=rs.getDate("AIR_DATE");
	              /**LocalDate localDateToCompare = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                LocalDate currentDate = LocalDate.now();
                LocalDate earlierDate = currentDate.minus(10, ChronoUnit.DAYS);**/
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(date);        
                  String episode="episode numro"+strNum+"est disponible dans cette date   -------------->  "+strDate;

	                episodes.add(episode);
	                }
	            }
	               
	            
	               
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            // fermer les ressources
	            try {
	                if(rs != null) rs.close();
	                if(ps != null) ps.close();
	                if(conn != null) conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }

	    
	          return episodes;
	    }
	/** public static List<String>  getaDiffusionEpisode( String UserMail) throws SQLException {
		    List<String> episodes = new ArrayList<>();
		    List<Integer> values = FavoriteDAO.getallidMedia(UserMail);

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = Dbconnection.getConnection();
	            String query="";
	            for(int id : values) {
	            
	             query = query +"SELECT * FROM SYSTEM.EPISODE WHERE   MEDIA_ID=?;";
	            ps = conn.prepareStatement(query);
	            ps.setLong(1, id);

	            }
	            rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                int num = rs.getInt("NUMERO");
	                Date date=rs.getDate("AIR_DATE");

                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(date);         
                  String episode="la diffusion de l episode numero"+num+
                 		 "du serie que vous aimez serait le   ----------->  "+strDate;

	                episodes.add(episode);
	                
	                
	            }
	               
	            
	               
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            // fermer les ressources
	            try {
	                if(rs != null) rs.close();
	                if(ps != null) ps.close();
	                if(conn != null) conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }

	    
	          return episodes;
	    }**/
	 public static boolean addEpisode(int season_id, LocalDate air_date, int media_id, String synopsis,int numero,String title) {
		    Connection conn = null;
		    PreparedStatement ps = null;
		    boolean isSuccess = false;
		    try {
		        conn = Dbconnection.getConnection();
		        String query = "INSERT INTO SYSTEM.EPISODE(SEASON_ID,TITLE, AIR_DATE, MEDIA_ID, SYNOPSIS,NUMERO) VALUES (?, ?, ?, ?, ?, ?)";
		        ps = conn.prepareStatement(query);
		        ps.setInt(1, season_id);
		        ps.setString(2, title);
		        ps.setDate(3, java.sql.Date.valueOf(air_date));
		        ps.setInt(4, media_id);
		        ps.setString(5, synopsis);
		        ps.setInt(6, numero);
		        int rowsInserted = ps.executeUpdate();
		        if (rowsInserted > 0) {
		            isSuccess = true;
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        isSuccess = false;
		    } finally {
		        // fermer les ressources
		        try {
		            if (ps != null) ps.close();
		            if (conn != null) conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		    return isSuccess;
		}
	 
	 
	 

	
	
	


}
