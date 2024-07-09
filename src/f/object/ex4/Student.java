package f.object.ex4;

// 이름 나이 수학점수 영어점수 국어점수를 데이터로 가지고 있는 개체를 만들어라
// 데이터는 직접 접근을 허용하지 않고, 모두 간접적으로 set/get을 해줄 수 있도록 작성해라
// 모든 데이터를 매개변수로 받아 초기화하면서 객체를 생성할 수 있는 생성자를 작성

public class Student {

	private String name;

	private int age;
	private int mathScore;
	private int engScore;
	private int korScore;
	
	public Student() {};
	
	// Alt + Shift + S 누른 뒤, O => 생성자 자동생성 가능
	public Student(String name, int age, int mathScore, int engScore, int korScore) {
		super();
		this.name = name;
		this.age = age;
		this.mathScore = mathScore;
		this.engScore = engScore;
		this.korScore = korScore;
	}

	// Alt + Shift + S 누른 뒤, R => getter / setter 자동생성
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		if(age < 1) {
			this.age = 1;
			return;
		}
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}

	public void setMathScore(int mathScore) {
		if(mathScore < 0) {
			this.mathScore = 0;
			return;
		}
		this.mathScore = mathScore;
	}
	
	public int getMathScore() {
		return this.mathScore;
	}

	public void setEngScore(int engScore) {
		if(engScore < 0) {
			this.engScore = 0;
			return;
		}
		this.engScore = engScore;
	}
	
	public int getEngScore() {
		return this.engScore;
	}

	public void setKorScore(int korScore) {
		if(korScore < 0) {
			this.korScore = 0;
			return;
		}
		this.korScore = korScore;
	}
	
	public int getKorScore() {
		return this.korScore;
	}
	
	public double getAverageScore() {
		double average = ( this.engScore + this.korScore + this.mathScore ) / 3.0;
		return average;
	}
	
	public void printAverageScore() {
		System.out.println(this.getName() + "님의 평균 : " + (int)this.getAverageScore());
	}

}
