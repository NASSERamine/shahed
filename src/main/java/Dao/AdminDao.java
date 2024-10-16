package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Database.Dbconnection;
import Entities.Admin;
import Entities.User;

public class AdminDao {
	

    public static boolean checkadmin(String EMAIL, String PASSWORD) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean userExists = false;

        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM SYSTEM.ADMIN  WHERE EMAIL=? AND PASSWORD=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, EMAIL);
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
    
    public  static Admin getadmin(String email1) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Admin admin = null;

        try {
            conn = Dbconnection.getConnection();
            ps = conn.prepareStatement("SELECT ID, NAME, EMAIL, PASSWORD, BIRTHDATE FROM SYSTEM.ADMIN WHERE EMAIL = ?");
            ps.setString(1, email1);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                int id = rs.getInt(1);
                String name=rs.getString("NAME");
                String email= rs.getString("EMAIL");
                String Password=rs.getString("PASSWORD");
                Date Birthdate=rs.getDate("BIRTHDATE");
                 admin = new Admin(id, name, email, Birthdate, Password);
               
            }

        } finally {
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

        return admin;
    }

}
