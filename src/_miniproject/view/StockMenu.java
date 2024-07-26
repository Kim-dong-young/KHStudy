package _miniproject.view;

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
			System.out.printf("===== 주식 시장 =====\n",mc.getCurrentMember().getMemberName());
			System.out.println("1. 구매하기");
			System.out.println("2. 판매하기");
			System.out.println("9. 뒤로가기");
			ch = s.nextInt();
			
			switch(ch) {
			case 1:
				buyStockMenu();
				break;
			case 2:
				sellStockMenu();
				break;
			case 9:
				System.out.println("마이페이지에서 나갑니다.");
				continue;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	public void buyStockMenu() {
		sc.showStockList();
		System.out.print("\n구매할 종목과 수량 입력(띄어쓰기로 구분) : ");
		String buyStockName = s.next();
		int buyQuantity = s.nextInt();
		s.nextLine();
		
		int result = mc.buyStock(buyStockName, buyQuantity);
		switch(result) {
		case 200:
			System.out.println("구매에 성공했습니다!");
			break;
		case 400:
			System.out.println("잘못된 수량입니다.");
			break;
		case 403:
			System.out.println("잔액이 부족합니다.");
			break;
		}
	}
	
	public void sellStockMenu() {
		mc.showStockList();
		System.out.print("\n판매할 종목과 수량 입력(띄어쓰기로 구분) : ");
		String sellStockName = s.next();
		int sellQuantity = s.nextInt();
		s.nextLine();
		
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