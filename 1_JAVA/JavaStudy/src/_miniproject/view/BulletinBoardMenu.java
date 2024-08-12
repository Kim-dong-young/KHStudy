package _miniproject.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import _miniproject.controller.BulletinController;
import _miniproject.controller.MemberController;
import _miniproject.vo.Bulletin;
import _miniproject.vo.Member;

public class BulletinBoardMenu {
	private Scanner s;
	private BulletinController bc = BulletinController.getInstance();
	private MemberController mc = MemberController.getInstance();

	public BulletinBoardMenu(Scanner s) {
		super();
		this.s = s;
	}
	
	public void searchResultMenu() {
		// TODO 게시글 삭제, 변경 후 인덱스 값 제대로 계산할 것
		ArrayList<Bulletin> bulletinList = bc.getBulletinList();
		
		// searchText[0] : 조회 기준 ( 0 : 전체, 1 : 제목 , 2 : 작성자 )
		// searchText[1] : 검색할 검색어 ( 조회 기준 = 0(전체)일 경우 null )
		String[] searchText = new String[2];
		searchText[0] = "0";
		searchText[1] = null;
		
		int maxPageView = 5; // 한 페이지에서 보여주는 최대 게시글 수
		int totalPage; // 전체 게시글 페이지 수
		int curPage = 1; // 현재 페이지

		int sIndex = bulletinList.size() - 1;
		int eIndex = (bulletinList.size() > maxPageView) ? bulletinList.size() - maxPageView : 0;

		while(true) {
			// 전체 게시글 페이지 수 계산
			totalPage = (int) Math.ceil((double) bulletinList.size() / (double) maxPageView); // 전체 페이지 수
			
			System.out.println("===== 자유 게시판 =====");
			if(bulletinList.isEmpty()) {
				System.out.println("작성된 게시글이 없습니다.");
			}
			for (int i = sIndex; i >= eIndex; i--) {
				System.out.println(bulletinList.get(i));
			}
			System.out.println("현재 페이지 : " + curPage + " / " + totalPage);
			System.out.println("이전 페이지 = p , 다음 페이지 = n 입력");
			System.out.println("게시글 작성 = w , 게시글 검색 = s 입력");
			System.out.println("종료 = q 입력");
			System.out.print("게시글을 보려면 게시글 번호 입력 : ");

			String ch = null;
			ch = s.next();
			s.nextLine();

			// 이전 페이지
			if (ch.equals("p") && sIndex < bulletinList.size() - 1) {
				sIndex = (sIndex + maxPageView < bulletinList.size() - 1) ? sIndex + maxPageView
						: bulletinList.size() - 1;
				eIndex = sIndex - maxPageView + 1;
				curPage--;
			}
			// 다음 페이지
			else if (ch.equals("n") && eIndex > 0) {
				sIndex -= maxPageView;
				eIndex = (eIndex > maxPageView) ? sIndex - maxPageView + 1 : 0;
				curPage++;
			}
			// 게시글 작성
			else if (ch.equals("w")) {
				writeMenu();
				bulletinList = bc.getBulletinList();
				sIndex = bulletinList.size() - 1;
				eIndex = (bulletinList.size() > maxPageView) ? bulletinList.size() - maxPageView : 0;
				curPage = 1;
			}
			// 게시글 검색
			else if (ch.equals("s")) {
				searchText = searchMenu();
				
				if(searchText[0].equals("0")) {
					bulletinList = bc.getBulletinList();
				}
				else {
					// searchText[0] : 조회 기준 ( 0 : 전체, 1 : 제목 , 2 : 작성자 )
					// searchText[1] : 검색할 검색어 ( 조회 기준 = 0(전체)일 경우 null )
					bulletinList = bc.getBulletinList(Integer.parseInt(searchText[0]), searchText[1]);
				}
				// searchText[0] : 조회 기준 ( 0 : 전체, 1 : 제목 , 2 : 작성자 )
				// searchText[1] : 검색할 검색어 ( 조회 기준 = 0(전체)일 경우 null )
				sIndex = bulletinList.size() - 1;
				eIndex = (bulletinList.size() > maxPageView) ? bulletinList.size() - maxPageView : 0;
				curPage = 1;
			}
			// 게시판 종료
			else if (ch.equals("q")) {
				System.out.println("게시판을 종료합니다.");
				return;
			} 
			// 게시글 조회 - 게시글 번호로 조회한다.
			else {
				boolean isChanged = false;
				try {
					Bulletin bl = bc.searchByBulletinID(Integer.parseInt(ch));
					// 조회 실패
					if (bl == null) {
						System.out.println("해당 게시글이 존재하지 않습니다.");
						continue;
					}
					// 조회 성공
					else {
						isChanged = bulletinMenu(bl);
					}
				} catch (NumberFormatException e) { // 조회할 게시글 번호 입력값이 숫자가 아닐경우
					System.out.println("잘못 입력하셨습니다.");
				}
				
				if(isChanged) { // 조회한 게시글의 변경이 일어났을 경우, 게시물 목록을 새로고침한다.
					bulletinList = bc.getBulletinList();
					sIndex = bulletinList.size() - 1;
					eIndex = (bulletinList.size() > maxPageView) ? bulletinList.size() - maxPageView : 0;
					curPage = 1;
				}
			}
		}
		
		
	}

