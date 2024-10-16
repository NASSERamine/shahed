package Controller;

import Entities.Episode;

public class EpisodeSession {
	public static Episode episoderecherche ;

	public static Episode getEpisoderecherche() {
		return episoderecherche;
	}

	public static void setEpisoderecherche(Episode episoderecherche) {
		EpisodeSession.episoderecherche = episoderecherche;
	}
	

}
