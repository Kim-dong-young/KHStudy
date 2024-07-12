package test240712.object1;

import java.util.Scanner;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() { }
	
	public void mainMenu() {
		int ch = 0;
		int existMemberNum;
		
		while(true) {
			if(ch == 9) break;
			
			existMemberNum = mc.existMemberNum();
			System.out.println("최대 등록 가능한 회원 수는 "+MemberController.SIZE+"명 입니다.");
			System.out.println("현재 등록된 회원 수는 "+ existMemberNum +"명 입니다.");
			
			if(existMemberNum >= MemberController.SIZE) {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			else
				System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				continue;
			case 1:
				if(existMemberNum < MemberController.SIZE) {
					insertMember();
					break;
				}
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
		}
		
	}
	
	public void insertMember() {
		
		String id;
		String name;
		String password;
		String email;
		String gender;
		int age;
		
		System.out.println("새 회원을 등록합니다.");
		
		while(true) {
			System.out.print("아이디 : ");
			id = sc.next();
			sc.nextLine();
			
			if(!mc.checkId(id)) 
				break;
			else 
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}
		
		System.out.print("이름 : ");
		name = sc.next();
		sc.nextLine();
		
		System.out.print("비밀번호 : ");
		password = sc.next();
		sc.nextLine();
		
		System.out.print("이메일 : ");
		email = sc.next();
		sc.nextLine();
		
		while(true) {
			System.out.print("성별(M/F) : ");
			gender = sc.next();
			sc.nextLine();
			
			if( gender.equals("M") || gender.equals("m") ||gender.equals("F")|| gender.equals("f") )
				break;
			else
				System.out.println("성별을 다시 입력하세요.");
		}
		
		System.out.print("나이 : ");
		age = sc.nextInt();
		sc.nextLine();
		
		mc.insertMember(id, name, password, email, gender.toUpperCase(), age);
	}
	
	public void searchMember() {
		int ch=0;
		
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		
		ch = sc.nextInt();
		sc.nextLine();
		
		switch(ch) {
		case 1:
			searchId();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}
	
	public void searchId() {
		String id;
		String memberInfo;
		
		System.out.println("검색할 아이디 : ");
		id = sc.next();
		sc.nextLine();
		
		memberInfo = mc.searchId(id);
		if(memberInfo == null) {
			System.out.println("검색 결과가 없습니다.");
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(memberInfo);
		}
	}
	
	public void searchName() {
		String name;
		boolean isFound = false;
		Member[] memberList;
		
		System.out.println("검색할 이름 : ");
		name = sc.next();
		sc.nextLine();
		
		memberList = mc.searchName(name);
		for(Member member : memberList) {
			if(member != null) {
				isFound = true;
				System.out.println(member.inform());
			}
		}
		
		if(!isFound)
			System.out.println("검색 결과가 없습니다.");
	}
	
	public void searchEmail() {
		String email;
		boolean isFound = false;
		Member[] memberList;
		
		System.out.println("검색할 이메일 : ");
		email = sc.next();
		sc.nextLine();
		
		memberList = mc.searchEmail(email);
		for(Member member : memberList) {
			if(member != null) {
				isFound = true;
				System.out.println(member.inform());
			}
		}
		
		if(!isFound)
			System.out.println("검색 결과가 없습니다.");
	}
	
	public void updateMember() {
		int ch=0;

		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		
		ch = sc.nextInt();
		sc.nextLine();
		
		switch(ch) {
		case 1:
			updatePassword();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}

	}
	
	public void updatePassword() {
		String id;
		String newPwd;
		
		System.out.println("수정할 회원 id : ");
		id = sc.next();
		sc.nextLine();
		
		System.out.println("변경할 비밀번호 : ");
		newPwd = sc.next();
		sc.nextLine();
		
		if(mc.updatePassword(id, newPwd))
			System.out.println("수정이 성공적으로 되었습니다.");
		else
			System.out.println("존재하지 않는 아이디입니다.");
		
	}
	
	public void updateName() {
		String id;
		String newName;
		
		System.out.println("수정할 회원 id : ");
		id = sc.next();
		sc.nextLine();
		
		System.out.println("변경할 이름 : ");
		newName = sc.next();
		sc.nextLine();
		
		if(mc.updateName(id, newName))
			System.out.println("수정이 성공적으로 되었습니다.");
		else
			System.out.println("존재하지 않는 아이디입니다.");
	}
	
	public void updateEmail() {
		String id;
		String newEmail;
		
		System.out.println("수정할 회원 id : ");
		id = sc.next();
		sc.nextLine();
		
		System.out.println("변경할 이메일 : ");
		newEmail = sc.next();
		sc.nextLine();
		
		if(mc.updateEmail(id, newEmail))
			System.out.println("수정이 성공적으로 되었습니다.");
		else
			System.out.println("존재하지 않는 아이디입니다.");
	}
	
	public void deleteMember() {
		int ch=0;
		
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		
		ch = sc.nextInt();
		sc.nextLine();
		
		switch(ch) {
		case 1:
			deleteOne();
			break;
		case 2:
			deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}
	
	public void deleteOne() {
		String ch;
		String id;
		boolean isFound = false;
		
		System.out.println("삭제할 회원 id : ");
		id = sc.next();
		sc.nextLine();
		
		while(true) {
			System.out.println("정말 삭제하시겠습니까?(y/n) : ");
			ch = sc.next();
			sc.nextLine();
			
			if( ch.equals("Y") || ch.equals("y") ) {
				isFound = mc.delete(id);
				break;
			}
			else if ( ch.equals("N")|| ch.equals("n") )
				break;
		}
		
		if(isFound)
			System.out.println("성공적으로 삭제하였습니다.");
		else
			System.out.println("존재하지 않는 아이디입니다.");
	}
	
	public void deleteAll() {
		String ch;

		while(true) {
			System.out.println("정말 삭제하시겠습니까?(y/n) : ");
			ch = sc.next();
			sc.nextLine();
			
			if( ch.equals("Y") || ch.equals("y") ) {
				mc.delete();
				System.out.println("성공적으로 삭제하였습니다.");
				break;
			}
			else if ( ch.equals("N")|| ch.equals("n") )
				break;
			else
				continue;
		}
	}
	
	public void printAll() {
		Member[] memberList = mc.printAll();
		boolean isFound = false;
		
		for(Member member : memberList) {
			if(member != null) {
				isFound = true;
				System.out.println(member.inform());
			}
		}
		
		if(!isFound) System.out.println("저장된 회원이 없습니다.");
	}
	
}
