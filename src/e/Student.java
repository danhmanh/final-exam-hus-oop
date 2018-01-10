package e;

public class Student {
	private String name  , gender ;
	private int id ; 
	private double score  ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public Student(int id, String name, double score, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.gender = gender;
	} 
	
	
	
}
