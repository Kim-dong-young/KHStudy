package test240729.object1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		int ch = 0;
		while (ch != 9) {
			System.out.println("========== KH 추첨 프로그램 ==========");
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인 ");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색 ");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:

				continue;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int personNum = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<personNum; i++) {
			System.out.print("이름 : ");
			String name = sc.next();
			sc.nextLine();
			
			System.out.print("전화번호('-'빼고) : ");
			String phoneNum = sc.next();
			sc.nextLine();
			
			if(!lc.insertObject(new Lottery(name,phoneNum))) {
				System.out.println("중복된 대상입니다. 다시 입력하세요.");
				i--;
			}
		}
		
		System.out.println("추가 완료되었습니다.");
	}
	
	public void deleteObject() {
		System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.next();
		sc.nextLine();
		
		System.out.print("전화번호('-'빼고) : ");
		String phoneNum = sc.next();
		sc.nextLine();
		
		// TODO 존재 검사
		if(lc.deleteObject(new Lottery(name,phoneNum))) {
			System.out.println("삭제 완료되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 대상입니다.");
		}
	}
	
	public void winObject() {
		System.out.println(lc.winObject());
	}
	
	public void sortedWinObject() {
		TreeSet<Lottery> sortedList = lc.sortedWinObject();
		if(sortedList.isEmpty()) {
			System.out.println("당첨 결과가 없습니다.");
		}
		else{
			Iterator iter = sortedList.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next());
			}
		}
	}
	
	public void searchWinner() {
		System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.next();
		sc.nextLine();
		
		System.out.print("전화번호('-'빼고) : ");
		String phoneNum = sc.next();
		sc.nextLine();
		
		// TODO 존재 검사
		if(lc.searchWinner(new Lottery(name,phoneNum))) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		}
		else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		}
	}
}
