package h.inherit.override;

public class Run {
	/*
	 * 참조변수를 호출하면 자동으로 .toString()이 호출된다.
	 * 
	 * 오버라이딩 전 : Object 클래스의 toString() 실행 -> 전체 클래스명 + @ + 객체의 주소를 암호화한 16진수값
	 * 오버라이딩 후 : Man클래스(자식클래스)의 toString() 실행 -> 해당 객체가 가지고 있는 모든 필드의 값을 한 문자열로 반환
	 * 
	 * #오버라이딩
	 *  - 자식 클래스가 상속받고 있는 부모 클래스의 메소드를 재정의하는 것
	 *  - 부모가 제공하는 메소드를 자식이 일부 고쳐서 사용하겠다는 의미
	 *    자식객체를 통해 실행 시, 자식 메소드가 우선권을 가지고 있다.
	 *  
	 * #오버라이딩 성립 조건
	 *  - 부모 메소드명과 메소드명이 동일
	 *  - 매개변수의 갯수, 자료형, 순서 동일( 매개변수명 X )
	 *  - 반환형도 동일해야한다
	 *  - 부모 메소드의 접근제한자보다 범위가 같거나 커야한다.
	 */
	public static void main(String[] args) {
		Man m = new Man("Catherin");
		Object str = new String("안녕");
		// 객체가 생성되어 있다면, 객체정보를 보기 위해서 참조변수를 출력하는 순간
		// 무조건 Object의 toString 메소드가 호출된다.
		// 만약 객체없이 Man m; 과 같이 선언만 되있다면, toString은 호출할 수 없다.
		// 참조변수에 객체 주소가 없이 null이라면, null을 표시한다
		System.out.println(m);
		// 하지만 String은 객체를 출력해도 객체 정보가 아닌, 문자열이 나온다
		// Object 클래스의 toString을 오버라이딩하였기 때문이다.
		System.out.println(str.toString());
		
	}
}
