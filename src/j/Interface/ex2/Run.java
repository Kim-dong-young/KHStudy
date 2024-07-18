package j.Interface.ex2;

public class Run {
	/*
	   * 인터페이스
	   	- 추상 메소드 + 상수 필드로만 이루어진 클래스
	   	- 추상 메소드로 이루어져있기 때문에 객체를 직접 생성할 수 없다.
	   	- 참조변수로 사용은 가능하다.
	   
	   * 추상 메소드
	    - 미완성된 메소드( 구현부 { } 가 구현되어있지 않은 메소드 )
	    - 무조건 오버라이드 해야함
	 */
	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(5);
		shapes[1] = new Rectangle(3,4);
		
		
		/*
		 * 배열 또는 컬렉션에서 사용
		 * 처음부터 끝까지 무조건 모두 탐색
		 * 해당배열의 인덱스 안의 값이 하나씩 왼쪽에 있는 값에 대입되어 반복문 실행
		 */
		
		for(Shape shape : shapes) {
			System.out.println("도형의 넓이 : " + shape.calculateArea());
		}
	}
}
