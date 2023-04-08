package Entities;

import java.sql.Date;

import javax.swing.Icon;

public class Film extends Media {
public Film(String nom1, Date annne_sortie, String langue, String pays_origine, Icon affiche, String genre,
			String relisateur) {
		super(nom1, annne_sortie, langue, pays_origine, affiche, genre, relisateur);
		// TODO Auto-generated constructor stub
	}

private String duree;

public String getDuree() {
	return duree;
}

public void setDuree(String duree) {
	this.duree = duree;
}
}
