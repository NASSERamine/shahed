package Entities;

import java.util.Date;  
public class User extends Visiteur {

	public User(int id, String nom, String email, Date date_de_naissance, String password) {
		super(id, nom, email, date_de_naissance, password);
		// TODO Auto-generated constructor stub
	}

	



	public User() {
		
	}





	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", email=" + email + ", Date_de_naissance=" + Date_de_naissance
				+ ", Password=" + Password + "]";
	}
	
	

	


	

	
}