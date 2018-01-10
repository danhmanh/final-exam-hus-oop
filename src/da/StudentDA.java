package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import e.Student;

public class StudentDA {
	private Connection connection ; 
	
	public StudentDA() {
		try {
			connection = MyConnection.getConnection() ;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public List<Student> getAllStudent() throws SQLException {
		List<Student> students = new ArrayList<>() ; 
		String query = "SELECT * FROM sinhvien" ; 
		Statement statement =connection.createStatement() ; 
		ResultSet resultSet = statement.executeQuery(query) ; 
		while(resultSet.next()) {
			Student temp = new Student(resultSet.getInt(1) , resultSet.getString(2) , resultSet.getDouble(3) , resultSet.getString(4)) ; 
			students.add(temp) ; 
		}
		
		return students ; 
	}
	
	public boolean deleteStudent(String id) throws SQLException {
		String query = "DELETE FROM sinhvien WHERE id = ?" ; 
		PreparedStatement preparedStatement = connection.prepareStatement(query) ; 
		preparedStatement.setString(1, id);
		
		int res = preparedStatement.executeUpdate() ; 
		
		
		return res > 0 ; 
	}
	
	public boolean addStudent(String name , double score , String gender) throws SQLException {
		String query = "INSERT INTO sinhvien(id , name , score , gender) VALUES(NULL , ? , ?  , ?)" ; 
		PreparedStatement preparedStatement = connection.prepareStatement(query) ; 
		
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, score);
		preparedStatement.setString(3, gender);
		
		int res = preparedStatement.executeUpdate() ; 
		
		
		return res > 0 ; 
	}
	
	public boolean updateStudent(String id , String name , double score , String gender) throws SQLException {
		String query = "UPDATE sinhvien SET name = ? , score = ? , gender = ?  WHERE id = ?" ; 
		PreparedStatement preparedStatement = connection.prepareStatement(query) ; 
		preparedStatement.setString(4, id);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, score);
		preparedStatement.setString(3, gender);
		
		int res = preparedStatement.executeUpdate() ; 
		return res > 0 ; 
	}
	
	
	
	
	
}
