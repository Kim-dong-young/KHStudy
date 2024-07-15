package h.inherit.ex3;

import java.util.Scanner;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();

	public void mainMenu() {
		int ch=0;

		while(ch != 9) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			ch = sc.nextInt();
			sc.nextLine();
	
			switch (ch) {
			case 1: 
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
	
			}
		}

	}

	public void circleMenu() {
		int ch;

		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		ch = sc.nextInt();
		sc.nextLine();

		switch (ch) {
		case 1: 
			calcCircum();
			break;
		case 2:
			calcCircleArea();
			break;
		case 9:
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");

		}
	}

	public void rectangleMenu() {
		int ch;

		System.out.println("===== 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("3. 메인으로");
		System.out.print("메뉴 번호 : ");
		ch = sc.nextInt();
		sc.nextLine();

		switch (ch) {
		case 1: 
			calcPerimeter();
			break;
		case 2:
			calcRectArea();
			break;
		case 3:
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");

		}
	}

	public void calcCircum() {
		int x;
		int y;
		int rad;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("반지름 : ");
		rad = sc.nextInt();
		sc.nextLine();
		
		System.out.println("원 둘레 : "+cc.calcCircum(x, y, rad));
	}

	public void calcCircleArea() {
		int x;
		int y;
		int rad;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("반지름 : ");
		rad = sc.nextInt();
		sc.nextLine();
		
		System.out.println("원 넓이 : "+cc.calcArea(x, y, rad));
	}

	public void calcPerimeter() {
		int x;
		int y;
		int height;
		int width;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("높이 : ");
		height = sc.nextInt();
		sc.nextLine();
		
		System.out.print("너비 : ");
		width = sc.nextInt();
		sc.nextLine();
		
		System.out.println("사각형 둘레 : "+rc.calcPerimeter(x, y, height, width));
	}

	public void calcRectArea() {
		int x;
		int y;
		int height;
		int width;
		
		System.out.print("x 좌표 : ");
		x = sc.nextInt();
		sc.nextLine();
		
		System.out.print("y 좌표 : ");
		y = sc.nextInt();
		sc.nextLine();
		
		System.out.print("높이 : ");
		height = sc.nextInt();
		sc.nextLine();
		
		System.out.print("너비 : ");
		width = sc.nextInt();
		sc.nextLine();
		
		System.out.println("사각형 넓이 : "+rc.calcArea(x, y, height, width));
	}

}
