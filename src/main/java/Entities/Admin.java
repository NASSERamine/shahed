package Entities;

import java.util.Date;

public class Admin {
	private int id ;
	private String nom;
	private String email;
	private Date birthdate ;
	private String password;
	public Admin(int id, String nom, String email, Date birthdate, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.birthdate = birthdate;
		this.password = password;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
