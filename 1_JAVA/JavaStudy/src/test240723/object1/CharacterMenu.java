package test240723.object1;

import java.util.Scanner;

public class CharacterMenu {
	public void menu() {
		Scanner s = new Scanner(System.in);
		CharacterController cc = new CharacterController();
		String word;
		
		System.out.print("문자열 : ");
		word = s.nextLine();
		
		try {
			System.out.printf("'%s'에 포함된 영문자 개수 : %d\n",word,cc.countAlpha(word));
		} catch (CharCheckException e) {
			e.printStackTrace();
		} finally {
			s.close();
			System.out.println("잘 종료되었습니다.");
		}
		
	}
}
