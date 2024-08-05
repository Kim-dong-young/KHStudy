package test01.t240705;

import java.util.Scanner;

public class T_01 {

	public static void main(String[] args) {
		/*
		 * 실수형으로 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
		 * 이 때, 총점과 평균은 정수형으로 처리하세요.
		 * 
		 * ex)
		 * 국어 : 90.0
		 * 영어 : 90.0
		 * 수학 : 90.0
		 * 
		 * 총점 : 270
		 * 평균 : 90
		 */
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("국어 : ");
		float korScore = s.nextFloat();
		System.out.print("영어 : ");
		float engScore = s.nextFloat();
		System.out.print("수학 : ");
		float mathScore = s.nextFloat();
		
		int totalScore = (int)(korScore + engScore + mathScore);
		System.out.println("\n총점 : "+ totalScore);
		System.out.println("평균 : "+ totalScore/3);

		s.close();
	}

}
