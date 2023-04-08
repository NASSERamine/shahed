package Entities;

import java.util.ArrayList;
import java.util.Date;


public class User extends Visiteur {
	
	
	private ArrayList<String> preference ;

	public User(ArrayList<String> preference) {
		super();
		this.preference = preference;
	}

	@Override
	public String toString() {
		return "User [preference=" + preference + ", nom=" + nom + ", email=" + email + ", Date_de_naissance="
				+ Date_de_naissance + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}