package h.inherit.ex1;

public class BusinessMan extends h.inherit.ex1.Man{
	private String company;
	private String position;
	
	public BusinessMan() { }
	/*
	 * super() : 상속관계에서, 부모의 생성자를 호출하는 것. super()을 쓰지 않아도
	 * 			 기본적으로 호출이 된다.
	 * super(매개변수) 로 다른 생성자도 호출 가능하고, 
	 * super. 을 통해 this처럼 부모 클래스에 접근 가능하다.
	 */
	public BusinessMan(String name, String company, String position) {
		super(name);
		this.company = company;
		this.position = position;
	}
	
	public void tellYourInfo() {
		System.out.println("My company is "+ this.company);
		System.out.println("My Position is "+ this.position);
		super.tellYourName();
	}
	
	
}
