package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;
import Entities.Commentaire;

public class CommentDAO {
	  public static List<String> getCommentaireString( int idmedia) throws SQLException {
		    List<String> values = new ArrayList<>();

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
      
	        try {
	            conn =  Dbconnection.getConnection();
	            String query = "SELECT COMMENTAIRE FROM SYSTEM.COMMENTAIRE WHERE MEDIA_ID=?";
	            ps = conn.prepareStatement(query);
	            ps.setInt(1, idmedia);
	           
	            rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                String value = rs.getString("COMMENTAIRE");
	                values.add(value);
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

	       
	          return values;
	    }
	 public static List<String>  getCommentaireSeason( int idSeason) throws SQLException {
		    List<String> values = new ArrayList<>();

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = Dbconnection.getConnection();
	            String query = "SELECT COMMENTAIRE FROM SYSTEM.COMMENTAIRE WHERE SEASON_ID=?";
	            ps = conn.prepareStatement(query);
	            ps.setLong(1, idSeason);
	           
	            rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                String value = rs.getString("COMMENTAIRE");
	                values.add(value);
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

	    
	          return values;
	    }
	 public static List<String> getCommentaireEpisode( int idEpisode) throws SQLException {
		    List<String> values = new ArrayList<>();

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = Dbconnection.getConnection();
	            String query = "SELECT COMMENTAIRE FROM SYSTEM.COMMENTAIRE WHERE EPISODE_ID=?";
	            ps = conn.prepareStatement(query);
	            ps.setLong(1, idEpisode);
	           
	            rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                String value = rs.getString("COMMENTAIRE");
	                values.add(value);
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
	          return values;

	        
	    }
	 
	
	 public static Boolean addAvisMedia( int id_media,int id_user,String commentaire) throws SQLException {
		 PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql = "INSERT INTO SYSTEM.COMMENTAIRE (COMMENTAIRE,USER_ID ,MEDIA_ID ) VALUES (?, ?, ? )";
				ps = conn.prepareStatement(sql);
				ps.setNString(1, commentaire);
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
	
	 public static Boolean addAvisSeason( int season_id,int id_user,String commentaire) throws SQLException {
		 PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql = "INSERT INTO SYSTEM.COMMENTAIRE (COMMENTAIRE,USER_ID ,SEASON_ID ) VALUES (?, ?, ? )";
				ps = conn.prepareStatement(sql);
				ps.setNString(1, commentaire);
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
	 
	 
	 
	 public static Boolean addAvisEpisode( int id_episode,int id_user,String commentaire) throws SQLException {
		 PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql = "INSERT INTO SYSTEM.COMMENTAIRE (COMMENTAIRE,USER_ID ,EPISODE_ID ) VALUES (?, ?, ? )";
				ps = conn.prepareStatement(sql);
				ps.setNString(1, commentaire);
         ps.setLong(2, id_user);
         ps.setLong(3, id_episode);
         int rowsUpdated = ps.executeUpdate();  
         if(rowsUpdated > 0) {
        	 Exists = true;
         }
			} catch (SQLException ex) {
			
			}
	        return Exists;
	        
	    }
	 public static Boolean UpdateAvisMedia( int id_media,int id_user,String Nouveaucommentaire) throws SQLException {
         
        
         PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql =  "UPDATE SYSTEM.COMMENTAIRE SET COMMENTAIRE = ?  WHERE USER_ID=? AND MEDIA_ID=? ";

				ps = conn.prepareStatement(sql);
				 ps.setNString(1, Nouveaucommentaire);
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
	 public static Boolean UpdateAvisSeason( int id_season,int id_user,String Nouveaucommentaire) throws SQLException {
		 PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql =  "UPDATE SYSTEM.COMMENTAIRE SET COMMENTAIRE = ?  WHERE USER_ID=? AND SEASON_ID=? ";

				ps = conn.prepareStatement(sql);
				 ps.setNString(1, Nouveaucommentaire);
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
	 public static Boolean UpdateAvisEpisode( int id_episode,int id_user,String Nouveaucommentaire) throws SQLException {
		 PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql =  "UPDATE SYSTEM.COMMENTAIRE SET COMMENTAIRE = ?  WHERE USER_ID=? AND EPISODE_ID=? ";

				ps = conn.prepareStatement(sql);
				 ps.setNString(1, Nouveaucommentaire);
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
	 
	 public static Boolean DeleteAvisMedia( int id_user,int id_media) throws SQLException {
		 
         PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql =  "DELETE FROM  SYSTEM.COMMENTAIRE  USER_ID=?  AND MEDIA_ID=? ";

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
 public static Boolean DeleteAvisSeason( int id_user,int id_season) throws SQLException {
		 
         PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;

			try {				conn = Dbconnection.getConnection();

			String sql =  "DELETE FROM  SYSTEM.COMMENTAIRE  USER_ID=?  AND SEASON_ID=? ";

				ps = conn.prepareStatement(sql);
		         ps.setLong(1, id_user);
		         ps.setLong(1, id_season);

		         
		         int rowsUpdated = ps.executeUpdate();  
		         if(rowsUpdated > 0) {
		        	 Exists = true;
		         }
			} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			}
	        return Exists;
	        

}
 public static Boolean DeleteAvisEpisode( int id_user,int id_episode) throws SQLException {
	 
     PreparedStatement ps = null;
        Connection conn = null;
        Boolean Exists=false;

		try {				conn = Dbconnection.getConnection();

		String sql =  "DELETE FROM  SYSTEM.COMMENTAIRE  USER_ID=?  AND EPISODE_ID=? ";

			ps = conn.prepareStatement(sql);
	         ps.setLong(1, id_user);
	         ps.setLong(1, id_episode);

	         
	         int rowsUpdated = ps.executeUpdate();  
	         if(rowsUpdated > 0) {
	        	 Exists = true;
	         }
		} catch (SQLException ex) {
		System.out.println(ex.getMessage());
		}
        
        return Exists;

}
 
 public static boolean checkComment( int userid) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    boolean Exists = false;

	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.COMMENTAIRE  WHERE  USER_ID=?";
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
 
 
 
 
 
 
 
 
 public static List<Commentaire> getcommentairemedia(int id_media) throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Commentaire> commentaires = new ArrayList<>();
	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.COMMENTAIRE WHERE MEDIA_ID=?";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id_media);
	       
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            int id = rs.getInt("ID");
	            String commentaire = rs.getString("COMMENTAIRE");
	            int media_id = rs.getInt("MEDIA_ID");
	            int saason_id = rs.getInt("SEASON_ID");
	            int episode_id = rs.getInt("EPISODE_ID");
	            Commentaire comm = new Commentaire(id, commentaire, media_id, saason_id, episode_id);
	            commentaires.add(comm);
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
	    return commentaires;
	}

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}