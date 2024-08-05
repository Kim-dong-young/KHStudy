package test240723.object2;

import java.util.Scanner;

public class NumberMenu {
	public void menu() {
		NumberController nc = new NumberController();
		
		try (Scanner sc = new Scanner(System.in);){
			System.out.print("정수 1 :");
			int num1 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("정수 2 :");
			int num2 = sc.nextInt();
			sc.nextLine();
			
			System.out.printf("%d는 %d의 배수인가 ? %b",num1,num2,nc.checkDouble(num1, num2));
		} catch( NumRangeException e ) {
			e.printStackTrace();
		}
	}
}
