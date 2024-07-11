package test240711.object1;

import java.util.Scanner;

public class T_01 {
	public static void main(String[] args) {
		// 정수 n(2~9)를 입력받아 2부터 n까지 중 짝수의 구구단을 출력하는 함수를 작성하세요.
		// 만약 2~9사이의 값을 입력하지 않는다면 다시 입력하세요 를 반복합니다.
		
		Scanner s = new Scanner(System.in);
		int n = 0;
		
		while(true) {
			System.out.print("정수 n(2~9) 입력 : ");
			n = s.nextInt();
			
			if(n < 2 || n > 9) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			break;
		}
		
		for(int dan = 2; dan <= n; dan++) {
			if(dan % 2 == 0) {
				for(int su = 1; su <= 9; su++) {
					System.out.printf("%d * %d = %d\n",dan,su,dan*su);
				}
				System.out.println();
			}
		}
		
		
	}
}
