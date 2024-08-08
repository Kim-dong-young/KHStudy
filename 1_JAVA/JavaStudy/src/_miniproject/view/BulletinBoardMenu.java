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

	public void boardMenu() {
		ArrayList<Bulletin> bulletinList = bc.getBulletinList();
		int maxPageView = 5; // 한 페이지에서 보여주는 최대 게시글 수
		int totalPage = 1 + (int) Math.floor((double)bulletinList.size() / (double)maxPageView); // 전체 페이지 수
		int curPage = 1; // 현재 페이지

		int sIndex = bulletinList.size() - 1;
		int eIndex = (bulletinList.size() > maxPageView) ? bulletinList.size() - maxPageView : 0;

		while(true)
		{
			// TODO sIndex eIndex 고칠 것
			bulletinList = bc.getBulletinList();
			System.out.println("===== 자유 게시판 =====");
			for(int i=sIndex; i >= eIndex; i--) {
				System.out.println(bulletinList.get(i));
			}
			System.out.println("현재 페이지 : "+ curPage + " / " + totalPage);
			System.out.println("이전 페이지 = p , 다음 페이지 = n 입력");
			System.out.println("게시글 작성 = w , 게시글 삭제 = d 입력");
			System.out.println("종료 = q 입력");
			System.out.print("게시글을 보려면 게시글 번호 입력 : ");
			
			String ch = null;	
			ch = s.next();
			s.nextLine();

			if(ch.equals("n") && eIndex > 0 ) {
				sIndex -= maxPageView;
				eIndex = (eIndex > maxPageView)? sIndex - maxPageView + 1 : 0;
				curPage++;
			}
			else if(ch.equals("p") && sIndex < bulletinList.size() - 1 ) {
				sIndex = (sIndex + maxPageView < bulletinList.size() - 1) ? sIndex + maxPageView : bulletinList.size() - 1;
				eIndex = sIndex - maxPageView + 1;
				curPage--;
			}

			else if(ch.equals("w")) {
				writeBulletin();
				sIndex = bulletinList.size() - 1;
				eIndex = (bulletinList.size() > maxPageView) ? bulletinList.size() - maxPageView : 0;
			}
			else if(ch.equals("d")) {
				deleteBulletin();
				sIndex = bulletinList.size() - 1;
				eIndex = (bulletinList.size() > maxPageView) ? bulletinList.size() - maxPageView : 0;
			}
			
			else if(ch.equals("q")) {
				System.out.println("게시판을 종료합니다.");
				return;
			}
			else {
				try {
					Bulletin bl = bc.getBulletin(Integer.parseInt(ch));
					if(bl == null) {
						System.out.println("해당 게시글이 존재하지 않습니다.");
						continue;
					}
					System.out.println("====================");
					System.out.printf("게시글 번호 : %s\n", bl.getIndex());
					System.out.printf("제목 : %s\n", bl.getTitle());
					System.out.printf("작성자 : %s\n", bl.getAuthorID());
					System.out.println("====================");
					System.out.printf("%s\n",bl.getContent());
					System.out.println("====================");
				} catch(NumberFormatException e ) {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		}

	}
	
	public void writeBulletin() {
		System.out.printf("게시글 제목 : ");
		String title = s.nextLine();
		System.out.println("게시글 내용입력 (마치려면 \"!q\" 입력) : ");
		String content = "";
		String buffer = "";
		while(true) {
			buffer = s.nextLine();
			if(buffer.equals("!q")) {
				break;
			}
			content += buffer;
		}

		while(true) {
			System.out.println("등록하시겠습니까? (y/n) : ");
			char ch = s.next().charAt(0);
			
			if(ch == 'y' || ch == 'Y') {
				bc.writeBulletin(mc.getCurrentMember().getMemberId(), title, content);
				System.out.println("게시글이 등록되었습니다.");
				break;
			}
			else if(ch == 'n' || ch == 'N') {
				System.out.println("게시글 등록을 취소합니다.");
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void deleteBulletin() {
		System.out.printf("삭제할 게시글 번호 : ");
		int bNum = -1;
		try {
			bNum = s.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다.");
		} finally {
			s.nextLine();
		}
		Bulletin bl = bc.getBulletin(bNum);
		if(bl == null) {
			System.out.println("해당 게시글이 존재하지 않습니다.");
			return;
		}
		Member author = mc.findMember(bl.getAuthorID());
		System.out.printf("사용자 인증을 위해 비밀번호를 입력해주세요 : ");
		String password = s.next();
		if(author != null && author.getMemberPwd().equals(password)) {
			bc.deleteBulletin(bNum);
		}
		else {
			System.out.println("비밀번호가 다릅니다.");
		}
		
	}
	
}
