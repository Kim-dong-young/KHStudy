package test01.t240703;

import java.util.Scanner;

public class T_03 {

	public static void main(String[] args) {
		/*
		 * 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
		 * 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
		 * (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
		 * 합격 했을 경우 과목 별 점수와 합계, 평균, "축하합니다, 합격입니다!"를 출력하고
		 * 불합격인 경우에는 "불합격입니다."를 출력하세요.
		 * 
		 * ex 1.			ex 2.
		 * 국어점수 : 88		국어점수 : 88
		 * 수학점수 : 50		수학점수 : 50
		 * 영어점수 : 40		영어점수 : 45
		 * 불합격입니다.		국어 : 88
		 * 					수학 : 50
		 * 					영어 : 45
		 * 					합계 : 183
		 * 					평균 : 61.0
		 * 					축하합니다, 합격입니다!
		 * 
		 */
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int korScore = s.nextInt();
		System.out.print("수학점수 : ");
		int mathScore = s.nextInt();
		System.out.print("영어점수 : ");
		int engScore = s.nextInt();
		
		//정수 / 정수 연산 결과는 항상 정수임에 유의!!! 한쪽을 실수로 만들어줘야 실수값이 나온다
		double avgScore = (korScore + mathScore + engScore) / 3.0;
		
		if((korScore >= 40 && mathScore >= 40 && engScore >= 40) && avgScore >= 60) {
			System.out.println("국어 : "+korScore);
			System.out.println("수학 : "+mathScore);
			System.out.println("영어 : "+engScore);
			System.out.println("합계 : "+ ( korScore + mathScore + engScore ));
			System.out.printf("평균 : %.1f \n",avgScore);
			System.out.println("축하합니다, 합격입니다!");
		}
		else {
			System.out.println("불합격입니다.");
		}
		

	}

}
