package b;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import da.StudentDA;
import e.Student;

public class StudentB {
	private StudentDA studentDA ; 
	
	public StudentB() {
		studentDA = new StudentDA() ; 
	}
	
	
	public DefaultTableModel getAllStudent() throws SQLException {
		DefaultTableModel model = new DefaultTableModel() ; 
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Score");
		model.addColumn("Gender");
		
		List<Student> students = studentDA.getAllStudent() ; 
		
		for (Student student : students) {
			String[] rows = new String[4] ; 
			
			rows[0] = student.getId() + ""; 
			rows[1] = student.getName() ;
			rows[2] = student.getScore() + "" ; 
			rows[3] = student.getGender() ; 
			
			model.addRow(rows);
		}
		
		return model ; 
	}
	
	public boolean addStudent(String name , double score , String gender) throws SQLException {
		return studentDA.addStudent(name, score, gender) ; 
	}
	
	public boolean updateStudent(String id  , String name , double score , String gender) throws SQLException {
		return studentDA.updateStudent(id, name, score, gender) ; 
	}
	
	public boolean deleteStudent(String id) throws SQLException {
		return studentDA.deleteStudent(id) ; 
	}
}
