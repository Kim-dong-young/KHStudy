package com.kh.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.controller.MemberStockController;
import com.kh.model.vo.Member;
import com.kh.model.vo.MemberStock;

public class MainMenu {
	Scanner s = new Scanner(System.in);
	private MemberController mc = MemberController.getInstance();
	private MemberStockController msc = MemberStockController.getInstance();
	
	public void mainMenu() {
		int ch = -1;
		
		while(ch != 0) {
			System.out.println("===== 모의 주식 투자 프로그램 =====");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			
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
				loginMenu();
				break;
			case 2:
				registerMenu();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void loginMenu() {
		System.out.println("===== 로그인 =====");
		System.out.print("아이디 입력 : ");
		String id = s.next();
		s.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = s.next();
		s.nextLine();
		
		mc.loginMember(id,pwd);
		if(mc.getCurrentMember() != null) {
			memberMenu();
		}
	}
	
	public void registerMenu() {
		System.out.println("===== 회원가입 =====");
		System.out.print("이름 입력 : ");
		String name = s.next();
		s.nextLine();
		
		System.out.print("아이디 입력 : ");
		String id = s.next();
		s.nextLine();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = s.next();
		s.nextLine();
		
		mc.createMember(name, id, pwd);
	}
	
	public void memberMenu() {
		Member cMember = mc.getCurrentMember();
		int ch = -1;

		while (ch != 0) {
			System.out.printf("===== %s 님 환영합니다. =====\n", cMember.getMemberName());
			System.out.printf("현재 날짜 : %d일\n", cMember.getDay());
			System.out.printf("보유 자산 : %d원\n", cMember.getBalance());
			System.out.println("===== 메인 화면 =====");
			System.out.println("1. 주식 현황");
			System.out.println("2. 주식 매매");
			System.out.println("3. 자유 게시판");
			System.out.println("4. 마이 페이지");
			System.out.println("5. 아이템 상점");
			System.out.println("6. 다음날로 넘어가기");
			System.out.println("0. 로그아웃");
			System.out.print("메뉴 입력 : ");
			
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}

			switch (ch) {
			case 1:
				displayStockList();
				break;
			case 2:
				new StockMarketMenu(s).mainMenu();
				break;
			case 3:

				break;
			case 4:
				new PrivateMenu(s).mainMenu();
				break;
			case 5:

				break;
			case 6:

				break;
			case 0:
				System.out.println("로그아웃 합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	private void displayStockList() {
		ArrayList<MemberStock> mStockList = mc.getMemberStockList(mc.getCurrentMember());
		
		if(mStockList.isEmpty()) {
			System.out.println("현재 상장된 종목이 없습니다.");
			return;
		}
		
		for(MemberStock ms : mStockList) {
			System.out.println(ms);
		}
	}

	
}
