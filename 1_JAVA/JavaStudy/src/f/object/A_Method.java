package f.object;

public class A_Method {
	/*
	 * class 내부에 있는 함수를 메소드라고 한다.
	 * 
	 * [ 표현법 ]
	 * 반환형 메소드이름(매개변수) {
	 * 		함수에서 실행할 코드
	 * }
	 * 
	 */
	public static void hiEveryone(int age) {
		System.out.println("힘세고 강한 아침");
		System.out.println("만약 내 나이를 묻는다면 나는 "+age+"세.");
	}
	
	public static void main(String[] args) {
		System.out.println("===== 프로그램 시작 =====");
		hiEveryone(12);
		hiEveryone(13);
		System.out.println("===== 프로그램 끝 =====");
	}
}
