package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;
import Entities.Media;
import Entities.Raiting;

public class RatingDAO {
	
	NotificationDAO notificationdao = new NotificationDAO();
	public static int getNoteString( int id_media) throws SQLException {
		
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT SCORE FROM SYSTEM.RATING WHERE MEDIA_ID=?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, id_media);
           
            rs = ps.executeQuery();
            
            
               
            
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

        long noteLong = rs.getLong(1);
	      //if you really want and you are sure that it fits you can now cast
	      int note = (int)noteLong; 
	          return note;
    }
 public static int getNoteSeason( int numSeason) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
int  idSeason=SeasonDAO.getID(numSeason);
        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT SCORE FROM SYSTEM.RATING WHERE SEASON_ID=?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, idSeason);
           
            rs = ps.executeQuery();
            
            
               
            
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
        long noteLong = rs.getLong(1);
      //if you really want and you are sure that it fits you can now cast
      int note = (int)noteLong; 
          return note;
    }
 public static int getNoteEpisode( int idepisode) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        

        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT SCORE FROM SYSTEM.RATING WHERE EPISODE_ID=?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, idepisode);
           
            rs = ps.executeQuery();
            
            
               
            
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

        long noteLong = rs.getLong(1);
	      //if you really want and you are sure that it fits you can now cast
	      int note = (int)noteLong; 
	          return note;
    }
 public static Boolean addNoteMedia(int id_media, int id_user, int score) throws SQLException {
	    PreparedStatement ps = null;
	    Connection conn = null;
	    Boolean exists = false;
	    ResultSet rs = null;

	    try {
	        conn = Dbconnection.getConnection();
	        ps = conn.prepareStatement("INSERT INTO SYSTEM.RATING (SCORE, USER_ID, MEDIA_ID) VALUES (?, ?, ?)");

	        ps.setInt(1, score);
	        ps.setInt(2, id_user);
	        ps.setInt(3, id_media);
	       

	        int rowsUpdated = ps.executeUpdate();

	        if (rowsUpdated > 0) {
	            exists = true;
	            // Add series with rating>8 to notifcations
	            if (score >= 8) {
	            	
	                NotificationDAO.addNotification(id_user, id_media);
	                FavoriteDAO.addFavoriteMedia(id_user, id_media);
	            }
	        }
	    } catch (SQLException ex) {
	        
	    } finally {
	        // Close resources
	        if (rs != null) {
	            rs.close();
	        }
	        if (ps != null) {
	            ps.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }

	    return exists;
	}


 public static Boolean addNoteSeason( int season_id,int id_user,int score) throws SQLException {
	 PreparedStatement ps = null;
        Connection conn = null;
        Boolean Exists=false;


		try {
			conn = Dbconnection.getConnection();

		String sql = "INSERT INTO SYSTEM.RATING (SCORE,USERS_ID ,SEASON_ID ) VALUES (?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, score);
ps.setLong(2, id_user);
ps.setLong(3, season_id);

int rowsUpdated = ps.executeUpdate();  
if(rowsUpdated > 0) {
 Exists = true;
}
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
        return Exists;
       
    }
 
 
 
 public static Boolean addNoteEpisode( int id_episode,int id_user,int score) throws SQLException {
	 PreparedStatement ps = null;
        Connection conn = null;
        Boolean Exists=false;


		try {				conn = Dbconnection.getConnection();

		String sql = "INSERT INTO SYSTEM.RATING (SCORE,USERS_ID ,EPISODE_ID ) VALUES (?, ?, ? )";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, score);
ps.setLong(2, id_user);
ps.setLong(3, id_episode);

int rowsUpdated = ps.executeUpdate();  
if(rowsUpdated > 0) {
 Exists = true;
}
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
        return Exists;
        
    }
 public static Boolean UpdateNoteMedia( int id_media,int id_user,int NouveauScore) throws SQLException {
     
    
     PreparedStatement ps = null;
        Connection conn = null;
        Boolean Exists=false;


		try {				conn = Dbconnection.getConnection();

		String sql =  "UPDATE SYSTEM.RATING SET SCORE = ?  WHERE USERS_ID=? AND MEDIA_ID=? ";

			ps = conn.prepareStatement(sql);
			 ps.setLong(1, NouveauScore);
	         ps.setLong(2, id_user);
	         ps.setLong(3, id_media);
	         
	         int rowsUpdated = ps.executeUpdate();  
	         if(rowsUpdated > 0) {
	        	 Exists = true;
	         }
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
        
        return Exists;
       
    }
 public static Boolean UpdateNoteSeason( int id_season,int id_user,int NouveauScore) throws SQLException {

     PreparedStatement ps = null;
        Connection conn = null;
        Boolean Exists=false;

		conn = Dbconnection.getConnection();

		try {
		String sql =  "UPDATE SYSTEM.RATING SET SCORE = ?  WHERE USERS_ID=? AND SEASON_ID=? ";

			ps = conn.prepareStatement(sql);
			 ps.setLong(1, NouveauScore);
	         ps.setLong(2, id_user);
	         ps.setLong(3, id_season);
	         
	         int rowsUpdated = ps.executeUpdate();  
	         if(rowsUpdated > 0) {
	        	 Exists = true;
	         }
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
        
           

        return Exists;
       
    }
 public static Boolean UpdateNoteEpisode( int id_episode,int id_user,int NouveauScore) throws SQLException {

     PreparedStatement ps = null;
        Connection conn = null;
        Boolean Exists=false;


		try {				conn = Dbconnection.getConnection();

		String sql =  "UPDATE SYSTEM.RATING SET SCORE = ?  WHERE USERS_ID=? AND EPISODE_ID=? ";

			ps = conn.prepareStatement(sql);
			 ps.setLong(1, NouveauScore);
	         ps.setLong(2, id_user);
	         ps.setLong(3, id_episode);
	         
	         int rowsUpdated = ps.executeUpdate();  
	         if(rowsUpdated > 0) {
	        	 Exists = true;
	         }
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
        
        return Exists;
       
    }
 
 public static Boolean DeleteNoteMedia( int id_user,int id_media) throws SQLException {
	 
     PreparedStatement ps = null;
        Connection conn = null;
        Boolean Exists=false;


		try {				conn = Dbconnection.getConnection();

		String sql =  "DELETE FROM  SYSTEM.RATING  USER_ID=?  AND MEDIA_ID=? ";

			ps = conn.prepareStatement(sql);
	         ps.setLong(1, id_user);
	         ps.setLong(2, id_media);

	         
	         
	         int rowsUpdated = ps.executeUpdate();  
	         if(rowsUpdated > 0) {
	        	 Exists = true;
	         }
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
        
        return Exists;

}
public static Boolean DeleteNoteSeason( int id_user,int id_season) throws SQLException {
	 
 PreparedStatement ps = null;
 Connection conn = null;
 Boolean Exists=false;


	try {				conn = Dbconnection.getConnection();

	String sql =  "DELETE FROM  SYSTEM.RATING  USER_ID=?  AND SEASON_ID=? ";

		ps = conn.prepareStatement(sql);
         ps.setLong(1, id_user);
         ps.setLong(2, id_season);

         
         
         int rowsUpdated = ps.executeUpdate();  
         if(rowsUpdated > 0) {
        	 Exists = true;
         }
	} catch (SQLException ex) {
	System.out.println(ex.getMessage());
	}
    return Exists;
 

}
public static Boolean DeleteNoteEpisode1( int id_user,int id_episode) throws SQLException {
	 
	 PreparedStatement ps = null;
    Connection conn = null;
    Boolean Exists=false;


		try {
		String sql =  "DELETE FROM  SYSTEM.RATING  USERS_ID=?  AND EPISODE_ID=? ";

			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	         ps.setLong(1, id_user);
	         ps.setLong(2, id_episode);

	         
	         
	         int rowsUpdated = ps.executeUpdate();  
	         if(rowsUpdated > 0) {
	        	 Exists = true;
	         }
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
       return Exists;
    

}
	 

public static boolean checkRaiting( int userid) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean Exists = false;

    try {
        conn = Dbconnection.getConnection();
        String query = "SELECT * FROM SYSTEM.RATING  WHERE  USER_ID=?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, userid);
        
        rs = ps.executeQuery();
        
        if(rs.next()) {
        	Exists = true;
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

    return Exists;
}

public static double getNoteMedia(int id_media) throws SQLException {
    double averageRating = 0.0;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = Dbconnection.getConnection();
        String query = "SELECT AVG(SCORE) AS AVERAGE FROM SYSTEM.RATING WHERE MEDIA_ID = ?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, id_media);
        rs = ps.executeQuery();
        if (rs.next()) {
            averageRating = rs.getDouble("AVERAGE");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return averageRating;
}


public static List<Raiting> getRatingsByActorId(int actorId) throws SQLException {
    List<Raiting> ratingsList = new ArrayList<>();
    List<Media> mediaList = MediaDao.getMediaByActorid(actorId);
    for (Media media : mediaList) {
        List<Raiting> mediaRatings = RatingDAO.getRatingsByActorId(actorId);
        ratingsList.addAll(mediaRatings);
    }
    return ratingsList;
}


public static List<Raiting> getnNoteMedia(int id_media) throws SQLException {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Raiting> ratings = new ArrayList<>();
    try {
        conn = Dbconnection.getConnection();
        String query = "SELECT * FROM SYSTEM.RATING WHERE MEDIA_ID=?";
        ps = conn.prepareStatement(query);
        ps.setLong(1, id_media);
       
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("ID");
            int score = rs.getInt("SCORE");
            int user_id = rs.getInt("USER_ID");
            int media_id = rs.getInt("MEDIA_ID");
            int episode_id = rs.getInt("EPISODE_ID");
            
            Raiting rating = new Raiting(id, score, user_id, media_id, episode_id);
            ratings.add(rating);
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
    
    return ratings;
}


	
	 
	

 
}
