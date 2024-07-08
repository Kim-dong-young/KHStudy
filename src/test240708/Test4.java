package test240708;

public class Test4 {
	// main의 argument로 1자리 정수형(1부터 9까지만) 값을 2개 입력받아 4칙연산 결과를 출력한다.
	// 입력값은 모두 int 형으로 처리한다.
	public static void main(String[] args) {
		//Calculator.java 우클릭 -> Run as -> Run configuration
		//Arguments -> Program arguments 에서 매개변수 입력 가능하다}
		int num1 = Character.getNumericValue(args[0].charAt(0));
		int num2 = Character.getNumericValue(args[1].charAt(0));
		
		if(num1 > 0 && num2 > 0) { // Character.getNumericValue return -1 if args has no numeric value;
			System.out.println("합 :"+ (int)(num1 + num2));
			System.out.println("차 :"+ (int)(num1 - num2));
			System.out.println("곱 :"+ (int)(num1 * num2));
			System.out.println("나누기 :"+ ( (num2 <= 0) ? (int)(num1 / num2) : 0) );
		}
	}

}
