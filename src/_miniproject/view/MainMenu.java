package _miniproject.view;

import java.util.Scanner;

import _miniproject.controller.MemberController;
import _miniproject.controller.StockController;
import _miniproject.vo.Member;

public class MainMenu {
	Scanner s = new Scanner(System.in);
	MemberController mc = MemberController.getInstance();
	StockController sc = StockController.getInstance();
	StockMenu sm = new StockMenu();
	PrivateMenu pm = new PrivateMenu();
	
	public void mainMenu() {
		int ch = 0;
		
		while(ch != 9) {
			System.out.println("===== 모의 주식 투자 프로그램 =====");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			ch = s.nextInt();
			s.nextLine();
			
			switch(ch) {
			case 1:
				loginMenu();
				break;
			case 2:
				registerMenu();
				break;
			case 9:
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
		
		if(mc.isLoginSuccess(id, pwd)) {
			mc.loginMember(id);
			sc.setStockList(mc.getCurrentMember().getStockList());
			memberMenu();
			return;
		}
		else {
			System.out.println("없는 아이디이거나 비밀번호가 틀렸습니다.");
			return;
		}
		
	}
	
	public void registerMenu() {
		String id;
		String name;
		
		System.out.println("===== 회원가입 =====");
		System.out.print("이름 입력 : ");
		name = s.next();
		s.nextLine();
		
		while(true) {
			System.out.print("아이디 입력 : ");
			id = s.next();
			s.nextLine();

			if (mc.isMemberExist(id)) {
				System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
				continue;
			}
			else
				break;
		}
		
		System.out.print("비밀번호 입력 : ");
		String pwd = s.next();
		s.nextLine();
		
		mc.addMember(name, id, pwd);
		
	}
	
	public void memberMenu() {
		Member currentMember = mc.getCurrentMember();
		int ch = 0;

		while (ch != 9) {
			System.out.printf("===== %s 님 환영합니다. =====\n", currentMember.getMemberId());
			System.out.printf("현재 날짜 : %d일", currentMember.getDay());
			System.out.printf("보유 자산 : %d원\n", currentMember.getBalance());
			System.out.println("1. 주식 현황");
			System.out.println("2. 주식 매매");
			System.out.println("3. 나의 주식");
			System.out.println("4. 다음날로 넘어가기");
			System.out.println("9. 로그아웃");
			System.out.print("메뉴 입력 : ");
			ch = s.nextInt();
			s.nextLine();

			switch (ch) {
			case 1:
				stockMenu();
				break;
			case 2:
				stockMarketMenu();
				break;
			case 3:
				privateMenu();
				break;
			case 4:
				sc.randomStockPrice();
				currentMember.setDay(currentMember.getDay() + 1);
				break;
			case 9:
				System.out.println("로그아웃 합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}
	
	public void stockMenu() {
		sm.chartMenu();
	}
	
	public void stockMarketMenu() {
		sm.marketMenu();
	}
	
	public void privateMenu() {
		pm.infoMenu();
	}
}
