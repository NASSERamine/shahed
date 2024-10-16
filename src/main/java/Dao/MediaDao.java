package Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Dbconnection;
import Entities.Film;
import Entities.Media;
import Entities.Serie;

public class MediaDao {
	
/**	private static SynopsDao synopsisdao = new SynopsDao();

   public static ArrayList<Media> geturlmedia() {
        ArrayList<Media> mediaList = new ArrayList<>();
        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT IMAGE_URL FROM SYSTEM.MEDIA");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String urlaffiche = rs.getString(1);
                Media media = new Media(urlaffiche);
                mediaList.add(media);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mediaList;
    }**/
    
  //ajouter serie 
	 
    public static boolean ajouterSerie(String name, int year, String language, String country, String image_url, String synopsis, String genre, int nbr_saison, String type, int producer_id) {
        boolean exists = false;

        try (Connection conn = Dbconnection.getConnection()) {
            conn.setAutoCommit(false);

            // Vérifier que le producteur avec l'ID donné existe dans la table PRODUCER
            String checkProducerQuery = "SELECT ID FROM SYSTEM.PRODUCER WHERE ID = ?";
            try (PreparedStatement checkProducerStatement = conn.prepareStatement(checkProducerQuery)) {
                checkProducerStatement.setInt(1, producer_id);
                try (ResultSet rs = checkProducerStatement.executeQuery()) {
                    if (!rs.next()) {
                        System.err.println("Error: Producer with ID " + producer_id + " not found in database.");
                        return false;
                    }
                }
            } catch (SQLException ex) {
                conn.rollback();
                System.err.println("Error while checking producer in database: " + ex.getMessage());
                ex.printStackTrace();
                return false;
            }

            // Insérer la série dans la table MEDIA
            String query = "INSERT INTO SYSTEM.MEDIA (NAME, YEAR, LANGUAGE, COUNTRY, PRODUCER_ID, IMAGE_URL, SYNOPSIS, GENRE, NBR_SAISON, TYPE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, name);
                ps.setInt(2, year);
                ps.setString(3, language);
                ps.setString(4, country);
                ps.setInt(5, producer_id);
                ps.setString(6, image_url);
                ps.setString(7, synopsis);
                ps.setString(8, genre);
                ps.setInt(9, nbr_saison);
                ps.setString(10, type); 

                int rowsUpdated = ps.executeUpdate();

                if (rowsUpdated > 0) {
                    exists = true;
                }
            } catch (SQLException ex) {
                conn.rollback();
                System.err.println("Error while inserting media into database: " + ex.getMessage());
                ex.printStackTrace();
            }

            conn.commit();
        } catch (SQLException ex) {
            System.err.println("Error while connecting to database: " + ex.getMessage());
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            System.err.println("Error while inserting media into database: some parameters are null");
            ex.printStackTrace();
        }

