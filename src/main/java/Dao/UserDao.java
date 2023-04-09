package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.Dbconnection;

public class UserDao {
    
   
    public static boolean checkUser(String NAME, String PASSWORD) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean userExists = false;

        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM SYSTEM.UTIL WHERE NAME=? AND PASSWORD=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, NAME);
            ps.setString(2, PASSWORD);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                userExists = true;
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

        return userExists;
    }
    
    
    
    
}
