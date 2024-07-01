package a.basic;
import java.util.Scanner;

public class Practice2 {
	/*
	 * 키보드로 가로, 세로 값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력하세요
	 * 면적 : 가로 * 세로
	 * 둘레 : (가로 + 세로) * 2
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("가로와 세로 입력 : ");
		float width = s.nextFloat();
		float height = s.nextFloat();
		s.nextLine();
		
		System.out.println("면적 : " + width * height);
		System.out.println("둘레 : " + (width + height) * 2 +"\n");
		
		System.out.printf("면적 : %.2f\n",(width * height));
		System.out.printf("둘레 : %.2f",(width + height) * 2);
		
	}
}
