package Controller;

import java.sql.SQLException;

import Services.SynopsisServices;

public class SynopsisController {
	SynopsisServices synopsisservice = new SynopsisServices();
	
	 
		public  boolean ajouter_synopsis (String text,String url_vid ) {
			 return synopsisservice.ajouter_synopsis(text, url_vid);
		 }
		
		
		 public  int getID( String text,String url_vid ) throws SQLException {
			 return synopsisservice.getID(text, url_vid);
		 }
		 
		 
		 public  boolean Modifier_synopsis(String synopsis_text, String synopsis_url_video) {
			 return synopsisservice.Modifier_synopsis(synopsis_text, synopsis_url_video);
		 }
		 
		 public  boolean supprimersynopsis(int id) {
			 return synopsisservice.supprimersynopsis(id);
		 }

}
