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
		

		 // 정수를 입력받아
		 // 1일 경우 "빨간색"
		 // 2일 경우 "파란색"
		 // 3일 경우 "초록색"
		 // 다른 경우 모두 "잘못 입력"

		
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

		*/
		
		/*
		// 과일을 구매하는 프로그램을 작성하여봅시다.
		// 구매하고자하는 과일을 입력하면
		// 그에맞는 가격이 출력되는 프로그램을 작성해 주세요
		
		// 구매하고자 하는 과일(사과(2000), 바나나(3000), 딸기(5000)) 입력 : xx
		// xx의 가격은 xxxx입니다 / 잘못입력하셨습니다.
		
		String fruit = s.next();
		int price = 0;
		
		switch(fruit.trim()) {
			case "사과":
				price = 2000;
				System.out.printf("%s의 가격은 %4d입니다.",fruit, price);
				break;
			case "바나나" :
				price = 3000;
				System.out.printf("%s의 가격은 %4d입니다.",fruit, price);
				break;
			case "딸기" :
				price = 5000;
				System.out.printf("%s의 가격은 %4d입니다.",fruit, price);
				break;
			default :
				System.out.println("잘못입력");
		}
		
		// if문으로 문자열을 비교하려면 fruit.equals("사과"); 와 같이 작성하자.

		 */
		
		// 월을 입력받아 해당월에 말일이 며칠까지 있는지를 출력하는 프로그램
		
		// 월을 입력하세요 : xx
		// xx월은 xx일 까지입니다.
		
		// 1,3,5,7,8,10,12 => 31
		// 4, 6, 9 ,11 => 30
		// 2 => 28
		
		System.out.print("월을 입력하세요 : ");
		int month = s.nextInt();
		
		switch(month) {
			//1, 3, 5, 7, 8, 10, 12
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				System.out.printf("%d월은 31일 까지입니다.",month);
				break;
			//4, 6, 9, 11
			case 4: case 6: case 9: case 11:
				System.out.printf("%d월은 30일 까지입니다.",month);
				break;
			case 2 :
				System.out.printf("%d월은 28일 까지입니다.",month);
		
		}

		s.close();
	}

}
