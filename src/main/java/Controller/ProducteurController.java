package Controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import Entities.Producteur;
import Services.ProducteurServices;

public class ProducteurController {
	ProducteurServices producteurservice = new ProducteurServices();
	
	public  boolean checkProducteur(String EMAIL, String PASSWORD) {
		return producteurservice.checkProducteur(EMAIL, PASSWORD);
	}

	public boolean signup(String username, String password, String email, LocalDate date_brith) throws SQLException {
		return producteurservice.signup(username, password, email, date_brith);
	}


	public   Producteur getproducteur(String email) throws SQLException {
		return producteurservice.getproducteur(email);
	}

	public  boolean updateproducteur(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
		return producteurservice.updateproducteur(username, newPassword, newEmail, newBirthdate);
	}


	public boolean updateProducteur(Producteur producteur) throws SQLException {
		return producteurservice.updateProducteur(producteur);
	}

}
