package m.api.ex1;

public class C_Wrapper {
	/*
	 * Wrapper 클래스
	 * 
		 * boolean(Boolean)
		 * char(Character)
		 * byte(Byte)
		 * short(Short)
		 * int(Integer)
		 * long(Long)
		 * float(Float)
		 * double(Double)
	 * 
	 * => 기본자료형을 객체로 포장해 줄 수 있는 클래스가 래퍼클래스이다.
	 * => 기본자료형을 객체로 표현해야할 경우
	 * 	- 메소드 호출해야 할 때, 매개변수가 객체타입을 요구하면 원시타입을 못받는다. -> 이럴 때 사용
	 *  - 다형성을 적용시키고 싶을 때
	 * 

	 * 
	 */
	
	public void method01() {
		System.out.println("\n===== Wrapper 클래스 =====");
		// Boxing : 기본자료형 -> Wrapper 클래스 자료형
		int num1 = 10;
		int num2 = 20;
		
		// System.out.println(num1.equals(num2));
		
		// 1. 객체생성 구문을 통한 방법
		Integer i1 = new Integer(num1); // num1 => i1
		Integer i2 = new Integer(num2); // num2 => i2
		
		// Integer의 toString은 오버라이드 되어있다.
		System.out.println("Integer i1 = new Integer(num1) : "+i1);
		System.out.println("Integer i2 = new Integer(num2) : "+i2);
		
		// Integer의 equals는 오버라이딩 되어있다. ( 주소비교가 아닌 값 비교 )
		System.out.println("i1.equals(i2) : "+i1.equals(i2));
		// 두 값의 대소비교 : 앞쪽이 크면 1, 뒤쪽이 크면 -1, 같으면 0 반환
		System.out.println("i1.compareTo(i2) : " + i1.compareTo(i2)); 
		
		// 2. 객체생성 하지않고 곧바로 대입 ( AutoBoxing )
		Integer i3 = num1;
		System.out.println("Integer i3 = num1 : "+ i3);
		
		// 객체생성을 통해서 반드시 변환해야하는 경우 -> 문자열을 Integer타입으로 변환하고 싶을 때
		Integer i4 = Integer.parseInt("123");
		Integer i5 = new Integer("123");
		
		// UnBoxing : Wrapper클래스 자료형 -> 기본 자료형
		
		// 1. 해당 Wrapper클래스에서 제공하는 xxxValue() 메소드를 통해서 가능
		int num3 = i3.intValue();
		int num4 = i4.intValue();
		
		// 2. 메소드 사용하지 않고 바로 대입하는 방법
		int num5 = i5;
		
		// 기본자료형 < -- > String
		System.out.println("\nString -> 기본자료형");
		String str1 = "10";
		String str2 = "15.5";
		
		System.out.println("str1 + str2 = "+ str1 + str2);
		
		// String -> 기본자료형
		// 	 "10" -> 10
		// "15.5" -> 15.5
		// 해당 Wrapper클래스.parseXXX() 사용
		int i = Integer.parseInt(str1);
		double d = Double.parseDouble(str2);
		System.out.println("Integer.parseInt(str1) + Double.parseDouble(str2) : "+ (i + d));
		
		// 기본자료형 -> String
		System.out.println("\n기본자료형 -> String");
		System.out.println("i + \"\" : "+i + "");
		System.out.println("String.valueOf(int) : " + String.valueOf(i));
		System.out.println("String.valueOf(double) : "+String.valueOf(d));
	}
}
