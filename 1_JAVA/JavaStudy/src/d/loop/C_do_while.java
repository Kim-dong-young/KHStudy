package d.loop;

import java.util.Scanner;

public class C_do_while {
	/*
	 * do-while 문
	 * 
	 * do{
	 * 		실행코드;
	 * }
	 * while(조건식);
	 * 
	 * 처음에 무조건 실행코드 한번은 수행한 뒤, 조건문을 검사한다.
	 * 
	 * 기존의 for/while문과의 차이점
	 * for/while문은 처음 수행될 때, 조건 검사 후 true일 경우 반복코드를 실행하지만
	 * do-while은 첫 실행은 조건검사 없이 무조건 실행
	 * 
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// 사용자가 입력한 수를 계속해서 더하는 프로그램을 작성
		// 단, 사용자가 0을 입력하면 종료
		int sum = 0;
		int num;
		
		do {
			System.out.print("더할 수를 입력 : ");
			num = s.nextInt();
			sum+=num;
			System.out.println("num : "+sum);
		}while(num != 0);

	}

}