        return exists;
    }

  	//modifier serie 
  	public static boolean ModifierSerie(int id,String name,int year, String language , String country, String image_url,String synopsis, String genre ,int nbr_saison ,String type,int producer_id) {
  		

  		 Connection conn = null;
          PreparedStatement ps = null;
          
          boolean mediaUpdated = false;
          try {
              conn = Dbconnection.getConnection();
              String query = "UPDATE INTO SYSTEM.MEDIA SET NAME=? ,YEAR=?,LANGUAGE=?, COUNTRY=?, IMAGE_URL=?,PRODUCER_ID=?, SYNOPSIS=?,GENRE=?,NBR_SAISON=? WHERE ID=? and TYPE=?  " ;
              ps = conn.prepareStatement(query);
              ps.setString(1, name);
              ps.setInt(2, year);
              ps.setString(3, language);
              ps.setString(4, country);
              ps.setString(5, image_url);
              ps.setInt(6, producer_id);
              ps.setString(7, synopsis);
              ps.setString(8, genre);
              ps.setInt(9, nbr_saison);
              ps.setInt(10,id);
              ps.setString(11, type);
              int rowsUpdated = ps.executeUpdate();  
              if(rowsUpdated > 0) {
                  mediaUpdated = true;
              }
          } catch (SQLException ex) {
              ex.printStackTrace();
          } finally {
              // fermer les ressources
              try {
                 
                  if(ps != null) ps.close();
                  if(conn != null) conn.close();
              } catch (SQLException ex) {
                  ex.printStackTrace();
              }
          }

        return mediaUpdated;   
  	}
  	
  	
  	
  	//ajouter film
  	public static boolean ajouterFilm(String name, int year, String language, String country, String image_url, String synopsis, String genre, String duree , String type, int producer_id) {
  		  boolean exists = false;

  	        try (Connection conn = Dbconnection.getConnection()) {
  	            conn.setAutoCommit(false);
  	           

  	            // Insert media into database
  	            String query = "INSERT INTO SYSTEM.MEDIA (NAME, YEAR, LANGUAGE, COUNTRY, PRODUCER_ID, IMAGE_URL,SYNOPSIS,GENRE,DUREE, TYPE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  	            try (PreparedStatement ps = conn.prepareStatement(query)) {
  	                ps.setString(1, name);
  	                ps.setInt(2, year);
  	                ps.setString(3, language);
  	                ps.setString(4, country);
  	                ps.setInt(5, producer_id);
  	                ps.setString(6, image_url);
  	                ps.setString(7, genre);
  	                ps.setString(8, synopsis);
  	                ps.setString(9, duree);
  	                ps.setString(10, type); 

  	                int rowsUpdated = ps.executeUpdate();

  	                if (rowsUpdated > 0) {
  	                    exists = true;
  	                }
  	            } catch (SQLException ex) {
  	                conn.rollback();
  	                System.err.println("Error while inserting media into database: " + ex.getMessage());
  	                ex.printStackTrace();
  	            }

  	            conn.commit();
  	        } catch (SQLException ex) {
  	            System.err.println("Error while connecting to database: " + ex.getMessage());
  	            ex.printStackTrace();
  	        } catch (NullPointerException ex) {
  	            System.err.println("Error while inserting media into database: some parameters are null");
  	            ex.printStackTrace();
  	        }

  	        return exists;
  	    }
  	
  	//modifier film
  public static boolean ModifierFilm(int id,String name,int year, String language , String country, String image_url,String synopsis,String genre ,String duree, int producer_id,String type) {
  		
  	
  		 Connection conn = null;
          PreparedStatement ps = null;
          boolean mediaUpdated = false;
       
          try {
              conn = Dbconnection.getConnection();
              String query = "UPDATE INTO SYSTEM.MEDIA SET NAMEe=? ,YEAR=?,LANGUAGE=?, COUNTRY=?, IMAGE_URL=?,PRODUCER_ID=?, SYNOPSIS=?,GENRE=?,NBR_SAISON=?,DUREE=? WHERE ID=? AND TYPE=? " ;
              ps = conn.prepareStatement(query);
              ps.setString(1, name);
              ps.setInt(2, year);
              ps.setString(3, language);
              ps.setString(4, country);
              ps.setString(5, image_url);
              ps.setInt(6, producer_id);
              ps.setString(7, synopsis);
              ps.setString(8, genre);
              ps.setString(9, duree);
              ps.setInt(10,id);
              ps.setString(11, type);
              
              int rowsUpdated = ps.executeUpdate();  
              if(rowsUpdated > 0) {
                  mediaUpdated = true;
              }
          } catch (SQLException ex) {
              ex.printStackTrace();
          } finally {
              // fermer les ressources
              try {
                 
                  if(ps != null) ps.close();
                  if(conn != null) conn.close();
              } catch (SQLException ex) {
                  ex.printStackTrace();
              }
          }
          return mediaUpdated;
  }
  

	
  public static Media getmedia(String name) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.MEDIA WHERE NAME=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, name);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("ID");
	            String nom1 = rs.getString("NAME");
	            int annee_sortie = rs.getInt("YEAR");
	            String langue = rs.getString("LANGUAGE");
	            String pays_origine = rs.getString("COUNTRY");
	            int id_producer = rs.getInt("PRODUCER_ID");
	            String image_url= rs.getString("IMAGE_URL");
	            String type = rs.getString("TYPE");
	            String genre = rs.getString("GENRE");
	            String synopsis = rs.getString("SYNOPSIS");
	            int nbre_vu = rs.getInt("NBR_VU");
	            int nbre_votant = rs.getInt("NBR_VOTTANT");
	           
	            // Créer un objet Serie avec les valeurs récupérées du ResultSet
	           Media media = new Media(id, nom1, annee_sortie, langue, pays_origine, genre, id_producer, genre, synopsis, type, nbre_vu, nbre_votant);
	           return media;
	        } else {
	            // S'il n'y a aucun résultat, retourner null
	            return null;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Toujours retourner quelque chose en cas d'erreur, dans ce cas null
	        return null;
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
	}
  
  public static Serie getSerie(String name) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.MEDIA WHERE NAME=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, name);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("ID");
	            String nom1 = rs.getString("NAME");
	            int annee_sortie = rs.getInt("YEAR");
	            String langue = rs.getString("LANGUAGE");
	            String pays_origine = rs.getString("COUNTRY");
	            int id_producer = rs.getInt("PRODUCER_ID");
	            String image_url= rs.getString("IMAGE_URL");
	            String type = rs.getString("TYPE");
	            String genre = rs.getString("GENRE");
	            String synopsis = rs.getString("SYNOPSIS");
	            int nbre_vu = rs.getInt("NBR_VU");
	            int nbre_votant = rs.getInt("NBR_VOTTANT");
	            int nbr_saison = rs.getInt("NBR_SAISON");
	           
	           

	            // Créer un objet Serie avec les valeurs récupérées du ResultSet
	           Serie serie = new Serie(id, nom1, annee_sortie, langue, pays_origine, genre, id_producer, image_url, synopsis, type, nbre_vu, nbre_votant, nbr_saison);
	            return serie ;
	            
	        } else {
	            // S'il n'y a aucun résultat, retourner null
	            return null;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Toujours retourner quelque chose en cas d'erreur, dans ce cas null
	        return null;
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
	}

  public static Film getFilm(String name) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.MEDIA WHERE NAME=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, name);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("ID");
	            String nom1 = rs.getString("NAME");
	            int annee_sortie = rs.getInt("YEAR");
	            String langue = rs.getString("LANGUAGE");
	            String pays_origine = rs.getString("COUNTRY");
	            int id_producer = rs.getInt("PRODUCER_ID");
	            String image_url= rs.getString("IMAGE_URL");
	            String type = rs.getString("TYPE");
	            String genre = rs.getString("GENRE");
	            String synopsis = rs.getString("SYNOPSIS");
	            int nbre_vu = rs.getInt("NBR_VU");
	            int nbre_votant = rs.getInt("NBR_VOTTANT");
	            String dure = rs.getString("DUREE");
	           
	            // Créer un objet Serie avec les valeurs récupérées du ResultSet
	        Film film = new Film(id, nom1, annee_sortie, langue, pays_origine, genre, id_producer, image_url, synopsis, type, nbre_vu, nbre_votant, dure)  ;
	       return film;
	        } else {
	            // S'il n'y a aucun résultat, retourner null
	            return null;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Toujours retourner quelque chose en cas d'erreur, dans ce cas null
	        return null;
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
	}
  


  public static boolean chekMedia(String nom) {
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      boolean mediaexists = false;

      try {
          conn = Dbconnection.getConnection();
          String query = "SELECT * FROM SYSTEM.MEDIA WHERE NAME=?";
          ps = conn.prepareStatement(query);
          ps.setString(1, nom);
          
          rs = ps.executeQuery();
          
          if(rs.next()) {
              mediaexists = true;
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

      return mediaexists;
  }
  

	
	/** rechercher film 	
	public static Film rechercherFilm(String name) {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
      
        
        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM SYSTEM.MEDIA WHERE NAME=?  ";
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()) {
             int id = rs.getInt("ID");
           	 String nom1= rs.getString("NAME");
           	  int annne_sortie=rs.getInt("YEAR");
           	 String langue=rs.getString("LANGUAGE");
           	  String pays_origine=rs.getString("COUNTRY");
           	  int realisateur = rs.getInt("PRODUCER_ID");
           	  String image_url=rs.getString("IMAGE_URL");
           	  String genre=rs.getString("GENRE");
           	  String synopsis = rs.getString("SYNOPSIS");
           	  String duree = rs.getString("DUREE");
           	  int nbre_vu=rs.getInt("NBR_VU");
           	  int nbre_vottant =rs.getInt("NBR_VOTTANT");
           	  
           	  
           	  
           	   return f;
           	 }
           else {
              	
                  return null;
           	 }
               
            }
         catch (SQLException ex) {
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
		return null;
	}
    
    
    **/
  
  
  
  public static List<Serie> getallSeriesParActor(String actorName) throws SQLException {
	    List<Serie> series = new ArrayList<>();
	    List<Integer> values = RoleDAO.getallidMedia(actorName);

	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM SYSTEM.MEDIA WHERE TYPE=? AND ID=?";

	    try {
	        conn = Dbconnection.getConnection();
	        ps = conn.prepareStatement(query);

	        for(int id : values) {
	            ps.setString(1, "SERIE");
	            ps.setLong(2, id);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                int idMedia = rs.getInt("ID");
	                String name = rs.getString("NAME");
	                int year = rs.getInt("YEAR");
	                String language = rs.getString("LANGUAGE");
	                String country = rs.getString("COUNTRY");
	                int producerId = rs.getInt("PRODUCER_ID");
	                String imageUrl = rs.getString("IMAGE_URL");
	                String synopsis = rs.getString("SYNOPSIS");
	                int nbSeasons = rs.getInt("NBR_SAISON");
	                String genre = rs.getString("GENRE");
	                int nbrVues = rs.getInt("NBR_VU");
	                int nbrVotants = rs.getInt("NBR_VOTTANT");

	                Serie serie = new Serie(idMedia, name, year, language, country, producerId,
	                        imageUrl, synopsis, genre, nbrVues, nbrVotants, nbSeasons);

	                series.add(serie);
	            }
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

	    return series;
	}
  
  
  public static List<Serie>  getallSeries( ) throws SQLException {
	    List<Serie> values = new ArrayList<>();

      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      try {
          conn = Dbconnection.getConnection();
          String query = "SELECT * FROM SYSTEM.MEDIA WHERE TYPE=?";
          ps = conn.prepareStatement(query);
          ps.setString(1, "SERIE");

          rs = ps.executeQuery();
          
          while (rs.next()) {
              int id =rs.getInt("ID");
              String name = rs.getString("NAME");

              int annne_sortie = rs.getInt("YEAR");
              String langue = rs.getString("LANGUAGE");
              String pays_origine = rs.getString("COUNTRY");
              int producteur_id =rs.getInt("PRODUCER_ID");
              String Image_url = rs.getString("IMAGE_URL");
              String type ="SERIE";

              String synopsis = rs.getString("SYNOPSIS");
              int nbre_seasons =rs.getInt("NBR_SAISON");
              String genre = rs.getString("GENRE");
             int nbr_vu = rs.getInt("NBR_VU");
             int nbr_vottant = rs.getInt("NBR_VOTTANT");


             Serie serie= new Serie( id,  name,  annne_sortie,  langue,  pays_origine,  genre,producteur_id,
          		   Image_url,  synopsis,type,    nbr_vu,  nbr_vottant,  nbre_seasons);

              values.add(serie);
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
  
  
  public static List<Media> getMediaByActorid(int id) throws SQLException {
	    List<Media> mediaList = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        conn = Dbconnection.getConnection();
	        String query = "SELECT * FROM SYSTEM.MEDIA WHERE ID IN (SELECT MEDIA_ID FROM SYSTEM.ROLE WHERE ACTOR_ID = ?)";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Media media = new Media(
	                rs.getInt("ID"),
	                rs.getString("NAME"),
	                rs.getInt("YEAR"),
	                rs.getString("LANGUAGE"),
	                rs.getString("COUNTRY"),
	                rs.getInt("PRODUCER_ID"),
	                rs.getString("IMAGE_URL"),
	                rs.getString("SYNOPSIS"),
	                rs.getString("GENRE"),
	                rs.getInt("NBR_SAISON"),
	                rs.getString("DUREE"),
	                rs.getString("TYPE"),
	                rs.getInt("NBR_VU"),
	                rs.getInt("NBR_VOTTANT")
	            );
	            mediaList.add(media);
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
	    return mediaList;
	}
  
  
  public static void UpdateVuMedia(int id, int x) throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        conn = Dbconnection.getConnection();
	        int y = x + 1;
	        String sql = "UPDATE SYSTEM.MEDIA SET NBR_VU = ? WHERE ID = ?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, y);
	        ps.setInt(2, id);
	        int rowsUpdated = ps.executeUpdate();

	        if (rowsUpdated > 0) {
	            System.out.println("La colonne NBR_VU a été mise à jour avec succès pour l'ID " + id);
	        } else {
	            System.out.println("Aucun enregistrement n'a été trouvé pour l'ID " + id);
	        }
	    } catch (SQLException ex) {
	        System.out.println("Une erreur s'est produite lors de la mise à jour de la colonne NBR_VU : " + ex.getMessage());
	    } finally {
	        // Fermer les ressources dans l'ordre inverse de leur ouverture
	        if (ps != null) {
	            ps.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	}


	 
  
  public static void UpdateNbreVOTANT( int id,int x) throws SQLException {
      
	        
      PreparedStatement ps = null;
	        Connection conn = null;
	        Boolean Exists=false;
	        ResultSet rs = null;


			try {
				conn = Dbconnection.getConnection();
				int y = x+1;
			String sql =  "UPDATE SYSTEM.MEDIA SET NBR_VOTTANT = ?  WHERE ID=? ";

				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, y);
		        ps.setInt(2, id);
		         int rowsUpdated = ps.executeUpdate();  
		         if(rowsUpdated > 0) {
		        	 Exists = true;
		         }
			} catch (SQLException ex) {
			System.out.println(ex.getMessage());
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
	 }
  
  public boolean updateSerie(Serie serie) throws SQLException {
      Connection conn = null;
      PreparedStatement ps = null;
      boolean updated = false;
      try {
          conn = Dbconnection.getConnection();
          ps = conn.prepareStatement("UPDATE SYSTEM.MEDIA SET NAME=?, YEAR=?, LANGUAGE=? , COUNTRY=?, PRODUCER_ID=?, IMAGE_URL=?, SYNOPSIS=?, GENRE=?, NBR_SAISON=?, NBR_VU=?, NBR_VOTTANT=? WHERE ID=?");
          ps.setString(1,serie.getNom1());
          ps.setInt(2, serie.getAnnne_sortie());
          ps.setString(3, serie.getLangue());
          ps.setString(4, serie.getPays_origine());
          ps.setInt(5, serie.getId_producer());
          ps.setString(6, serie.getUrlaffiche());
          ps.setString(7, serie.getSynopsis());
          ps.setString(8, serie.getGenre());
          ps.setInt(9, serie.getNbre_de_saison());
          ps.setInt(10, serie.getNbr_vu());
          ps.setInt(11, serie.getNbr_votant());

          ps.setInt(12, serie.getId()); // 
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
    
    
    
}








	
	
	

