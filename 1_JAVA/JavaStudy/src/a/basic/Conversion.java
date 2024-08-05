package a.basic;

public class Conversion {
	/*
	 * 형변환 : 자료형을 다른 자료형으로 변경해 주는 것
	 * 
	 * 자동 형변환
	 * 두개 이상의 자료형을 연산할 때 하나의 자료형으로 일치시켜야 연산이 가능하다.
	 * 따라서, 데이터 손식이 적은 방향으로 컴파일러가 직접 형 변환을 해주는 것.
	 * 즉, 형변환할 변수가 형변환될 자료형보다 크기가 작을 경우, 자동 형변환 된다
	 * 
	 * 명시적 형변환(강제)
	 * 값의 범위가 큰 자료형을 값의 범위가 작은 자료형으로 변환할 때, 값의 손실이 일어난다
	 * 따라서 컴파일러가 자동으로 형변환 해주지 않기 때문에, 프로그래머가 책임지고 명시적으로 진행한다.
	 */
	public static void main(String[] args) {
		double pi = 3.1415;
		int number = (int)pi;
		
		System.out.println(number);
		
		long num1 = 3000000007L;
		int number2 = (int)num1;
		System.out.println(number2); // 큰 자료형에서 작은자료형으로 변환하면, 부호비트가 바뀔 수 있다.
		
		short num2 = 1;
		short num3 = 2;
		short num4 = (short)(num2 + num3); // short, byte등을 + 연산하면 int로 자동 형변환된다.
		//비슷한 예시로 문자열과 숫자를 덧셈하면 모두 문자열로 형변환 된다.
	}
}
