package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection connection =null ; 
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection == null) {
			Class.forName("com.mysql.jdbc.Driver") ;
			connection = DriverManager.getConnection("jdbc:mysql://localhost/oop" , "root" , "") ; 
			
		}
		
		return connection ; 
	}
}
