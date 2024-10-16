package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;

public class RoleDAO {
	 public static List<Integer>  getallidMedia(String ActorName ) throws SQLException {
		 int id = ActorDao.getID(ActorName);
		    List<Integer> values = new ArrayList<>();

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = Dbconnection.getConnection();
	            String query = "SELECT MEDIA_ID FROM SYSTEM.ROLE WHERE ACTOR_ID=?";
	            ps = conn.prepareStatement(query);
	            ps.setLong(1, id);

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
}

