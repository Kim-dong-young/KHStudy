package _miniproject.view;

import java.util.Scanner;

import _miniproject.controller.MemberController;

public class ItemStoreMenu {
	private MemberController mc = MemberController.getInstance();
	private Scanner s = new Scanner(System.in);
	
	
	public ItemStoreMenu() {
		
	}
	public void storeMenu() {
		System.out.println("===== 아이템 상점 =====");
	}
}
