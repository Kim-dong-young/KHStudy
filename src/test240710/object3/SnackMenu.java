package test240710.object3;

import java.util.Scanner;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		String kind;
		String name;
		String flavor;
		int numOf;
		int price;
		
		
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		kind = sc.next();
		sc.nextLine();
		
		System.out.print("이름 : ");
		name = sc.next();
		sc.nextLine();
		
		System.out.print("맛 : ");
		flavor = sc.next();
		sc.nextLine();
		
		System.out.print("개수 : ");
		numOf = sc.nextInt();
		sc.nextLine();
		
		System.out.print("가격 : ");
		price = sc.nextInt();
		sc.nextLine();
		
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		String answer = sc.next();
		sc.nextLine();
		
		if(answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') System.out.println(scr.confirmData());
	}
}
