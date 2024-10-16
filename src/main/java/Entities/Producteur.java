package Entities;

import java.util.Date;

public class Producteur extends Visiteur {

	public Producteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producteur(int id, String nom, String email, Date date_de_naissance, String password) {
		super(id, nom, email, date_de_naissance, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Producteur [id=" + id + ", nom=" + nom + ", email=" + email + ", Date_de_naissance=" + Date_de_naissance
				+ ", Password=" + Password + "]";
	}

	
	
	
	
	

}
