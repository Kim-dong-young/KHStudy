package test240711.object3;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		/*
		 * 우리는 도서관에 책을 관리하는 프로그램을 만들려고 한다.
		 * 해당 클래스는 도서관에 책을 등록할 때 사용하는 book객체를 생성할 Book클래스다.
		 * 필요하다고 생각하는 데이터와 기능들을 구현해보자
		 *
		 * 사용자로부터 제목, 장르, 저자, 책번호를 입력받아
		 * b1이라는 객체를 생성하고, 생성된 객체의 toString메소드를 호출하여 모든 정보를 확인하자
		 */
		
		BookController bc = new BookController();
		Scanner s = new Scanner(System.in);
		
		int menu = 0;
		
		while(true) {
			if (menu == 9) break;
			System.out.println("======== 도서관리 프로그램 ========");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서목록 출력");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 삭제");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menu = s.nextInt();
			s.nextLine();
			
			switch(menu) {
			case 1:
				bc.regBook();
				break;
			case 2:
				bc.showBookList();
				break;
			case 3:
				System.out.print("검색할 책 이름을 입력 : ");
				String findName = s.nextLine();
				bc.findBook(findName);
				break;
			case 4:
				bc.showBookList();
				System.out.print("삭제할 책 번호를 입력 : ");
				int delBookNum = s.nextInt();
				s.nextLine();
				bc.delBook(delBookNum);
			case 9:
				continue;
			default:
				System.out.println("잘못 입력하셨습니다.\n");
			}
		}
		s.close();
	}
}
