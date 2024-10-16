package Controller;

import Entities.Film;
import Entities.Media;
import Entities.Serie;

public class MediaSession {
	
	private static  Media mediarecherche;
	private static Film filmrecherche;
	private static Serie serierecherche ;
	

	public static Film getFilmrecherche() {
		return filmrecherche;
	}

	public static void setFilmrecherche(Film filmrecherche) {
		MediaSession.filmrecherche = filmrecherche;
	}

	public static Serie getSerierecherche() {
		return serierecherche;
	}

	public static void setSerierecherche(Serie serierecherche) {
		MediaSession.serierecherche = serierecherche;
	}

	public static Media getMediarecherche() {
		return mediarecherche;
	}

	public static void setMediarecherche(Media mediarecherche) {
		MediaSession.mediarecherche = mediarecherche;
	}
	
	
	
	
	

}
