package test01.t240703;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
			/*
			 * 실습문제 1
			 * 
			 * 아래 예시와 같이 메뉴를 출력하고, 메뉴 번호를 누르면 "OO메뉴입니다"를,
			 * 종료 번호를 누르면 "프로그램이 종료됩니다." 를 출력하세요.
			 * 
			 * ex)
			 * 
			 * 1.입력
			 * 2.수정
			 * 3.조회
			 * 4.삭제
			 * 7.종료
			 * 메뉴 번호를 입력하세요 : 3
			 * 조회 메뉴입니다.
			 * 
			 */
		Scanner s = new Scanner(System.in);
		
		String[] menu = {
				"1.입력",
				"2.수정",
				"3.조회",
				"4.삭제",
				"7.종료"
		};
		String choose = "";
		
		while(true) {
			for(int i=0; i<menu.length;i++) {
				System.out.println(menu[i]);
			}
			System.out.print("메뉴 번호를 입력하세요 : ");
			int num = s.nextInt();
			
			switch(num) {
				case 1:
				case 2:
				case 3:
				case 4:
					choose=menu[num-1];
					System.out.println(choose+"메뉴입니다.");
					break;
				case 7:
					choose="종료";
					break;
			}
			
			if(choose.equals("종료")) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			}
			
		}
		

	}

}
