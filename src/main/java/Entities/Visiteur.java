package Entities;

import java.util.Date;        
public class Visiteur {
protected int id;
protected String nom;
protected String email;
protected Date Date_de_naissance;
protected String Password ;

public static Visiteur us = new Visiteur();

public Visiteur(int id, String nom, String email, Date date_de_naissance, String password) {
	super();
	this.id = id;
	this.nom = nom;
	this.email = email;
	Date_de_naissance = date_de_naissance;
	Password = password;
}
public Visiteur() {
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getDate_de_naissance() {
	return Date_de_naissance;
}

public void setDate_de_naissance(Date date_de_naissance) {
	Date_de_naissance = date_de_naissance;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}


public Actor getActorInstance() {
    if (us instanceof Actor) {
        return (Actor) us;
    }
    return null; // ou lancez une exception appropriée ici
}

public User getUserInstance() {
    if (us instanceof Actor) {
        return (User) us;
    }
    return null; // ou lancez une exception appropriée ici
}



public User geUserInstance(Visiteur us) {
    return (User) us;
}

@Override
public String toString() {
	return "Visiteur [id=" + id + ", nom=" + nom + ", email=" + email + ", Date_de_naissance=" + Date_de_naissance
			+ ", Password=" + Password + "]";
}





}

