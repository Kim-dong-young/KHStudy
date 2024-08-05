package test240717.object2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		String name;
		int age=-1;
		char gender = ' ';
		
		System.out.print("이름 : ");
		name = sc.next();
		sc.nextLine();
		
		while(true) {
			System.out.print("나이 : ");
			try {
			age = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				sc.nextLine();
				continue;
			}
			
			if(age < 0 || age > 130)
				System.out.println("나이를 제대로 입력해주세요.");
			else break;
		}
		sc.nextLine();
		
		while(true) {
			System.out.print("성별(M/F) : ");
			gender = sc.next().charAt(0);
			sc.nextLine();
			
			if(gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') break;
			else System.out.println("M 또는 F를 입력해주세요.");
		}
		
		lc.insertMember(new Member(name,age,gender));

		int ch = 0;

		while (true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");

			System.out.print("메뉴 번호 : ");
			try {
				ch = sc.nextInt();
			} catch(InputMismatchException e) {
				ch = 0;
			}
			sc.nextLine();

			switch (ch) {
			case 1:
				System.out.println(lc.myInfo());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9: // 프로그램 종료
				return;
			default:
				System.out.println("잘못된 값 입력");
				break;
			}
		}

	}

	public void selectAll() {
		Book[] bList = lc.selectAll();
		for (int i = 0; i < bList.length; i++) {
			if(bList[i] == null) break;
			System.out.println(i+"번도서 : "+bList[i]);
		}
	}

	public void searchBook() {
		String keyword;
		Book[] result;
		
		System.out.print("검색할 제목 키워드 : ");
		keyword = sc.nextLine();
		result =lc.searchBook(keyword);
		
		for (int i = 0; i < result.length; i++) {
			if(result[i] == null) break;
			System.out.println(result[i]);
		}
	}

	public void rentBook() {
		int bIndex;
		int result;
		
		selectAll();
		System.out.print("대여할 도서 번호 선택 : ");
		bIndex = sc.nextInt();
		result = lc.rentBook(bIndex);
		
		switch(result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
			break;
		}
		
	}
}
