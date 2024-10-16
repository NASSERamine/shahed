package Services;

import java.util.ArrayList;
import Dao.MediaDao;
import Entities.Film;
import Entities.Media;
import Entities.Serie;

public class MediaServices {
	MediaDao mediadao = new MediaDao();
	
	/**public ArrayList<Media> geturlmedia(){
		return mediadao.geturlmedia();
		
	}**/
	

	public  boolean ajouterSerie(String name, int year, String language, String country, String image_url, String synopsis, String genre, int nbr_saison, String type, int producer_id) {
		return mediadao.ajouterSerie(name, year, language, country, image_url, synopsis, genre, nbr_saison, type, producer_id);
	}
	
	 
	public  boolean ajouterFilm(String name, int year, String language, String country, String image_url, String synopsis, String genre, String duree , String type, int producer_id) {
		return mediadao.ajouterFilm(name, year, language, country, image_url, synopsis, genre, duree, type, producer_id);
	}
	public  Media getmedia(String name) {
		return mediadao.getmedia(name);
	}
	
	 public  Serie getSerie(String name) {
		return  mediadao.getSerie(name);
	 }
	
	public  boolean chekMedia(String nom) {
		return mediadao.chekMedia(nom);
	}
	
	  public  Film getFilm(String name) {
		  return mediadao.getFilm(name);
	  }
	
	/**public  boolean ModifierSerie(int id,String name,int year, String language , String country, String image_url,String synopsis_text, String synopsis_url_video,String genre ,int nbre_de_saison ) {
		return mediadao.ModifierSerie(id, name, year, language, country, image_url, synopsis_text, synopsis_url_video, genre, nbre_de_saison);
		
	}
	
	
	
	
	public  boolean ModifierFilm(int id,String name,int year, String language , String country, String image_url,String synopsis_text, String synopsis_url_video,String genre ,String duree ) {
	  return mediadao.ModifierFilm(id, name, year, language, country, image_url, synopsis_text, synopsis_url_video, genre, duree);
	}
	
	public Serie rechercherSerie(String name) {
		return mediadao.rechercherSerie(name);
		
	}
	public Film rechercherFilm(String name) {
		return mediadao.rechercherFilm(name);
		
	}
	
	
	public boolean supprimerSerie(int id) {
		return mediadao.supprimerSerie(id);
	}

	public boolean supprimerfilm(int id) {
		return mediadao.supprimerfilm(id);
	}
	
	
	

	
	**/

}
