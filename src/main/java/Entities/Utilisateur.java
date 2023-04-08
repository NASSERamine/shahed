package Entities;

import java.util.ArrayList;
import java.util.Date;


public class Utilisateur {
	
	private String nom;
	private String email;
	private Date date_naissance;
	private ArrayList<String> preference ;
	
	public Utilisateur(String nom, String email, Date date_naissance, ArrayList<String> preference) {
		super();
		this.nom = nom;
		this.email = email;
		this.date_naissance = date_naissance;
		this.preference = preference;
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

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public ArrayList<String> getPreference() {
		return preference;
	}

	public void setPreference(ArrayList<String> preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", email=" + email + ", date_naissance=" + date_naissance + ", preference="
				+ preference + "]";
	}
	
	
	
	
	
	
	

}
