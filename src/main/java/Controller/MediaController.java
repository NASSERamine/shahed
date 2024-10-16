package Controller;

import java.util.List;

import Entities.Film;
import Entities.Media;
import Entities.Serie;
import Services.MediaServices;

public class MediaController {
	MediaServices mediaservice =new MediaServices();
	
	/**public List<Media> geturlmedia(){
		return mediaservice.geturlmedia();
		
	}**/
	
	
	public  boolean ajouterSerie(String name, int year, String language, String country, String image_url, String synopsis, String genre, int nbr_saison, String type, int producer_id) {
		return mediaservice.ajouterSerie(name, year, language, country, image_url, synopsis, genre, nbr_saison, type, producer_id);
	}
	public  boolean ajouterFilm(String name, int year, String language, String country, String image_url, String synopsis, String genre, String duree , String type, int producer_id) {
		return mediaservice.ajouterFilm(name, year, language, country, image_url, synopsis, genre, duree, type, producer_id);
	}
	

	public  Media getmedia(String name) {
		return mediaservice.getmedia(name);
	}
	
	public  boolean chekMedia(String nom) {
		return mediaservice.chekMedia(nom);
	}
	
	public  Serie getSerie(String name) {
		return  mediaservice.getSerie(name);
	 }
	
	  public  Film getFilm(String name) {
		  return mediaservice.getFilm(name);
	  }
	




/**public boolean ajouterFilm(String name, int year, String language, String country, String image_url,String synopsis_text, String synopsis_url_video, String genre, String duree, String type) {
return mediaservice.ajouterFilm(name, year, language, country, image_url, synopsis_text,
synopsis_url_video, genre, duree, type);
}





public boolean modifierFilm(int id, String name, int year, String language, String country, String image_url, String synopsis_text, String synopsis_url_video, String genre, String duree) {
return mediaservice.ModifierFilm(id, name, year, language, country, image_url, synopsis_text,synopsis_url_video, genre, duree);
}


public Serie rechercherSerie(String name) {
return mediaservice.rechercherSerie(name);
}


public Film rechercherFilm(String name) {
return mediaservice.rechercherFilm(name);
}


public boolean supprimerSerie(int id) {
return mediaservice.supprimerSerie(id);
}**/

}
