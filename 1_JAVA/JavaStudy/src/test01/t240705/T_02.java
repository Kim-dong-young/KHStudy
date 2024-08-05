package test01.t240705;

import java.util.Scanner;

public class T_02 {
	public static void main(String[] args) {
		/*
		 * 주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요.
		 * 
		 * ex)
		 * 주민번호를 입력하세요( - 포함) : 123456-2123456
		 * 
		 * 여자
		 */
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요( - 포함) : ");
		String[] bNum = s.next().split("-");
		int genderNum = Character.getNumericValue(bNum[1].charAt(0));
		
		if(genderNum % 2 == 0) System.out.println("여자");
		else System.out.println("남자");
		
		s.close();
	}
}
