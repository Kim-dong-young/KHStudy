package test240730.object1;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public void mainMenu() {
		int ch = 0;

		while (ch != 9) {
			System.out.println("========== KH 사이트 ==========");
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				joinMembership();
				break;
			case 2:
				logIn();
				memberMenu();
				break;
			case 3:
				sameName();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				break;
			}
		}

	}

	public void memberMenu() {
		int ch = 0;

		while (ch != 3) {
			System.out.println("******* 회원 메뉴 ******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기 ");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 번호 선택 : ");
			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				System.out.println("로그아웃 되었습니다.");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}

	public void joinMembership() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String pwd = sc.next();
			sc.nextLine();
			
			System.out.print("이름 : ");
			String name = sc.next();
			sc.nextLine();
			
			Member newMember = new Member(pwd, name);
			if(mc.joinMembership(id, newMember)) {
				System.out.println("성공적으로 회원가입 완료하였습니다");
				break;
			}
			else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		}
	}

	public void logIn() {
		while(true) { // 회원가입 안하고 로그인하면 못벗어나지 않나?
			System.out.print("아이디 : ");
			String id = sc.next();
			sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String pwd = sc.next();
			sc.nextLine();
			
			String memberName = mc.logIn(id, pwd);
			if(memberName != null) {
				System.out.printf("%s님 환영합니다!\n", memberName);
				break;
			}
			else {
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			}
		}
	}

	public void changePassword() {
		System.out.print("아이디 : ");
		String id = sc.next();
		sc.nextLine();
		
		System.out.print("현재 비밀번호 : ");
		String oldPwd = sc.next();
		sc.nextLine();
		
		System.out.print("새로운 비밀번호 : ");
		String newPwd = sc.next();
		sc.nextLine();
		
		if(mc.changePassword(id, oldPwd, newPwd)) {
			System.out.println("비밀번호 변경에 성공했습니다.");
		}
		else {
			System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
		}
	}

	public void changeName() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			sc.nextLine();

			System.out.print("비밀번호 : ");
			String pwd = sc.next();
			sc.nextLine();

			String memberName = mc.logIn(id, pwd);
			if (memberName != null) {
				System.out.printf("현재 설정된 이름 : %s\n", memberName);
				System.out.print("변경할 이름 : ");
				String newName = sc.next();
				sc.nextLine();

				mc.changeName(id, newName);
				System.out.println("이름 변경에 성공하였습니다.");
				break;
			} else {
				System.out.println("이름변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
	
	}

	public void sameName() {
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		sc.nextLine();
		
		TreeMap<String, Member> sameName = mc.sameName(name);
		if(sameName.isEmpty()) {
			System.out.println("회원을 찾지 못하였습니다.");
		}
		else {
			for(Entry<String, Member> entry : sameName.entrySet()) {
				System.out.printf("%s - %s\n",entry.getValue(),entry.getKey());
			}
		}
	}
}
