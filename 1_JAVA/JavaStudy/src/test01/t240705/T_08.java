package test01.t240705;

import java.util.Scanner;

public class T_08 {

	public static void main(String[] args) {
		/*
		 * 정수 두 개와 연산자를 입력 받고 입력된 연산자에 따라 알맞은 결과를 출력하세요.
		 * 단, 해당 프로그램은 연산자 입력에 "exit"라는 값이 들어올 때 까지 무한 반복하며
		 * exit가 들어오면 "프로그램을 종료합니다."를 출력하고 종료합니다.
		 * 
		 * 또한 
		 * 1.연산자가 나누기이면서 두 번째 정수가 0으로 들어오면
		 *   => "0으로 나눌 수 없습니다. 다시 입력해주세요."를 출력하며,
		 * 2.없는 연산자가 들어올 시 
		 *   => "없는 연산자입니다. 다시 입력해주세요."라고 출력하고
		 * 
		 * 두 경우 모두 처음으로 돌아가 사용자가 다시 연산자부터 입력하도록 하세요.
		 * 
		 * 연산자(+, -, *, /, %) : +
		 * 정수1 : 10
		 * 정수2 : 4
		 * 10 + 4 = 14
		 * 
		 * 연산자(+, -, *, /, %) : /		연산자(+, -, *, /, %) : /
		 * 정수1 : 10					정수1 : 10
		 * 정수2 : 4						정수2 : 0
		 * 10 / 4 = 2					0으로 나눌 수 없습니다. 다시 입력해주세요.
		 * 
		 * 연산자(+, -, *, /, %) : ^		연산자(+, -, *, /, %) : exit
		 * 정수1 : 10					프로그램을 종료합니다.
		 * 정수2 : 4
		 * 없는 연산자입니다. 다시 입력해주세요.
		 */
		
		Scanner s = new Scanner(System.in);
		
		while(true) {

			System.out.print("연산자(+, -, *, /, %) : ");
			String inputText = s.next();
			if(inputText.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			char operator = inputText.charAt(0);

			System.out.print("정수1 : ");
			int num1 = s.nextInt();

			System.out.print("정수2 : ");
			int num2 = s.nextInt();

			int result = 0;

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				try {
					result = num1 / num2;
				} catch(ArithmeticException e){
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					continue;
				}
				break;
			case '%':
				result = num1 % num2;
				break;
			default:
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
				continue;
			}
			System.out.printf("%d %c %d = %d\n\n", num1, operator, num2, result);
		}
		s.close();
		
	}

}
