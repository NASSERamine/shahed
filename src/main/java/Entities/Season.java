package Entities;

import java.sql.Date;

public class Season {
private int num;
private Date date_debut;
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public Date getDate_debut() {
	return date_debut;
}
public void setDate_debut(Date date_debut) {
	this.date_debut = date_debut;
}
public int getNbre_episodes() {
	return nbre_episodes;
}
public void setNbre_episodes(int nbre_episodes) {
	this.nbre_episodes = nbre_episodes;
}
public Season(int num, Date date_debut, int nbre_episodes) {
	super();
	this.num = num;
	this.date_debut = date_debut;
	this.nbre_episodes = nbre_episodes;
}
private int nbre_episodes;

}
