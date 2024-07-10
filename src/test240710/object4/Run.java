package test240710.object4;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		Snack sn = new Snack(kind, name, flavor, numOf, price);
		System.out.println("저장되었습니다.");
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		char ch = sc.next().charAt(0);
		
		if(ch == 'y' || ch == 'Y') System.out.println(sn.information());
	}

}
