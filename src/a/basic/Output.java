package a.basic;

public class Output {
	public static void main(String[] args) {
		//한줄을 출력하고 개행을 하는 출력문
		System.out.println("안녕하세요.");
		System.out.println("김동영입니다.");
		
		//단순하게 출력을 할 때 사용하는 출력문
		System.out.print("제 성별은\n\n");
		//print에서 개행을 하고 싶을 때는 \n을 사용한다.
		System.out.print("남자입니다.\n");
		
		String name = "김동영";
		System.out.println("안녕하세요 저는 "+name+"입니다.");
		
		//문자열 출력을 편하게 하기위해 포맷을 지정해서 출력할 수도 있다.
		//System.out.printf(문자열 포맷, 값1, 값2);
		/*
		 * %d : 정수
		 * %c : 문자
		 * %s : 문자열
		 * %f : 실수( 소수점 자리수 지정가능, 예시 : %.2f 는 소숫점 2자리까지 출력 )
		 * */
		System.out.printf("안녕하세요 저는 %s입니다.", name);
		
	}

}
