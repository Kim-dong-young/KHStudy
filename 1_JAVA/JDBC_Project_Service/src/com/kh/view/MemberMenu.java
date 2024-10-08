package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

// View : 사용자가 보게될 시각적인 요소(출력 및 입력)
public class MemberMenu {
	// Scanner 객체 여기에 생성하는 이유 : 전역으로 다 입력받을 수 있도록
	private Scanner sc = new Scanner(System.in);
	
	// MemberController 객체 생성 ( 전역에서 바로 요청할 수 있도록 )
	private MemberController mc = new MemberController();

	/*
	 * 사용자가 보게될 첫 화면(메인화면)
	 */
	public void mainMenu() {
		
		while(true) {
			System.out.println("========== 회원관리 프로그램 ==========");
			System.out.println("1. 회원추가"); // 데이터 추가 Create
			System.out.println("2. 회원 전체 조회"); // 데이터 조회 Read
			System.out.println("3. 회원 정보 수정"); // 데이터 변경 Update
			System.out.println("4. 회원 탈퇴"); // 데이터 삭제 Delete
			System.out.println("5. 회원 아이디 검색");
			System.out.println("6. 회원 이름으로 키워드 검색");
			System.out.println("0. 프로그램 종료");

			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				// 회원 추가
				this.inputMember();
				break;
			case 2:
				mc.selectMemberList();
				break;
			case 3:
				this.updateMember();
				break;
			case 4:
				mc.deleteMember(this.inputMemberId());
				break;
			case 5:
				mc.searchMemberById(this.inputMemberId());
				break;
			case 6:
				System.out.print("검색할 키워드를 입력해주세요 : ");
				String keyword = sc.nextLine();
				
				mc.searchMemberByName(keyword);
				break;
			case 0:
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
				return;
			default: 
				System.out.println("메뉴를 잘못 입력하였습니다.");
				
			}
		}
	}
	

	/*
	 * id ~ 취미까지 멤버정보를 입력받아 cotnroller에 전달하는 메소드
	 */
	public void inputMember() {
		
		System.out.println("============== 회원추가 ===============");
		
		String userId = this.inputMemberId();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("성별(M,F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("취미(,로 이어서 작성) : ");
		String hobby = sc.nextLine();
		
		// 회원 추가 요청 -> Controller메소드 요청
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
	}

	/*
	 * 입력한 ID 회원의 pwd, email, phone, address 를 변경한다
	 */
	public void updateMember() {
		System.out.println("============ 회원 정보 변경 =============");
		//(어떤 회원의 정보를 변경할지) id를 통해 -> 비밀번호, 이메일, 전화번호, 주소 변경
		
		String userId = this.inputMemberId();
		
		System.out.print("변경할 비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("변경할 전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("변경할 주소 : ");
		String address = sc.nextLine();
		
		mc.updateMember(userId, userPwd, email, phone, address);
	}
	
	public String inputMemberId() {
		System.out.print("아이디 입력 : ");
		String userId = sc.nextLine();
		
		return userId;
	}
	
	// ------------------------------ 응답화면 ---------------------------------
	
	/**
	 * 서비스 요청 후 처리를 성공적으로 완료했을 때 보게 될 응답화면
	 * @param message : 성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : "+ message);
	}
	
	/**
	 * 서비스 요청 후 처리를 실패했을 때 보게 될 응답화면
	 * @param message : 실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : "+ message);
	}
	
	/**
	 * 조회서비스 요청시 결과가 없을 경우 보게될 응답화면
	 * @param message : 조회결과에 대한 응답메세지
	 */
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
	/**
	 * 조회서비스 요청시 결과가 여러행일 경우 보게될 응답화면
	 * @param list : 조회결과
	 */
	public void displayMemberList(List<Member> list) {
		for(Member m : list) {
			System.out.println(m);
		}
	}


	public void displayMember(Member m) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}
	
	
}
