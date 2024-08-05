package test01.t240704;

import java.util.Scanner;

public class T_02 {

	public static void main(String[] args) {
		/*
		 * 사용자에게 관리자, 회원, 비회원 중 하나를 입력받아 각 등급이 행할 수 있는 권한을 출력하세요.
		 * 단, 관리자는 회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		 * 회원은 게시글 작성, 게시글 조회, 댓글 작성이 가능하고
		 * 비회원은 게시글 조회만 가능합니다.
		 */
		
		/*
		String[] permission = {
				"게시글 조회",
				"게시글 작성",
				"댓글 작성",
				"게시글 관리",
				"회원관리"
		};
		
		int admin = 4;
		int user = 2;
		int guest = 0;
		
		int view = 0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String rank = s.next();
		
		if(rank.equals("관리자")) view = admin;
		else if(rank.equals("회원")) view = user;
		else if(rank.equals("비회원")) view = guest;
		else view = -1;
		
		for(int i=0; i<=view; i++) {
			System.out.print(permission[i]+" ");
		}
		*/
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String rank = s.next();
		String permission = "";
		
		switch(rank) {
		case "관리자":
			permission += "게시글 관리 회원관리 ";
			// 이런식으로 하면 확장성이 좋다
		}
		
	}

}
