package com.kh.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.ItemController;
import com.kh.model.vo.items.Item;

public class ItemStoreMenu {
	private Scanner s;
	
	private ItemController ic;
	
	public ItemStoreMenu(Scanner s) {
		super();
		this.s = s;
		ic = ItemController.getInstance();
	}
	
	public void displayItemList(ArrayList<Item> itemList) {
		if(itemList.isEmpty()) {
			System.out.println("판매하는 아이템이 없습니다.");
			return;
		}
		
		for(Item item : itemList) {
			System.out.println(item);
		}
	}
	
	public void mainMenu() {
		int ch = -1;
		
		while (ch != 0) {
			System.out.println("===== 아이템 목록 =====");
			System.out.println(">>> 아이템 사용은 마이페이지에서 가능합니다");
			displayItemList(ic.getItemList());
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
		
	}
}
