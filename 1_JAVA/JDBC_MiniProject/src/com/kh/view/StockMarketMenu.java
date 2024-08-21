package com.kh.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.controller.MemberStockController;
import com.kh.controller.ShareController;
import com.kh.model.vo.MemberStock;
import com.kh.model.vo.Share;

public class StockMarketMenu {
	private Scanner s;
	private MemberController mc = MemberController.getInstance();
	
	public StockMarketMenu() {
		super();
	}
	
	public StockMarketMenu(Scanner s) {
		this.s = s;
	}
	
	public void chartMenu(ArrayList<MemberStock> mStockList) {
		
		if(mStockList.isEmpty()) {
			System.out.println("현재 상장된 종목이 없습니다.");
			return;
		}
		
		for(MemberStock ms : mStockList) {
			System.out.println(ms);
		}
	}
	
	public void shareHeldMenu(ArrayList<Share> shareHeld) {
		if (shareHeld.isEmpty()) {
			System.out.println("보유중인 주식이 없습니다.");
			return;
		}
		
		for(Share sh : shareHeld) {
			System.out.println(sh);
		}
	}
	
	public void mainMenu() {
		int ch = -1;
		// TODO MemberStockDao , 프로시저 고쳐야함
		while(ch != 0) {
			System.out.println("===== 주식 시장 =====");
			System.out.println("1. 구매하기");
			System.out.println("2. 판매하기");
			System.out.println("0. 뒤로가기");
			
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}
			
			switch(ch) {
			case 1:
				chartMenu(mc.getMemberStockList());
				buyStockMenu();
				break;
			case 2:
				sellStockMenu();
				break;
			case 0:
				System.out.println("메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	public void buyStockMenu() {
		int buyQuantity = 0;
		
		System.out.print("\n구매할 종목과 수량 입력(띄어쓰기로 구분) : ");
		String buyStockName = s.next().toUpperCase();
		
		try {
			buyQuantity = s.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			return;
		} finally {
			s.nextLine();
		}
		
		mc.buyStock(mc.getCurrentMember(),buyQuantity, buyStockName);
	}
	
	public void sellStockMenu() {
		
		int sellQuantity = 0;
		System.out.print("\n판매할 종목과 수량 입력(띄어쓰기로 구분) : ");
		String sellStockName = s.next().toUpperCase();

		try {
			sellQuantity = s.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			return;
		} finally {
			s.nextLine();
		}
		
		// TODO result 받아오기
		int result = 0;
		
		switch(result) {
		case 200:
			System.out.println("판매에 성공했습니다!");
			break;
		case 400:
			System.out.println("잘못된 수량입니다.");
			break;
		case 403:
			System.out.println("수량이 부족합니다.");
			break;
		}
	}
	
	public void buyStockSuccess() {
		System.out.println("구매에 성공하였습니다.");
	}
	
	public void buyStockFail() {
		System.out.println("구매에 실패하였습니다.");
	}
	
	
}
