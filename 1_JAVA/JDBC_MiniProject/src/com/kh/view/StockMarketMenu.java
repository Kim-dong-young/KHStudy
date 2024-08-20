package com.kh.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StockMarketMenu {
	private Scanner s;
	
	public StockMarketMenu(Scanner s) {
		this.s = s;
	}
	
	public void chartMenu() {
		
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

				break;
			case 2:

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
		
		// TODO result 받아오기
		int result = 0;
		
		switch(result) {
		case 200:
			System.out.println("구매에 성공했습니다!");
			break;
		case 400:
			System.out.println("잘못된 주문입니다.");
			break;
		case 403:
			System.out.println("잔액이 부족합니다.");
			break;
		}
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
	
	
	
}
