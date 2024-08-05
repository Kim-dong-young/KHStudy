package f.object;

public class A_Method2 {
	
	public static void main(String[] args) {
		System.out.println(adder(123,444));
		System.out.println(adder(90));
		System.out.println(adder(90.0));
	}
	//	반환형 메소드이름(매개 변수)
	public static int adder(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	
	// 매개변수의 개수 또는 타입이 다르면, 메소드를 구분할 수 있다.(오버로딩)
	public static int adder(int num) {
		return num+10;
	}
	
	public static int adder(double num) {
		return (int)(num+1);
	}
	
	/* 매개변수가 아닌, 반환형으로 메소드 구분은 불가능하다
	 * 컴퓨터가 int 받았을때 double adder에 넣어야할지, int adder에 넣어야할지 알 수 없다!
	 * public static double adder(int num){
	 * 		return num + 10.0;
	 * }
	 */
	
}
