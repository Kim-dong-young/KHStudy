package test01.t240705;

import java.util.Scanner;

public class T_06 {
	
	public static void main(String[] args) {
		/*
		 * 중간고사, 기말고사, 과제점수, 출석회수를 입력하고 Pass 또는 Fail을 출력하세요.
		 * 평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
		 * 이 때, 출석 비율은 출석 회수의 총 강의 회수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
		 * 70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.
		 * 
		 * ex)
		 * 중간 고사 점수 : 80
		 * 기말 고사 점수 : 30
		 * 과제 점수 : 60
		 * 출석 회수 : 18
		 * ================ 결과 ==================
		 * 중간 고사 점수(20) : 16.0
		 * 기말 고사 점수(30) : 9.0
		 * 과제 점수		(30) : 18.0
		 * 출석 점수		(20) : 18.0
		 * 총점 : 61.0
		 * Fail [ 점수 미달 ]
		 */
		
		float midTestPercent = 0.2f;
		float finalTestPercent = 0.3f;
		float subjectPercent = 0.3f;
		float attendPercent = 0.7f;
		float totalScore;
		
		int lectureDayNum = 20;
	
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		float midTestScore = s.nextFloat();
		midTestScore *= midTestPercent;
		
		System.out.print("기말 고사 점수 : ");
		float finalTestScore = s.nextFloat();
		finalTestScore *= finalTestPercent;
		
		System.out.print("과제 점수 : ");
		float subjectScore = s.nextFloat();
		subjectScore *= subjectPercent;
		
		System.out.print("출석 회수 : ");
		float attendScore = s.nextFloat();
		attendScore *= 1.0f;
		
		System.out.println("============ 결과 =============");
		
		System.out.println("중간 고사 점수(20) : " + midTestScore);
		System.out.println("기말 고사 점수(30) : " + finalTestScore);
		System.out.println("과제 점수(30) : " + subjectScore);
		System.out.println("출석 점수(20) : " + attendScore);
		totalScore = (midTestScore + finalTestScore + subjectScore + attendScore);
		
		System.out.println("총점 : "+ totalScore );
		System.out.println((totalScore > 70) && (attendScore > lectureDayNum * attendPercent) ? 
				"Pass" : "Fail");
		
		s.close();
	}

}
