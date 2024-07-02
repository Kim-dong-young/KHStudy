package c.control;

import java.util.Scanner;

public class A_if2 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		/*


		// * 나이를 입력받아
		// * 13세 이하: 어린이
		// * 13세 초과 19세 이하 : 청소년
		// * 19세 초과 : 성인
		// * 
		// * xx세는 xxx에 속합니다.
		// * 를 출력해보자

		
		int age = s.nextInt();
		s.nextLine();
		
		if(age <= 13) {
			System.out.printf("%2d세는 어린이에 속합니다.",age);
		}
		else if(age > 13 && age <= 19) {
			System.out.printf("%2d세는 청소년에 속합니다.",age);
		}
		else {
			System.out.printf("%2d세는 성인에 속합니다.",age);
		}

		*/
		
		/*
		// 성별을 (m/f)(대소문자 상관x)로 입력받아 남학생인지 여학생인지 출력하는 프로그램 작성
		// 성별(m/f) : X
		// 여학생입니다 / 남학생입니다 / 잘못입력하셨습니다.
		
		System.out.print("성별(m/f) : ");
		char sex = s.next().charAt(0);
		
		if (sex == 'm' || sex =='M') {
			System.out.println("남");
		} else if ( sex=='f' || sex =='F') {
			System.out.println("여");
		} else {
			System.out.println("잘못입력");
		}
		*/
		
		// 양의 정수를 입력받아
		// 짝수인지 홀수인지 출력하는 프로그램을 작성해라
		
		// 정수입력 : xx
		// 짝수 / 홀수 / 양수가 아님
		
		System.out.print("정수입력 : ");
		int num = s.nextInt();
		
		if(num > 0 &&  num % 2 == 0) {
			System.out.println("짝");
		} else if (num > 0) {
			System.out.println("홀");
		} else {
			System.out.println("양수가 아님");
		}
		
		s.close();
	}

}
