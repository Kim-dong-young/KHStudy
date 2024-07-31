package _miniproject.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

import _miniproject.controller.ItemController;
import _miniproject.controller.MemberController;
import _miniproject.vo.items.Item;

public class PrivateMenu {
	private MemberController mc = MemberController.getInstance();
	private ItemController ic = ItemController.getInstance();
	private Scanner s = new Scanner(System.in);
	
	public void infoMenu() {
		int ch = 0;
		
		while(ch != 9) {
			System.out.printf("===== %s 님의 마이페이지 =====\n",mc.getCurrentMember().getMemberName());
			System.out.println("1. 보유중인 주식 확인");
			System.out.println("2. 보유중인 아이템 확인");
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
				mc.showStockList();
				break;
			case 2:
				itemMenu();
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
	
	public void itemMenu() {
		int ch = -1;
		
		while(ch != 9) {
			HashMap<Item, Integer> itemList = mc.getCurrentMember().getItemList();
			System.out.println("===== 보유중인 아이템 =====");
			for(Entry<Item, Integer> entry : itemList.entrySet()) {
				System.out.printf("%s : %s",entry.getKey().getName(), entry.getValue());
			}
			System.out.println("0. 마이페이지로 돌아가기");
			System.out.print("사용할 아이템 번호 : ");
			ch = s.nextInt();
			s.nextLine();
			
			if(ch == 0) return;
			
			mc.getCurrentMember().useItem(ic.getItem(ch));
		}
		
	}
}
