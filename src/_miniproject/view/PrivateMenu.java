package _miniproject.view;

import java.util.Scanner;

import _miniproject.controller.MemberController;

public class PrivateMenu {
	private MemberController mc = MemberController.getInstance();
	private Scanner s = new Scanner(System.in);
	
	public void infoMenu() {
		int ch = 0;
		
		while(ch != 9) {
			System.out.printf("===== %s 님의 마이페이지 =====\n",mc.getCurrentMember().getMemberName());
			System.out.println("1. 보유중인 주식 확인");
			System.out.println("9. 뒤로 가기");
			ch = s.nextInt();
			
			switch(ch) {
			case 1:
				mc.showStockList();
				break;
			case 9:
				System.out.println("마이페이지에서 나갑니다.");
				continue;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
}
