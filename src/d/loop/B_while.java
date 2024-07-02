package d.loop;

import java.util.Scanner;

public class B_while {
	/*
	 * while문
	 * 
	 * [표현법]
	 * 
	 * [초기식;]
	 * while(조건식){
	 * 		반복할 코드
	 * 		증감식;
	 * }
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		/*
		// 사용자가 0을 입력할 때 까지 반복해서 숫자를 입력받아 그대로 출력하라
		while(true) {
			int n = s.nextInt();
			if (n == 0) {
				break;
			}
			else {
				System.out.println(n);
			}
		}
		*/
		
		/*
		// 1에서부터 10000 사이의 홀수만을 출력
		// while문 이용하기
		
		int n=1;
		while(n<10000) {
			if(n % 2 != 0) {
				System.out.print(n+" ");
			}
			n++;
		}
		*/
		
		/*
		// 1부터 랜덤값(1~100사이)까지의 합계를 출력
		// 1에서부터 xx까지의 총 합계 : 
		int n=(int)(Math.random() * 100 + 1);
		int sum=0, i=1;
		while(i<=n) {
			sum+=i;
			i++;
		}
		System.out.println("1부터 "+n+"까지의 총 합계 : "+sum);
		*/
		
		// 사용자에게 문자열을 입력받아
		// 해당 문자열의 짝수자리 글자만 출력
		// 문자열 입력 : hello
		// el
		
		String word = s.nextLine();
		int i = 0;
		while(i<word.length()) { //출력은 짝수자리이지만, 인덱스번호는 홀수임에 유의
			if(i%2 != 0) System.out.print(word.charAt(i));
			i++;
		}
		
		//두번쨰 방법
		i=1;
		while(i<word.length()) {
			if(i%2 != 0) System.out.print(word.charAt(i));
			i+=2;

		}
		
		s.close();
	}

}
