package com.kh.view;

public class AlertMenu {
	
	public AlertMenu() {
		super();
	}
	
	//  로그인 및 회원가입 관련 알림
	public void registerSuccess() {
		System.out.println("회원가입에 성공하였습니다.");
	}
	
	public void registerFail() {
		System.out.println("회원가입에 실패하였습니다.");
	}
	
	public void loginSuccess() {
		System.out.println("로그인에 성공하였습니다.");
	}
	
	public void loginFail() {
		System.out.println("로그인에 실패하였습니다.");
	}
	
	// 멤버 정보 조회 관련
	public void getMemberStockListFail() {
		System.out.println("주식 목록을 불러오는데 실패했습니다.");
	}
	
	public void getMemberTradeLogFail() {
		System.out.println("거래 기록을 불러오는데 실패했습니다.");
	}
	
	
	// 주식 거래 관련
	public void buyStockSuccess() {
		System.out.println("구매에 성공하였습니다.");
	}
	
	public void buyStockFail() {
		System.out.println("구매에 실패하였습니다.");
	}
	
	public void sellStockSuccess() {
		System.out.println("판매에 성공하였습니다.");
	}

	public void sellStockFail() {
		System.out.println("판매에 실패하였습니다.");
	}
	
	
}
