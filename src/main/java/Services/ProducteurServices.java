package Services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import Dao.ProducteurDao;
import Entities.Producteur;

public class ProducteurServices {
	
ProducteurDao producteurdao= new ProducteurDao();



public static boolean checkProducteur(String EMAIL, String PASSWORD) {
	return ProducteurDao.checkProducteur(EMAIL, PASSWORD);
}

public boolean signup(String username, String password, String email, LocalDate date_brith) throws SQLException {
	return producteurdao.signup(username, password, email, date_brith);
}


public   Producteur getproducteur(String email) throws SQLException {
	return producteurdao.getproducteur(email);
}

public  boolean updateproducteur(String username, String newPassword, String newEmail, Date newBirthdate) throws SQLException {
	return producteurdao.updateproducteur(username, newPassword, newEmail, newBirthdate);
}


public boolean updateProducteur(Producteur producteur) throws SQLException {
	return producteurdao.updateProducteur(producteur);
}


}
