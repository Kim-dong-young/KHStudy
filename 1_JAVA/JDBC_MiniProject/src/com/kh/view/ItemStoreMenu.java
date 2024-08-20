package com.kh.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ItemStoreMenu {
	private Scanner s;
	
	public ItemStoreMenu(Scanner s) {
		super();
		this.s = s;
	}
	
	public void mainMenu() {
		int ch = -1;
		
		while (ch != 0) {
			System.out.println("===== 아이템 목록 =====");
			System.out.println(">>> 아이템 사용은 마이페이지에서 가능합니다");
			// TODO 상점 아이템 목록 출력
			System.out.println("0. 메뉴로 돌아가기");
			System.out.print("구매할 아이템 번호 입력 : ");
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}

			if (ch == 0) return;
 			
			purchaseMenu(ch);
		}
	}
	
	public void purchaseMenu(int itemNum) {
		
	}
}
