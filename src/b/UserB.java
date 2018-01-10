package b;

import java.sql.SQLException;

import da.UserDA;

public class UserB {
	private UserDA userDA ; 
	
	public UserB() {
		userDA = new UserDA() ; 
		
	}
	
	public boolean checkLogin(String username , String password) throws SQLException {
		return userDA.checkLogin(username, password) ; 
	}
}
