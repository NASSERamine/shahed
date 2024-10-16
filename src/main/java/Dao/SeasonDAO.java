package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;
import Entities.Season;
import Entities.Serie;

public class SeasonDAO {
	
		public static int getID( int num) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        boolean userExists = false;

	        try {
	            conn = Dbconnection.getConnection();
	            String query = "SELECT ID FROM SYSTEM.SEASON WHERE NUMERO=? ";
	            ps = conn.prepareStatement(query);
	            ps.setLong(1, num);
	           
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
	        long countLong = rs.getLong(1);
	      //if you really want and you are sure that it fits you can now cast
	      int id = (int)countLong; 
	        return id;
	    }
		public static Season getSeason(int NumSeason, int id_media) throws SQLException {
		    Connection conn = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    Season saison = null;
		    try {
		        conn = Dbconnection.getConnection();
		        String query = "SELECT * FROM SYSTEM.SEASON WHERE NUMB=? AND MEDIA_ID=?";
		        ps = conn.prepareStatement(query);
		        ps.setInt(1, NumSeason);
		        ps.setInt(2, id_media);
		        rs = ps.executeQuery();
		        if (rs.next()) {
		            int id = rs.getInt("ID");
		            int numero = rs.getInt("NUMB");
		            int annne_sortie = rs.getInt("START_YEAR");
		            String synopsis = rs.getString("SYNOPSIS");
		            int nbr_episode = rs.getInt("NBR_EPISODE");
		            saison = new Season(id, numero, annne_sortie, id_media, synopsis, nbr_episode);
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } finally {
		        // fermer les ressources
		        try {
		            if (rs != null) rs.close();
		            if (ps != null) ps.close();
		            if (conn != null) conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		    return saison;
		}

		 public static String Regarder( int id) throws SQLException {
			    

		        Connection conn = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        String URL="";
		        try {
		            conn =  Dbconnection.getConnection();
		            String query = "SELECT SYNOPSIS FROM SYSTEM.SEASON WHERE ID=?";
		            ps = conn.prepareStatement(query);
		            ps.setLong(1, id);
		           
		            rs = ps.executeQuery();
		            
		            while (rs.next()) {
                  URL = rs.getString("SYNOPSIS");
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
		          return URL;

	 }
		 
		 public static void ajouterSaison(int numero, int anneeSortie, int idMedia, String synopsis, int nbrEpisode) throws SQLException {
			    Connection conn = null;
			    PreparedStatement ps = null;
			    try {
			        conn = Dbconnection.getConnection();
			        String query = "INSERT INTO SYSTEM.SEASON (NUMB, START_YEAR, MEDIA_ID, SYNOPSIS, NBR_EPISODE) VALUES (?, ?, ?, ?, ?)";
			        ps = conn.prepareStatement(query);
			        ps.setInt(1, numero);
			        ps.setInt(2, anneeSortie);
			        ps.setInt(3, idMedia);
			        ps.setString(4, synopsis);
			        ps.setInt(5, nbrEpisode);
			        ps.executeUpdate();
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        // fermer les ressources
			        try {
			            if (ps != null) ps.close();
			            if (conn != null) conn.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			}
		 
		 
		 public static Season getSeasonByNumberAndMediaId(int numero, int idMedia) throws SQLException {
			    Connection conn = null;
			    PreparedStatement ps = null;
			    ResultSet rs = null;
			    Season saison = null;
			    try {
			        conn = Dbconnection.getConnection();
			        String query = "SELECT * FROM SYSTEM.SEASON WHERE NUMB=? AND MEDIA_ID=?";
			        ps = conn.prepareStatement(query);
			        ps.setInt(1, numero);
			        ps.setInt(2, idMedia);
			        rs = ps.executeQuery();
			        if (rs.next()) {
			            int id = rs.getInt("ID");
			            int annne_sortie = rs.getInt("START_YEAR");
			            String synopsis = rs.getString("SYNOPSIS");
			            int nbr_episode = rs.getInt("NBR_EPISODE");
			            saison = new Season(id, numero, annne_sortie, idMedia, synopsis, nbr_episode);
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        // fermer les ressources
			        try {
			            if (rs != null) rs.close();
			            if (ps != null) ps.close();
			            if (conn != null) conn.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			    return saison;
			}

		 
		 public static boolean checkSeason(int numero, int idMedia) throws SQLException {
			    Connection conn = null;
			    PreparedStatement ps = null;
			    ResultSet rs = null;
			    boolean exists = false;
			    try {
			        conn = Dbconnection.getConnection();
			        String query = "SELECT COUNT(*) AS count FROM SYSTEM.SEASON WHERE NUMB=? AND MEDIA_ID=?";
			        ps = conn.prepareStatement(query);
			        ps.setInt(1, numero);
			        ps.setInt(2, idMedia);
			        rs = ps.executeQuery();
			        if (rs.next()) {
			            int count = rs.getInt("count");
			            if (count > 0) {
			                exists = true;
			            }
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        // fermer les ressources
			        try {
			            if (rs != null) rs.close();
			            if (ps != null) ps.close();
			            if (conn != null) conn.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			    return exists;
			}
		 
		 public static void updateSeason(int id, int numero, int anneeSortie, int idMedia, String synopsis, int nbrEpisode) throws SQLException {
			    Connection conn = null;
			    PreparedStatement ps = null;
			    try {
			        conn = Dbconnection.getConnection();
			        String query = "UPDATE SYSTEM.SEASON SET NUMB=?, START_YEAR=?, MEDIA_ID=?, SYNOPSIS=?, NBR_EPISODE=? WHERE ID=?";
			        ps = conn.prepareStatement(query);
			        ps.setInt(1, numero);
			        ps.setInt(2, anneeSortie);
			        ps.setInt(3, idMedia);
			        ps.setString(4, synopsis);
			        ps.setInt(5, nbrEpisode);
			        ps.setInt(6, id);
			        ps.executeUpdate();
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        // fermer les ressources
			        try {
			            if (ps != null) ps.close();
			            if (conn != null) conn.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			}
		 
		 public static Season getSeasonByIdAndNumber(int idMedia, int numero) throws SQLException {
			    Connection conn = null;
			    PreparedStatement ps = null;
			    ResultSet rs = null;
			    Season saison = null;
			    try {
			        conn = Dbconnection.getConnection();
			        String query = "SELECT * FROM SYSTEM.SEASON WHERE MEDIA_ID=? AND NUMB=?";
			        ps = conn.prepareStatement(query);
			        ps.setInt(1, idMedia);
			        ps.setInt(2, numero);
			        rs = ps.executeQuery();
			        if (rs.next()) {
			            int id = rs.getInt("ID");
			            int annne_sortie = rs.getInt("START_YEAR");
			            String synopsis = rs.getString("SYNOPSIS");
			            int nbr_episode = rs.getInt("NBR_EPISODE");
			            saison = new Season(id, numero, annne_sortie, idMedia, synopsis, nbr_episode);
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        // fermer les ressources
			        try {
			            if (rs != null) rs.close();
			            if (ps != null) ps.close();
			            if (conn != null) conn.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			    return saison;
			}
		 
		 
		 





		
}
