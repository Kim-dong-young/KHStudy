package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;
import com.kh.view.MemberMenu;

// Controller : View를 통해서 사용자가 요청한 기능에 대해 처리를 담당
//				해당 메소드로 전달된 데이터를 가공처리(객채 생성 등등...) 후 DAO로 전달하여 호출
//				DAO로부터 반환받은 결과가 성공인지 실패인지에 따라서 응답화면 결정( View 메소드 호출 )
public class MemberController {
	
	/**
	 * 사용자 추가 요청을 처리해주는 메소드
	 * @param userId ~ hobby : 사용자가 입력했던 정보들이 담겨있는 매개변수
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender, String age, String email, String phone,
			String address, String hobby) {
		// View에서 전달받은 값을 바로 DAO쪽으로 전달 X
		// 하나의 객체로 만들어서 전달 ( Member(vo) ) -> Tip. 객체에 넣을 값이 많으면 생성자, 적으면 getter/setter로 설정하면 편하다.
		
		Member m = new Member(userId, userPwd, userName, gender, Integer.parseInt(age), email, phone, address, hobby);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) { // 추가성공 -> 성공 화면 출력
			new MemberMenu().displaySuccess("성공적으로 회원 정보 추가되었습니다.");
		} else { // 추가실패 -> 실패 화면 출력
			new MemberMenu().displayFail("회원 정보 추가 실패했습니다.");
		}
	}
	
	/**
	 * 회원을 전부 조회하는 메소드
	 */
	public void selectMemberList() {
		List<Member> list = new MemberService().selectMemberList();
		
		// 조회된 결과에 따라서 사용자가 보게될 응답화면 지정
		if(list.isEmpty()) { // list가 비어있을 경우
			new MemberMenu().displayNoData("전체 조회 결과가 없습니다.");
		} else { // 조회된 결과가 있을 때
			new MemberMenu().displayMemberList(list);
		}
	}

	public void updateMember(String userId, String userPwd, String email, String phone, String address) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = new MemberService().updateMember(m);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원정보 수정되었습니다.");
		} else {
			new MemberMenu().displayFail("회원정보 수정에 실패하였습니다.");
		}
	}

	public void deleteMember(String userId) {
		Member m = new Member();
		m.setUserId(userId);
		
		int result = new MemberService().deleteMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 탈퇴에 성공했습니다.");
		} else {
			new MemberMenu().displayFail("회원 탈퇴에 실패했습니다.");
		}
	}

	public void searchMemberById(String userId) {
		Member m = new MemberService().searchMemberById(userId);
		if( m == null ) {
			new MemberMenu().displayNoData(userId + "에 해당하는 조회결과가 없습니다.");
		} else {
			new MemberMenu().displayMember(m);
		}
	}

	public void searchMemberByName(String keyword) {
		ArrayList<Member> list = new MemberService().searchMemberByName(keyword);
		if( list.isEmpty() ) {
			new MemberMenu().displayNoData(keyword + "에 해당하는 조회결과가 없습니다.");
		} else {
			new MemberMenu().displayMemberList(list);
		}
	}
	
}