	public void mainMenu() {
		// 메인메뉴, 전체 게시글을 보여준다
		searchResultMenu();
	}
	
	public boolean bulletinMenu(Bulletin bl) {
		// TODO 게시글 삭제, 변경 후 인덱스 값 제대로 계산할 것
		String ch = "";
		boolean isChanged = false;
		
		while(!ch.equals("q")) {
			System.out.println("\n====================");
			System.out.printf("게시글 번호 : %s\n", bl.getbulletinID());
			System.out.printf("제목 : %s\n", bl.getTitle());
			System.out.printf("작성자 : %s\n", bl.getAuthorID());
			System.out.println("====================");
			System.out.printf("%s\n", bl.getContent());
			System.out.println("====================\n");
			System.out.println("게시글 수정 : u , 게시글 삭제 : d 입력");
			System.out.println("뒤로 가기 : q 입력");
			System.out.printf("메뉴 입력 : ");
			ch = s.next();
			s.nextLine();
			
			if(ch.equals("u")) {
				updateMenu(bl);
				isChanged = true;
			}
			else if(ch.equals("d")) {
				deleteMenu(bl);
				isChanged = true;
				return isChanged;
			}
			else if(ch.equals("q")) {
				System.out.println("게시판으로 돌아갑니다.");
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		return isChanged;
	}

	public void writeMenu() {
		System.out.printf("게시글 제목 : ");
		String title = s.nextLine();
		System.out.println("게시글 내용입력 (마치려면 \"!q\" 입력) : ");
		String content = "";
		String buffer = "";
		while (true) {
			buffer = s.nextLine();
			if (buffer.equals("!q")) {
				break;
			}
			content += buffer;
		}

		while (true) {
			System.out.println("등록하시겠습니까? (y/n) : ");
			char ch = s.next().charAt(0);

			if (ch == 'y' || ch == 'Y') {
				bc.writeBulletin(mc.getCurrentMember().getMemberId(), title, content);
				System.out.println("게시글이 등록되었습니다.");
				break;
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("게시글 등록을 취소합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public boolean deleteMenu(Bulletin bl) {
		boolean isSuccess = false;
		Member author = mc.findMember(bl.getAuthorID());
		System.out.printf("사용자 인증을 위해 비밀번호를 입력해주세요 : ");
		String password = s.next();
		if (author != null && author.getMemberPwd().equals(password)) {
			if(bc.deleteBulletin(bl)) {
				isSuccess = true;
				System.out.println("성공적으로 삭제하였습니다.");
			}
			else {
				System.out.println("게시글 삭제에 실패하였습니다.");
			}
		} else {
			System.out.println("비밀번호가 다릅니다.");
		}
		return isSuccess;
	}

	public String[] searchMenu() {
		System.out.println("===== 게시글 검색 =====");
		System.out.println("1. 게시글 제목으로 검색");
		System.out.println("2. 작성자 이름으로 검색");
		System.out.println("0. 취소");
		System.out.printf("메뉴 번호 : ");
		int ch = 0;
		try {
			ch = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
		} finally {
			s.nextLine();
		}
		
		String[] searchText = new String[2];
		searchText[0] = Integer.toString(ch);
		switch(ch) {
		case 1:
			System.out.print("검색할 게시글 제목 입력 : ");
			searchText[1] = s.nextLine();
			break;
		case 2:
			System.out.print("검색할 작성자 이름 입력 : ");
			searchText[1] = s.nextLine();
			break;
		case 0:
			System.out.println("검색을 취소합니다.");
			break;
		default :
			System.out.println("잘못 입력했습니다.");
			searchText[0] = Integer.toString(0);
		}

		return searchText;
	}
	
	public void updateMenu(Bulletin bl) {
		Member author = mc.findMember(bl.getAuthorID());
		System.out.printf("사용자 인증을 위해 비밀번호를 입력해주세요 : ");
		String password = s.next();
		if (author != null && author.getMemberPwd().equals(password)) {
			System.out.println("바꿀 항목을 골라주세요.");
			System.out.println("1. 제목");
			System.out.println("2. 내용");
			System.out.println("바꿀 항목 입력 : ");
			int ch = s.nextInt();
			s.nextLine();
			
			String text = null;
			switch(ch) {
			
			case 1:
				System.out.println("바꿀 제목을 입력해주세요.");
				text = s.nextLine();
				bl.setTitle(text);
				System.out.println("성공적으로 제목을 수정하였습니다.");
				break;
				
			case 2:
				System.out.println("바꿀 내용을 입력해주세요.");
				System.out.println("게시글 내용입력 (마치려면 \"!q\" 입력) : ");
				String content = "";
				String buffer = "";
				while (true) {
					buffer = s.nextLine();
					if (buffer.equals("!q")) {
						break;
					}
					content += buffer;
				}
				bl.setContent(content);
				System.out.println("성공적으로 내용을 수정하였습니다.");
				break;
				
			default :
				System.out.println("잘못 입력하셨습니다.");
				return;
			}
		} else { // 작성자 인증에 실패할 경우
			System.out.println("비밀번호가 다릅니다.");
		}

	}

}
