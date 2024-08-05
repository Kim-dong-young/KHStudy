package test01.t240704;

import java.util.Scanner;

public class T_01 {
	public static void main(String[] args) {
		/*
		 * 아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
		 * 로그인 성공 시 "로그인 성공",
		 * 아이디가 틀렸을 시 "아이디가 틀렸습니다.",
		 * 비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다."를 출력하세요.
		 * 
		 * 
		 * ex 1.					ex2.					ex3.
		 * 아이디 : myId				아이디 : myId				아이디 : my
		 * 비밀번호 : myPassword12	비밀번호 : myPassword		비밀번호 : myPassword12
		 * 로그인 성공					비밀번호가 틀렸습니다.		아이디가 틀렸습니다.
		 * 
		 */
		
		String uId = "myId";
		String uPassword = "myPassword12";
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("아이디 : ");
			String id = s.next();
			s.nextLine();
			
			System.out.print("비밀번호 : ");
			String password = s.next();
			s.nextLine();
			
			if(id.equals(uId) && password.equals(uPassword)) {
				System.out.println("로그인 성공");
				break;
			}
			else if (!id.equals(uId)) {
				System.out.println("아이디가 틀렸습니다.");
			}
			else if (!password.equals(uPassword)) {
				System.out.println("비밀번호가 틀렸습니다.");
			}

		}
		s.close();
	}
}
