package Entities;

import java.sql.Date;

import javax.swing.Icon;

public class Media {
public Media(String nom1, Date annne_sortie, String langue, String pays_origine, Icon affiche, String genre,
			String relisateur) {
		super();
		this.nom1 = nom1;
		this.annne_sortie = annne_sortie;
		this.langue = langue;
		this.pays_origine = pays_origine;
		this.affiche = affiche;
		this.genre = genre;
		this.relisateur = relisateur;
	}
public String getNom1() {
	return nom1;
}
public void setNom1(String nom1) {
	this.nom1 = nom1;
}
public Date getAnnne_sortie() {
	return annne_sortie;
}
public void setAnnne_sortie(Date annne_sortie) {
	this.annne_sortie = annne_sortie;
}
public String getLangue() {
	return langue;
}
public void setLangue(String langue) {
	this.langue = langue;
}
public String getPays_origine() {
	return pays_origine;
}
public void setPays_origine(String pays_origine) {
	this.pays_origine = pays_origine;
}
public Icon getAffiche() {
	return affiche;
}
public void setAffiche(Icon affiche) {
	this.affiche = affiche;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getRelisateur() {
	return relisateur;
}
public void setRelisateur(String relisateur) {
	this.relisateur = relisateur;
}
protected String nom1;
protected Date annne_sortie;
protected String langue;
protected String pays_origine;
protected Icon affiche;
protected String genre;
protected String relisateur;

}
