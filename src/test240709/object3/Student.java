package test240709.object3;

public class Student {
	
	private String name;
	private double height;
	
	private int grade;
	private int classroom;

	private char gender;
	
	public Student() { }

	public Student(String name, double height, int grade, int classroom, char gender) {
		super();
		this.name = name;
		this.height = height;
		this.grade = grade;
		this.classroom = classroom;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void information() {
		System.out.println("이름 : " + this.getName());
		System.out.println("성별 : " + this.getGender());
		System.out.println("키 : " + this.getHeight());
		System.out.println("반 : " + this.getClassroom());
		System.out.println("점수 : " + this.getGrade());
	}
	
	
}
