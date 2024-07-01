package b.operator;
import java.util.Scanner;

public class Operator4 {
	/*
	 * 비교연산자 / 관계연산자
	 * 두 값을 비교하는 연산자
	 * 비교연산자는 조건을 만족하면 true(참), 만족하지 않으면 false(거짓)를 반환
	 * 즉, 비교연산의 결과는 논리값
	 * 
	 * 대소비교 연산 : < > <= >=
	 * 동등비교 연산 : == !=
	 * 
	 * 원시타입 일반변수의 동등비교는 ==, != 등을 사용한다
	 * 그러나 클래스의 동등비교( ex) String )는 ==, != 등을 사용하면 주소를 비교한다.
	 * 이유는 참조변수(객체를 가리키는 변수)이기 때문에
	 * 따라서 String 비교시에는 => 문자열.equals(비교문자열);
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 25;
		
		System.out.println("a == b : "+ (a == b));
		System.out.println("a == b : "+ (a <= b));
		
		// 산술연산 + 비교연산
		System.out.println((a * 2) > (b / 5));
		
		System.out.println("a가 짝수인가? : "+ (a % 2 == 0));
		System.out.println("a가 홀수인가? : "+ (a % 2 != 0));
		
		/*
		// 두 수를 입력받아, 어떤 숫자가 더 큰지를 출력하는 프로그램
		// 첫 번째 정수 :
		// 두 번째 정수 :
		// 첫번째가 두번쨰보다 큽니다 : ( true / false )
		// 첫번째 정수는 짝수입니다 : ( true / false )
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		a = s.nextInt();
		s.nextLine();
		
		System.out.print("두 번째 정수 : ");
		b = s.nextInt();
		s.nextLine();
		
		System.out.println("첫번째 정수가 두번쨰보다 큽니다 : "+ (a > b));
		System.out.println("첫번째 정수는 짝수입니다 : "+(a % 2 == 0));
		*/
		
		//특이케이스 ( 문자와 숫자간의 대소비교 가능!! )
		System.out.println('A' + 0); // ascii code 65
		System.out.println('A' > 70);
		
		System.out.println((char)65); // A
		System.out.println((char)66); // B
		System.out.println((char)67); // C
		// 'A'~'Z' : 65 ~ 90
		// 'a'~'z' : 97 ~ 122
 		
	}
}
