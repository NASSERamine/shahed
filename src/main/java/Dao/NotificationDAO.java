package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;

public class NotificationDAO {
	
	
	public static List<Integer>  getallidMedia(int userid ) throws SQLException {
		    List<Integer> values = new ArrayList<>();

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = Dbconnection.getConnection();
	            String query = "SELECT MEDIA_ID FROM SYSTEM.NOTIFICATION WHERE USER_ID=?";
	            ps = conn.prepareStatement(query);
	            ps.setLong(1, userid);

	            rs = ps.executeQuery();
	            
	            while (rs.next()) {
	                int value = rs.getInt("MEDIA_ID");
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
	public static Boolean 	addNotification(int id_user,int id_media) throws SQLException {
		 PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;
		    ResultSet rs = null;


			try {				conn = Dbconnection.getConnection();

			String sql = "INSERT INTO SYSTEM.NOTIFICATION (USER_ID,MEDIA_ID ) VALUES (?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setLong(1, id_user);
             ps.setLong(2, id_media);

            int rowsUpdated = ps.executeUpdate();  
           if(rowsUpdated > 0) {
	       Exists = true;
}
			} catch (SQLException ex) {
	            ex.printStackTrace();

			}
			 finally {
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
	        return Exists;
	       
	
}
}