package test01.t240704;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		/*
		 * 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		 * 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력하세요.
		 * 
		 * ex.
		 * 첫 번째 숫자 : 8	첫 번째 숫자 : 4 	첫 번쨰 숫자 : 9
		 * 두 번째 숫자 : 4	두 번째 숫자 : 8	두 번째 숫자 : 0
		 * 4 5 6 7 8		4 5 6 7 8		1 이상의 숫자를 입력해주세요.
		 */
		
		Scanner s = new Scanner(System.in);

		System.out.print("첫 번째 숫자 : ");
		int num1 = s.nextInt();

		System.out.print("두 번째 숫자 : ");
		int num2 = s.nextInt();

		if (num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			int start = (num1 > num2) ? num2 : num1;
			int end = (num1 > num2) ? num1 : num2;

			for (int i = start; i <= end; i++) {
				System.out.print(i + " ");
			}

		}
		s.close();
		
		

	}

}
