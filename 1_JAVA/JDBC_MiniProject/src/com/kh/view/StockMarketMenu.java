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
	
	public boolean displayMemberStock(ArrayList<MemberStock> mStockList) {
		// 조회에 실패할 경우 false 반환
		if(mStockList.isEmpty()) {
			System.out.println("현재 상장된 종목이 없습니다.");
			return false;
		}
		
		for(MemberStock ms : mStockList) {
			System.out.println(ms);
		}
		return true;
	}
	
	public boolean displayShareHeld(ArrayList<Share> shareHeld) {
		// 조회에 실패할 경우 false 반환
		if (shareHeld.isEmpty()) {
			System.out.println("보유중인 주식이 없습니다.");
			return false;
		}
		
		for(Share sh : shareHeld) {
			System.out.println(sh);
		}
		return true;
	}
	
	public void mainMenu() {
		int ch = -1;
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
		// 조회에 실패할 경우 false 반환
		if (!displayMemberStock( mc.getMemberStockList(mc.getCurrentMember())) ) {
			new AlertMenu().getMemberStockListFail();
			return;
		}
		
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
		// 조회에 실패할 경우 false 반환
		if (!displayShareHeld( mc.getMemberShareHeld(mc.getCurrentMember())) ) {
			return;
		}
		
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
		
		mc.sellStock(mc.getCurrentMember(),sellQuantity, sellStockName);
	}
	
}
