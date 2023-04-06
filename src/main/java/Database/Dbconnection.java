package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	 private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	    private static final String USERNAME = "system";
	    private static final String PASSWORD = "nasser";
	    
	    public static Connection getConnection() throws SQLException {
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        } catch (ClassNotFoundException ex) {
	            throw new SQLException("Oracle JDBC Driver not found", ex);
	        }
	    }

}
