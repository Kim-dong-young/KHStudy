package d.loop;

import java.util.Scanner;

public class A_for {
	/*
	 * <반복문>
	 * 프로그램 흐름을 제어하는 제어문 중 하나
	 * 어떤 실행코드르 반복적으로 수행시켜 준다.
	 * 
	 * 크게 두 종류로 나뉜다 ( for / while(do-while) )
	 * 
	 *  * for문
	 *  for(초기식; 조건식; 증감식){ // 반복 횟수를 지정하기 위해서 제시하는 것들
	 *  	반복적으로 실행시키고자 하는 코드 더미
	 *  }
	 *  
	 *  - 초기식 : 반복문이 수행될 떄 "처음에 단 한번만 실행하는 구문"
	 *  		 (반복문 안에서 사용 될 변수를 선언 및 초기화하는 작업)
	 *  
	 *  - 조건식 : "반복문이 수행될 조건"을 작성하는 구문
	 *  		  조건식이 true일 경우 해당 반복을 실행
	 *  		  조건식이 false일 경우 반복문을 탈출
	 *  		  (보통 초기식에서 제시된 변수를 가지고 조건식을 정함)
	 *  
	 *  - 증감식 : 반복문을 제어하는 변수 값을 증감시키는 구문
	 *  		 (보통 초기식에 제시된 변수를 가지고 증감을 시킴)
	 *  
	 *  tip
	 *  for문 안에 초기식, 조건식, 증감식 각각 생략 가능하다(단, 생략해서 쓰는 경우가 없다, while 쓰지 그럴바에..) 
	 */
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		/*
		System.out.println("안녕?");
		System.out.println("안녕?");
		System.out.println("안녕?");
		System.out.println("안녕?");
		System.out.println("안녕?");
		*/
		
		int i=0;
		
		/*
		// 5번 반복하는 반복문
		for(i=0;i<5;i++) {
			System.out.println("안녕?");
		}
		*/
		
		/*
		// 1~5까지 순차적으로 출력하세요 (1 2 3 4 5)
		for(i=0;i<5;i++) {
			System.out.print(i+1+" ");
		}
		*/
		
		/*
		// 5~1 까지 순차적으로 출력
		for(i=5;i>0;i--) {
			System.out.print(i+" ");
		}
		*/
		
		/*
		// 정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력해라
		// 정수입력 : 6
		// 1 2 3 4 5 6
		
		System.out.print("정수입력 : ");
		int num = s.nextInt();
		
		for(i=0; i<num; i++) {
			System.out.print(i+1+" ");
		}
		*/
		
		/*
		// 1~10 숫자중 홀수만 출력
		// 1 3 5 7 9
		for(i=1; i<10; i+=2) {
			System.out.print(i+" ");
		}
		*/
		
		/*
		// 1부터 100까지의 총 합을 구해라
		// 1 + 2 + 3 ... 100
		
		int sum = 0;
		for(i=1; i<=100; i++) {
			sum+=i;
		}
		System.out.println(sum);
		System.out.println(100*101/2);
		*/
		
		// 정수 n을 입력받아 1부터 n까지 1씩 증가하며 모든 수를 더해서 출력해라
		// 정수입력 : 5
		// 1부터 5까지의 합 : 15
		
		/*
		System.out.print("정수입력 : ");
		int num = s.nextInt();
		
		int sum=0;
		for(i=1; i<=num; i++) {
			sum+=i;
		}
		System.out.printf("1부터 %d까지의 합 : %d",num, sum);
		*/
		
		/*
		// java.lang.Math 클래스에서 제공하는 random() 메소드 호출하면 매번 다른 랜덤값을 받을 수 있다.
		// Math.random() 호출시 -> 0 <= random값 < 1 사이의 값(double 형) 반환
		
		System.out.println(Math.random());
		int num = (int)(Math.random() * 10 + 1); // 원하는 자릿수만큼 곱하고, 시작하고 싶은 숫자를 더하면
		System.out.println(num);                 // 정수값을 얻을 수 있다
		*/
		
		/*
		// random(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한 값을 출력하세요.
		// random 수 : 5
		// 1~5까지의 합 : 15
		
		int randNum = (int)(Math.random() * 10 + 1);
		int sum = 0;
		for(i=1; i<=randNum; i++) {
			sum+=i;
		}
		System.out.println("1~"+randNum+"까지의 합 : "+sum);
		*/
		
		/*
		// random(5~50)한 숫자 n을 생성해서 1부터 n까지의 숫자 중 짝수만 출력해라(50 포함)
		// random 수 : 10
		// 2 4 6 8
		
		int maxNum = (int)(Math.random() * 46 + 5 );
		System.out.println("random 수 : "+ maxNum);
		for(i=1; i<maxNum; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}
		*/
		
		/*
		String str = "Hello";
		
		// 각 인덱스별 문자 출력
		// H -> str.charAt(0);
		// e -> str.charAt(1);
		// l -> str.charAt(2);
		// l -> str.charAt(3);
		// o -> str.charAt(4);
		//
		// 문자열.length() : 문자열의 길이를 구하는 방법
		
		System.out.println(str.length());
		for(i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		*/
		
		/*
		// 사용자에게 문자열을 입력받아 해당 문자열의 짝수자리 글자만 출력
		// 문자열 입력 : hello
		
		System.out.print("문자열 입력 : ");
		String str = s.nextLine();
		//출력하고자 하는 자리는 짝수지만, 출력해야하는 인덱스는 홀수임에 주의하자.
		for (i = 1; i < str.length(); i+=2) {
			System.out.print(str.charAt(i));
		}
		*/
		
		// 구구단 2단을 출력해보자
		// 2 * 1 = 2
		// ...
		// 2 * 9 = 18
		
		for(i=1;i<10;i++) {
			System.out.println("2 * "+i+" = "+ 2*i );
		}
		
		
		s.close();
	}

}
