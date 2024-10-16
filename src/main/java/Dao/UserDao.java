package Dao;

import java.sql.Connection;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.Dbconnection;
import Entities.User;

public class UserDao {
    
   
    public static boolean checkUser(String EMAIL, String PASSWORD) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean userExists = false;

        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM SYSTEM.USERS  WHERE EMAIL=? AND PASSWORD=?";
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
    
    public boolean signup(String username, String password, String email, LocalDate date_brith) throws SQLException {
    	 Connection conn = null;
    	 PreparedStatement ps = null;
    	 boolean Test = true;
		try {
        	conn = Dbconnection.getConnection();
             ps = conn.prepareStatement(
                "INSERT INTO SYSTEM.USERS (NAME, password, email, BIRTHDATE) VALUES (?, ?, ?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setDate(4, java.sql.Date.valueOf(date_brith));
            if(checkUser(username, password)) {
            	Test=false;
            }
            else {
            ps.executeUpdate();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
		return Test;
    }
    
    public  static User getUser(String email1) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = Dbconnection.getConnection();
            ps = conn.prepareStatement("SELECT ID, NAME, EMAIL, PASSWORD, BIRTHDATE FROM SYSTEM.USERS WHERE EMAIL = ?");
            ps.setString(1, email1);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                int id = rs.getInt(1);
                String name=rs.getString("NAME");
                String email= rs.getString("EMAIL");
                String Password=rs.getString("PASSWORD");
                Date Birthdate=rs.getDate("BIRTHDATE");
                user = new User(id, name, email, Birthdate, Password);
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

        return user;
    }
    
    
    
    public  boolean updateUser(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean updated = false;
        try {
            conn = Dbconnection.getConnection();
            ps = conn.prepareStatement("UPDATE SYSTEM.USERS SET PASSWORD=?, EMAIL=?, BIRTHDATE=? WHERE NAME=?");
            ps.setString(1, newPassword);
            ps.setString(2, newEmail);
            ps.setDate(3,(java.sql.Date) newBirthdate );
            ps.setString(4, username);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return updated;
    }
    
    
    
    

    public boolean updateUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean updated = false;
        try {
            conn = Dbconnection.getConnection();
            ps = conn.prepareStatement("UPDATE SYSTEM.USERS SET PASSWORD=?, EMAIL=?, BIRTHDATE=? , NAME=? WHERE ID=?");
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setDate(3, new java.sql.Date(user.getDate_de_naissance().getTime()));
            ps.setString(4, user.getNom());
            ps.setInt(5, user.getId()); // 
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return updated;
    }

    
    
    public static List<String> GetNotifications( int iduser) throws SQLException {
   	 
  	  return EpisodeDAO.getallFavoriteEpisode(iduser);
  }

        
    }


 
    








    
    
    
    

