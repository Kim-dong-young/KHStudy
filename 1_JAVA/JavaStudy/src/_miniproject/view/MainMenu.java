package _miniproject.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import _miniproject.controller.MemberController;
import _miniproject.controller.StockController;
import _miniproject.controller.TradeLogController;
import _miniproject.vo.Member;

public class MainMenu {
	Scanner s = new Scanner(System.in);
	
	TradeLogController tc = TradeLogController.getInstance();
	MemberController mc = MemberController.getInstance();
	StockController sc = StockController.getInstance();

	public void mainMenu() {
		mc.loadMembers();
		tc.loadTradeLog();
		int ch = 0;
		
		while(ch != 9) {
			System.out.println("===== 모의 주식 투자 프로그램 =====");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("9. 프로그램 종료");
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
			case 9:
				System.out.println("프로그램을 종료합니다.");
				mc.saveMembers();
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
			else {
				break;
			}

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
			System.out.println("3. 자유 게시판");
			System.out.println("4. 마이 페이지");
			System.out.println("5. 아이템 상점");
			System.out.println("6. 다음날로 넘어가기");
			System.out.println("9. 로그아웃");
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
				stockMenu();
				break;
			case 2:
				stockMarketMenu();
				break;
			case 3:
				new BulletinBoardMenu(s).mainMenu();
				break;
			case 4:
				privateMenu();
				break;
			case 5:
				new ItemStoreMenu(s).mainMenu();
				break;
			case 6:
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
		new StockMenu(s).chartMenu();
	}
	
	public void stockMarketMenu() {
		new StockMenu(s).mainMenu();
	}
	
	public void privateMenu() {
		new PrivateMenu(s).mainMenu();
	}
}
