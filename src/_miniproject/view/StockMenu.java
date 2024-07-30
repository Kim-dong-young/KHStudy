package _miniproject.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import _miniproject.controller.MemberController;
import _miniproject.controller.StockController;

public class StockMenu {
	Scanner s = new Scanner(System.in);
	private StockController sc = StockController.getInstance();
	private MemberController mc = MemberController.getInstance();
	
	public void chartMenu() {
		sc.showStockList();
	}
	
	public void marketMenu() {
		int ch = 0;
		
		while(ch != 9) {
			System.out.printf("===== 주식 시장 =====\n");
			System.out.println("1. 구매하기");
			System.out.println("2. 판매하기");
			System.out.println("9. 뒤로가기");
			
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
			case 9:
				System.out.println("메뉴로 돌아갑니다.");
				continue;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	public void buyStockMenu() {
		sc.showStockList();
		int buyQuantity = 0;
		System.out.print("\n구매할 종목과 수량 입력(띄어쓰기로 구분) : ");
		String buyStockName = s.next();
		
		try {
			buyQuantity = s.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			return;
		} finally {
			s.nextLine();
		}
		
		int result = mc.buyStock(buyStockName, buyQuantity);
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
		mc.showStockList();
		int sellQuantity = 0;
		System.out.print("\n판매할 종목과 수량 입력(띄어쓰기로 구분) : ");
		String sellStockName = s.next();

		try {
			sellQuantity = s.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			return;
		} finally {
			s.nextLine();
		}
		
		int result = mc.sellStock(sellStockName, sellQuantity);
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