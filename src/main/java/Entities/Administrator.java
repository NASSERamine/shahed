package Entities;

import java.sql.Date;

public class Administrator {
	private String nom;
	private String email;
	private Date Date_de_naissance;
	public Administrator(String nom, String email, Date date_de_naissance) {
		super();
		this.nom = nom;
		this.email = email;
		Date_de_naissance = date_de_naissance;
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
}
