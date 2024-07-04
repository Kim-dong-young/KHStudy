package test01.t240704;

import java.util.Scanner;

public class T_08 {

	public static void main(String[] args) {
		/*
		 * "일" ~ "토" 까지 초기화된 문자열 배열을 만들고, 0 부터 6 까지 숫자를 입력받아
		 * 입력한 숫자와 같은 인덱스에 있는 요일을 출력하고
		 * 범위에 없는 숫자를 입력 시 "잘못 입력하셨습니다"를 출력하세요.
		 * 
		 * ex)
		 * 0 ~ 6 사이 숫자 입력 : 4		0 ~ 6 사이 숫자 입력 : 7
		 * 목요일							잘못 입력하셨습니다.
		 * 
		 *  //일 월 화 수 목 금 토
		 *
		 */
		
		String[] day = {"일","월","화","수","목","금","토"};
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int index = s.nextInt();
		
		switch(index) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				System.out.print(day[index]+"요일");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
		}

	}

}
