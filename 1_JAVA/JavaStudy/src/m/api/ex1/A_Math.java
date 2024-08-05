package m.api.ex1;
import java.lang.*; // 내가 직접 import 하지 않아도, 무조건 import 된다.

public class A_Math {
	// java.lang.Math
	// - 모든 필드가 상수 필드, 모든 메소드가 static 메소드
	
	public void method01() {
		System.out.println("===== Math 클래스 =====");
		// 상수필드
		System.out.println("파이 : "+Math.PI);
		
		// 랜덤수
		System.out.println("랜덤(0 ~ 0.99999) : " + Math.random());
		
		// 절대값
		System.out.println("절대값 : " + Math.abs(-10));
		
		double num2 = 4.49;
		// 올림
		System.out.println("올림 : " + Math.ceil(num2));
		
		// 반올림
		System.out.println("반올림 : " + Math.round(num2));
		
		// 버림
		System.out.println("버림 : " + Math.floor(num2));
		
		// 제곱
		System.out.println("2의 10제곱 : " + Math.pow(2,10));
		
		
	}
}
