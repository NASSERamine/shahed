package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.Dbconnection;

public class SynopsDao {
	
	 public static boolean ajouter_synopsis (String text,String url_vid ) {
			
		   Connection conn = null;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	       boolean Exists = false;
	       
	       try {
	    	   conn = Dbconnection.getConnection();
	           String query = "INSERT INTO SYSTEM.SYNOPSIS(TEXT,VIDEO_ID) VALUES (?,?)";
	           ps = conn.prepareStatement(query);
	           ps.setString(1,text);
	           ps.setString(2,url_vid);
	           
	           int rowsUpdated = ps.executeUpdate();  
	           if(rowsUpdated > 0) {
	          	 Exists = true;
	           }
	       }
	       catch (SQLException ex) {
	    	   ex.printStackTrace();   
	       }
	       finally {
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
	 public static int getID(String text, String url_vid) throws SQLException {
		    Connection conn = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    int id = -1;

		    try {
		        conn = Dbconnection.getConnection();
		        String query = "SELECT id FROM SYSTEM.SYNOPSIS WHERE text=? and VIDEO_ID=?";
		        ps = conn.prepareStatement(query);
		        ps.setString(1, text);
		        ps.setString(2, url_vid);
		        rs = ps.executeQuery();
		        
		        if (rs.next()) {
		            long countLong = rs.getLong(1);
		            id = (int) countLong;
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } finally {
		        // fermer les ressources
		        try {
		            if (rs != null)
		                rs.close();
		            if (ps != null)
		                ps.close();
		            if (conn != null)
		                conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }

		    return id;
		}

	public static boolean Modifier_synopsis(String synopsis_text, String synopsis_url_video) {
		   Connection conn = null;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	       boolean updated = false;
	       
	       try {
	           conn = Dbconnection.getConnection();
	           String query = "UPDATE SYSTEM.SYNOPSIS SET TEXT=? and video_url=? ";
	           ps = conn.prepareStatement(query);
	           ps.setString(1, synopsis_text);
	           ps.setString(2, synopsis_url_video);
	          
	           
	           int rowsUpdated = ps.executeUpdate();  
	           if(rowsUpdated > 0) {
	          	 updated = true;
	           }}
	       catch (SQLException ex) {
	    	   ex.printStackTrace();   
	       }
	       finally {
	           // fermer les ressources
	           try {
	               if(rs != null) rs.close();
	               if(ps != null) ps.close();
	               if(conn != null) conn.close();
	           } catch (SQLException ex) {
	               ex.printStackTrace();
	           }
	       }

	       return updated;
	   }

	public static boolean supprimersynopsis(int id) {
		  
		
		Connection conn = null;
	    PreparedStatement ps = null;
	    boolean isDeleted = false;

	    try {
	        conn = Dbconnection.getConnection();
	        String query = "DELETE FROM SYSTEM.Synopsis WHERE id = ?";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        int rowsDeleted = ps.executeUpdate();
	        if (rowsDeleted > 0) {
	            isDeleted = true;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    return isDeleted;
	}

}
