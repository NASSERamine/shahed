package Entities;

import java.sql.Date;

import javax.swing.Icon;

public class TvShow extends Media {
public TvShow(String nom1, Date annne_sortie, String langue, String pays_origine, Icon affiche, String genre,
			String relisateur, int nbre_seasons) {
		super(nom1, annne_sortie, langue, pays_origine, affiche, genre, relisateur);
		this.nbre_seasons = nbre_seasons;
	}

private int nbre_seasons;



public int getNbre_seasons() {
	return nbre_seasons;
}

public void setNbre_seasons(int nbre_seasons) {
	this.nbre_seasons = nbre_seasons;
}
}
