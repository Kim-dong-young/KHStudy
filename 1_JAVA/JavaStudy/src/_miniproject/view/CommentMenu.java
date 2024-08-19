package _miniproject.view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import _miniproject.controller.BulletinController;
import _miniproject.controller.CommentController;
import _miniproject.controller.MemberController;
import _miniproject.vo.Bulletin;
import _miniproject.vo.Comment;

public class CommentMenu {
	private final static int COMMENT_LIMIT = 100;
	private Scanner s = new Scanner(System.in);
	private BulletinController bc = BulletinController.getInstance();
	private CommentController cc = CommentController.getInstance();
	private MemberController mc = MemberController.getInstance();
	
	public CommentMenu(Scanner s) {
		super();
		this.s = s;
	}
	
	public void writeMenu(Bulletin bl) {
		System.out.println("===== 댓글작성 =====");
		System.out.printf("댓글 내용입력 [%d자 제한] (마치려면 \"!q\" 입력) : \n", COMMENT_LIMIT);
		String content = "";
		String buffer = "";
		while (true) {
			buffer = s.nextLine();
			
			if (buffer.equals("!q")) {
				break;
			}
			if (content.length() + buffer.length() >= COMMENT_LIMIT) {
				System.out.println("제한 글자를 초과했습니다. 다시 입력해주세요.");
				System.out.printf("현재 작성글 길이 : %d\n",content.length());
				buffer = "";
				continue;
			}
			content += buffer + "\n";
		}
		
		while (true) {
			System.out.println("등록하시겠습니까? (y/n) : ");
			char ch = s.next().charAt(0);

			if (ch == 'y' || ch == 'Y') {
				Comment comment = new Comment(bl.getBulletinID(), bl.getComments().size(), new Date(), mc.getCurrentMember().getMemberId(), content);
				cc.writeComment(bl, comment);
				System.out.println("댓글이 등록되었습니다.");
				break;
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("댓글 등록을 취소합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	public void deleteMenu(Bulletin bl) {
		System.out.print("삭제할 댓글 번호를 입력하세요 : ");
		int cmNum = s.nextInt();
		s.nextLine();
		
		System.out.printf("사용자 인증을 위해 비밀번호를 입력해주세요 : ");
		String password = s.next();
		
		if (mc.isLoginSuccess(bl.getComments().get(cmNum).getAuthorID(), password)) {
			if(cc.deleteComment(bl, cmNum)) {
				System.out.println("성공적으로 삭제하였습니다.");
			}
			else {
				System.out.println("삭제에 실패하였습니다.");
			}
		} else {
			System.out.println("비밀번호가 다릅니다.");
		}
	}
	public void updateMenu(Bulletin bl) {
		
		System.out.print("수정할 댓글 번호를 입력하세요 : ");
		int cmNum = -1;
		
		try {
			cmNum = s.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다.");
			s.nextLine();
			return;
		}
		// 존재하지 않는 index이거나 index 범위를 초과한 값을 입력할 경우
		if( (bl.getComments().get(cmNum) == null ) && (cmNum < bl.getComments().size() && cmNum < 0) ) {
			System.out.println("존재하지 않는 댓글입니다.");
			return;
		}
		
		if(bl.getComments().get(cmNum).isDeleted()) {
			System.out.println("이미 삭제된 댓글입니다.");
			return;
		}
		
		System.out.printf("사용자 인증을 위해 비밀번호를 입력해주세요 : ");
		String password = s.next();
		
		if (mc.isLoginSuccess(bl.getComments().get(cmNum).getAuthorID(), password)) {
			System.out.println("===== 수정할 댓글작성 =====");
			System.out.printf("수정할 댓글 내용입력 [%d자 제한] (마치려면 \"!q\" 입력) : \n", COMMENT_LIMIT);
			String content = "";
			String buffer = "";
			while (true) {
				buffer = s.nextLine();
				
				if (buffer.equals("!q")) {
					break;
				}
				if (content.length() + buffer.length() >= COMMENT_LIMIT) {
					System.out.println("제한 글자를 초과했습니다. 다시 입력해주세요.");
					System.out.printf("현재 작성글 길이 : %d\n",content.length());
					buffer = "";
					continue;
				}
				content += buffer + "\n";
			}
			
			while (true) {
				System.out.println("등록하시겠습니까? (y/n) : ");
				char ch = s.next().charAt(0);

				if (ch == 'y' || ch == 'Y') {
					Comment comment = new Comment(bl.getBulletinID(), cmNum, new Date(), mc.getCurrentMember().getMemberId(), content);
					cc.updateComment(bl, comment);
					System.out.println("성공적으로 수정하였습니다.");
					break;
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("댓글 등록을 취소합니다.");
					break;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
			
		} else {
			System.out.println("비밀번호가 다릅니다.");
		}
	}
}
