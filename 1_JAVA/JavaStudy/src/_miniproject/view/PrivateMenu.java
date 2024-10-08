package _miniproject.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

import _miniproject.controller.ItemController;
import _miniproject.controller.MemberController;
import _miniproject.controller.StockController;
import _miniproject.controller.TradeLogController;
import _miniproject.vo.Shares;
import _miniproject.vo.Stock;
import _miniproject.vo.items.Item;

public class PrivateMenu {
	private Scanner s;
	
	private TradeLogController tc = TradeLogController.getInstance();
	private StockController sc = StockController.getInstance();
	private MemberController mc = MemberController.getInstance();
	private ItemController ic = ItemController.getInstance();
	
	public PrivateMenu(Scanner s) {
		super();
		this.s = s;
	}

	public void mainMenu() {
		int ch = 0;
		
		while(ch != 9) {
			System.out.printf("===== %s 님의 마이페이지 =====\n",mc.getCurrentMember().getMemberName());
			System.out.println("1. 보유중인 주식 확인");
			System.out.println("2. 보유중인 아이템 확인");
			System.out.println("3. 거래 기록 확인");
			System.out.println("9. 뒤로 가기");
			
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
				shareHeldMenu();
				break;
			case 2:
				itemMenu();
				break;
			case 3:
				tc.showTradeLog(mc.getCurrentMember().getMemberUID());
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
	
	public void shareHeldMenu() {
		HashMap<String, Shares> shareHeld = mc.getShareHeld();
		int totalProfit = 0;
		double totalPrice = 0; 
		
		for(Entry<String, Shares> entry : shareHeld.entrySet()) {
			Shares share = entry.getValue();
			System.out.printf("종목 : %s , 수량 : %d , 매입가 : %d | 수익 : %d ( %.2f %%)\n",
					entry.getKey(), share.getQuantity(), share.getPurchasePrice(), 
					(sc.getStock(entry.getKey()).getStockPrice() - share.getPurchasePrice()) * share.getQuantity(),
					(double)(sc.getStock(entry.getKey()).getStockPrice() - share.getPurchasePrice()) /  share.getPurchasePrice() * 100 );
			
			totalProfit += share.getPurchasePrice() * share.getQuantity();
			totalPrice += sc.getStock(entry.getKey()).getStockPrice() * share.getQuantity();
		}
		
		if(!shareHeld.isEmpty()) {
			System.out.printf("총 수익 : %d ( %.2f %%)\n", (int)(totalPrice - totalProfit) , (double)( (totalPrice - totalProfit) / totalProfit * 100 ) );
		}
	}
	
	public void itemMenu() {
		int ch = -1;
		
		while(ch != 0) {
			HashMap<Item, Integer> itemList = mc.getCurrentMember().getItemList();
			System.out.println("===== 보유중인 아이템 =====");
			for(Entry<Item, Integer> entry : itemList.entrySet()) {
				System.out.printf("(%s번)%s : %s\n",entry.getKey().getItemNum(), entry.getKey().getName(), entry.getValue());
			}
			System.out.println("0. 마이페이지로 돌아가기");
			System.out.print("사용할 아이템 번호 : ");
			
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}
			
			
			if(ch == 0) return;
			
			if( !mc.useItem(ic.getItem(ch)) ) {
				System.out.println("아이템이 존재하지 않습니다.");
			}
		}
		
	}
}
