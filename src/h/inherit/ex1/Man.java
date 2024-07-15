package h.inherit.ex1;

public class Man {
	private String name;
	
	public Man() {
		System.out.println("Man 기본 생성자 호출");
	}

	public Man(String name) {
		this.name = name;
		System.out.println("Man String name 생성자 호출");
	}
	
	public void tellYourName() {
		System.out.println("My name is " + this.name);
	}

	
}
