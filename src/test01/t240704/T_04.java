package test01.t240704;

import java.util.Scanner;

public class T_04 {

	public static void main(String[] args) {
		/*
		 * 사용자로부터 입력받은 숫자의 단 부터 9단까지 출력하세요.
		 * 단, 9를 초과하는 숫자가 들어오면 "9 이하의 숫자만 입력해주세요"를 출력하세요.
		 * 
		 * ex)
		 * 숫자 : 4				숫자 : 10
		 * ===== 4단 =====		9 이하의 숫자만 입력해주세요.
		 * ===== 5단 =====
		 * ===== 6단 =====
		 * ===== 7단 =====
		 * ===== 8단 =====
		 * ===== 9단 =====
		 *
		 * 
		 */
		Scanner s = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int dan = s.nextInt();
		
		if(dan > 9) {
			System.out.println("9 이하의 숫자만 입력해주세요.");
		}
		
		for(int i=dan;i<=9;i++) {
			System.out.println("===== "+i+"단 =====");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %2d\n", i, j, i * j);
			}
		}
		s.close();
	}

}
