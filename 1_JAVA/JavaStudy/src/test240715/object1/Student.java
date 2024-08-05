package test240715.object1;

public class Student {
	private String name;
	private int classRoom;
	private double javaScore;
	private double sqlScore;
	private double practiceScore;
	
	public Student() { }
	
	public Student(String name, int classRoom, double javaScore, double sqlScore, double practiceScore) {
		this.name = name;
		this.classRoom = classRoom;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
		this.practiceScore = practiceScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public double getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(double javaScore) {
		this.javaScore = javaScore;
	}

	public double getSqlScore() {
		return sqlScore;
	}

	public void setSqlScore(double sqlScore) {
		this.sqlScore = sqlScore;
	}

	public double getPracticeScore() {
		return practiceScore;
	}

	public void setPracticeScore(double practiceScore) {
		this.practiceScore = practiceScore;
	}

	@Override
	public String toString() {
		return  classRoom + "반 " + name + "학생 " + javaScore + "점 "
				+ sqlScore + "점 " + practiceScore + "점";
	}
	
	public boolean isPassed() {
		boolean isScoreOverCutline = (javaScore >= 50 && sqlScore >= 50 && practiceScore >= 50) ? true : false;
		boolean isAvgOverCutline = ( (javaScore +sqlScore + practiceScore) / 3 >= 60) ? true : false;
		
		return isScoreOverCutline && isAvgOverCutline ? true : false;
	}
	
	public void reTest() {
		this.setJavaScore((int)(Math.random() * 101));
		this.setSqlScore((int)(Math.random() * 101));
		this.setPracticeScore((int)(Math.random() * 101));
	}
	
}
