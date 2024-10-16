package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;

public class FavoriteDAO {
	public static Boolean 	addFavoriteMedia(int id_user,int id_media) throws SQLException {
		 PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;
		    ResultSet rs = null;


			try {				conn = Dbconnection.getConnection();

			String sql = "INSERT INTO SYSTEM.FAVORITE (USER_ID,MEDIA_ID ) VALUES (?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setLong(1, id_user);
                 ps.setLong(2, id_media);

            int rowsUpdated = ps.executeUpdate();  
           if(rowsUpdated > 0) {
	        Exists = true;
}
			} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			}finally {
		        // Close resources
		        if (rs != null) {
		            rs.close();
		        }
		        if (ps != null) {
		            ps.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }}
	        return Exists;
	       
	
}
	public static List<Integer>  getalldMedia(int id ) throws SQLException {
		 
		    List<Integer> values = new ArrayList<>();

	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = Dbconnection.getConnection();
	            String query = "SELECT MEDIA_ID FROM SYSTEM.FAVORITE WHERE USER_ID=?";
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
