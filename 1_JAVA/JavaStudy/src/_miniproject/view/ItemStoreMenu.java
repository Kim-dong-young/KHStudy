package _miniproject.view;

import java.util.Map.Entry;
import java.util.InputMismatchException;
import java.util.Scanner;

import _miniproject.controller.ItemController;
import _miniproject.controller.MemberController;
import _miniproject.vo.items.Item;

public class ItemStoreMenu {
	private Scanner s;
	
	private MemberController mc = MemberController.getInstance();
	private ItemController ic = ItemController.getInstance();

	public ItemStoreMenu(Scanner s) {
		super();
		this.s = s;
	}

	public void mainMenu() {
		int ch = -1;
		
		while (ch != 0) {
			System.out.println("===== 아이템 목록 =====");
			System.out.println(">>> 아이템 사용은 마이페이지에서 가능합니다");
			for(Entry<String, Item> entry : ic.getItemList().entrySet()) {
				System.out.printf("%s : %s\n",entry.getKey(), entry.getValue().getName());
			}
			System.out.println("0. 메뉴로 돌아가기");
			System.out.print("구매할 아이템 번호 입력 : ");
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}

			if (ch == 0) return;
 			
			purchaseMenu(ch);
		}
	}
	
	public void purchaseMenu(int itemNum) {
		switch(itemNum) {
		case 1:
			System.out.println(">>> 오늘의 운세");
			System.out.println("오늘의 운세를 점쳐봅니다.");
			System.out.println("(주가에 영향을 미치진 않습니다.)");
			System.out.print("\n구매하시겠습니까? ( y를 입력해 구매 ) : ");
			break;
		case 2:
			System.out.println(">>> 주가 예측 아이템");
			System.out.println("랜덤한 종목의 다음날 변동폭을 근사하게 알아냅니다.");
			System.out.println("(정확하게 알아내진 않습니다.)");
			System.out.print("\n구매하시겠습니까? ( y를 입력해 구매 ) : ");
			break;
		default :
			System.out.println("아이템을 찾지 못했습니다.");
			return;
		}
		
		char ch = s.next().toUpperCase().charAt(0);
		
		if(ch == 'Y') {
			mc.purchaseItem(ic.getItem(itemNum));
			System.out.println("구매에 성공했습니다.");
		}
		else {
			System.out.println("구매를 취소했습니다.");
		}
	}
}
