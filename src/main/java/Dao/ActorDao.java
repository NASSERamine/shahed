package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import Database.Dbconnection;
import Entities.Actor;
import Entities.User;

public class ActorDao {
	
	public static boolean checkActor(String EMAIL, String PASSWORD) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean userExists = false;

        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM SYSTEM.ACTOR  WHERE EMAIL=? AND PASSWORD=?";
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
                "INSERT INTO SYSTEM.ACTOR (NAME, password, email, BIRTHDATE) VALUES (?, ?, ?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setDate(4, java.sql.Date.valueOf(date_brith));
            if(checkActor(username, password)) {
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
	 
	 public  static Actor getActor(String email1) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Actor actor = null;

	        try {
	            conn = Dbconnection.getConnection();
	            ps = conn.prepareStatement("SELECT ID, NAME, EMAIL, PASSWORD, BIRTHDATE FROM SYSTEM.ACTOR WHERE EMAIL = ?");
	            ps.setString(1, email1);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                
	                int id = rs.getInt(1);
	                String name=rs.getString("NAME");
	                String email= rs.getString("EMAIL");
	                String Password=rs.getString("PASSWORD");
	                Date Birthdate=rs.getDate("BIRTHDATE");
	                actor = new Actor(id, name, email, Birthdate, Password);
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

	        return actor;
	    }
	 
	 
	  public  boolean updateActor(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        boolean updated = false;
	        try {
	            conn = Dbconnection.getConnection();
	            ps = conn.prepareStatement("UPDATE SYSTEM.ACTOR SET PASSWORD=?, EMAIL=?, BIRTHDATE=? WHERE NAME=?");
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
	  

	    public boolean updateActor(Actor actor) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        boolean updated = false;
	        try {
	            conn = Dbconnection.getConnection();
	            ps = conn.prepareStatement("UPDATE SYSTEM.ACTOR SET PASSWORD=?, EMAIL=?, BIRTHDATE=? , NAME=? WHERE ID=?");
	            ps.setString(1, actor.getPassword());
	            ps.setString(2, actor.getEmail());
	            ps.setDate(3, new java.sql.Date(actor.getDate_de_naissance().getTime()));
	            ps.setString(4, actor.getNom());
	            ps.setInt(5, actor.getId()); // 
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
	    
	    
	    
	    public static int getID(String name) throws SQLException {
	        int id = 0;
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try {
	            conn = Dbconnection.getConnection();
	            String query = "SELECT ID FROM SYSTEM.ACTOR WHERE NAME=?";
	            ps = conn.prepareStatement(query);
	            ps.setString(1, name);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                id = rs.getInt("ID");
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
	        return id;
	    }

	    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
