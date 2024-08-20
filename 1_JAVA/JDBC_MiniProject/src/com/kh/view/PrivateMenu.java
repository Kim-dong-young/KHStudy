package com.kh.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrivateMenu {
	private Scanner s;
	
	public PrivateMenu(Scanner s) {
		super();
		this.s = s;
	}
	
	public void mainMenu() {
		int ch = -1;
		
		while(ch != 0) {
			// TODO 정보 제대로 표시
			System.out.printf("===== %s 님의 마이페이지 =====\n", "default");
			System.out.println("1. 보유중인 주식 확인");
			System.out.println("2. 보유중인 아이템 확인");
			System.out.println("3. 거래 기록 확인");
			System.out.println("0. 뒤로 가기");
			
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}
			
			switch(ch) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 0:
				System.out.println("마이페이지에서 나갑니다.");
				continue;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	public void shareHeldMenu() {
		
	}
	
	public void itemMenu() {
		int ch = -1;
		
		while(ch != 0) {
			System.out.println("===== 보유중인 아이템 =====");
			// TODO 보유 아이템 목록 출력
			System.out.println("0. 마이페이지로 돌아가기");
			System.out.print("사용할 아이템 번호 : ");
			
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}
			
			
			if(ch == 0) return;
			
		}
		
	}
	
}
