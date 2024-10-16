package Entities;

import java.util.Date;   
public class Actor extends Visiteur{

	public Actor(int id, String nom, String email, Date date_de_naissance, String password) {
		super(id, nom, email, date_de_naissance, password);
		// TODO Auto-generated constructor stub
	}
	
	public Actor() {
		
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", nom=" + nom + ", email=" + email + ", Date_de_naissance=" + Date_de_naissance
				+ ", Password=" + Password + "]";
	}
	
	

	
	

	


}
