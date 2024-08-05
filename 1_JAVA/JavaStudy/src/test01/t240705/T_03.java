package test01.t240705;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		/*
		 * 3개의 수를 키보드로 입력 받아, 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
		 * 
		 * ex)
		 * 입력1 : 5
		 * 입력2 : -8
		 * 입력3 : 5
		 * 
		 * false
		 */
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int num1 = s.nextInt();
		
		System.out.print("입력2 : ");
		int num2 = s.nextInt();
		
		System.out.print("입력3 : ");
		int num3 = s.nextInt();
		
		System.out.println((num1 == num2) && (num2 == num3));
		s.close();
	}

}
