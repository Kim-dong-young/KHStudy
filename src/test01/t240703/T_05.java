package test01.t240703;

import java.util.Scanner;

public class T_05 {

	public static void main(String[] args) {
		/*
		 * 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 출력하세요.
		 * 
		 * ex.
		 * 정수를 하나 입력하세요 : 8
		 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		 * 
		 */
		Scanner s = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int num = s.nextInt();
		String operator;
		
		int sum=0;
		
		for(int i=1;i<=num;i++) {
			operator = (i == num) ? "=":"+";
			System.out.print(i+" "+operator+" ");
			sum+=i;
		}
		System.out.print(sum);
		
		
	}

}
