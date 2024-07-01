package c.control;

import java.util.Scanner;

public class B_switch1 {
	/*
	 * switch문도 if문과 동일하게 조건문이다.
	 * 
	 * 다만, if문과 차이점은
	 * > if문은 조건식을 자유롭게 기술 가능
	 *   switch문은 동등비교만 가능하다
	 * > 실행할 구문만 실행하고 자동으로 빠져나올 수 없다. ( 직접 빠져나오도록 설정 필요 )
	 * 
	 * [표현식]
	 * switch(비교대상){  // 비교대상은 정수, 문자, 문자열
	 * 		case 값1: 실행코드;
	 * 		case 값2: 실행코드;
	 * 		case 값3: 실행코드;
	 * 		default: 위의 모든 case와 일치하지 않으면 실행되는 코드;
	 * }
	 * 
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		/*
		 * 정수를 입력받아
		 * 1일 경우 "빨간색"
		 * 2일 경우 "파란색"
		 * 3일 경우 "초록색"
		 * 다른 경우 모두 "잘못 입력"
		 */
		
		System.out.print("정수 입력(1~3) : ");
		int num = s.nextInt();
		
		switch(num) {
			case 1:
				System.out.println("빨간색");
				break;
			case 2:
				System.out.println("파란색");
				break;
			case 3:
				System.out.println("초록색");
				break;
			default:
				System.out.println("잘못 입력");
				break;
		}
		
		if(num == 1) {
			System.out.println("빨");
		}
		else if(num == 2) {
			System.out.println("파");
		}
		else if(num == 3) {
			System.out.println("초");
		}
		else {
			System.out.println("잘못");
		}

	}

}
