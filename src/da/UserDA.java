package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDA {
	private Connection connection ; 
	
	public UserDA() {
		try {
			connection = MyConnection.getConnection() ;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public boolean checkLogin(String username , String password) throws SQLException {
		String query = "SELECT * FROM user WHERE username = ? AND password = ?" ; 
		PreparedStatement preparedStatement = connection.prepareStatement(query) ; 
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		
		ResultSet resultSet = preparedStatement.executeQuery() ; 
		
		if(resultSet.next()) {
			return true ; 
		} else return false ; 
	}
}
