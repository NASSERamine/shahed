package Services;

import java.sql.SQLException;

import Dao.SynopsDao;

public class SynopsisServices {
	SynopsDao synopsisdao = new SynopsDao();
	
	 
	public  boolean ajouter_synopsis (String text,String url_vid ) {
		 return synopsisdao.ajouter_synopsis(text, url_vid);
	 }
	
	
	 public  int getID( String text,String url_vid ) throws SQLException {
		 return synopsisdao.getID(text, url_vid);
	 }
	 
	 
	 public  boolean Modifier_synopsis(String synopsis_text, String synopsis_url_video) {
		 return synopsisdao.Modifier_synopsis(synopsis_text, synopsis_url_video);
	 }
	 
	 public  boolean supprimersynopsis(int id) {
		 return synopsisdao.supprimersynopsis(id);
	 }
	 
	 
	
	

}
