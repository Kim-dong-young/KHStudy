package test240708;

import java.util.Scanner;

public class Test5 {
	// 키보드로 2개의 정수형 데이터를 입력 받아, 
	// 두 수가 모두 1부터 9까지의 수일 때만 두 수의 곱이 한자리 수인지 두자리 수인지를 출력한다. 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		
		if((num1 >= 1 && num1 <= 9) && (num2 >= 1 && num2 <= 9)) {
			int mulnum = num1 * num2;
			if(mulnum / 10 > 0) System.out.println("두자리 수 입니다.");
			else System.out.println("한자리 수 입니다.");
		}
		
		s.close();
	}

}
