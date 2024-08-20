package com.kh.controller;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;

public class MemberController {
	private static MemberController mc;
	
	private MemberService ms;
	
	private MemberController() {
		super();
		ms = MemberService.getInstance();
	}
	
	public static MemberController getInstance() {
		if(mc == null)
			mc = new MemberController();
		return mc;
	}

	public void createUser(String name, String id, String pwd) {
		Member m = new Member(name, id, pwd);
		
		int result = ms.createUser(m);
		
		if(result > 0) {
			System.out.println("회원가입에 성공하였습니다.");
		}
		else {
			System.out.println("회원가입에 실패하였습니다.");
		}
		
	}

	public void loginUser(String id, String pwd) {
		// TODO Auto-generated method stub
		
	}
}
