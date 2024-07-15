package test240715.object1;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// 정수 num1, num2 ,num3를 입력 받아 홀짝을 출력하라
		
		// 입력 : 6 4 7
		// 짝 짝 홀
		
		/*
		int num1;
		int num2;
		int num3;
		
		System.out.print("입력 : ");
		num1 = s.nextInt();
		num2 = s.nextInt();
		num3 = s.nextInt();
		s.nextLine();

		System.out.print(((num1 % 2 == 0) ? "짝 " : "홀 "));
		System.out.print(((num2 % 2 == 0) ? "짝 " : "홀 "));
		System.out.print(((num3 % 2 == 0) ? "짝 " : "홀 "));
		*/
		
		// 정수(0~100)을 입력받아 0부터 입력받은 수까지 출력
		// 입력 : 7
		// 0 1 2 3 4 5 6 7
		
		/*
		int num;
		
		System.out.print("입력 : ");
		num = s.nextInt();
		
		if(num > 0 && num <= 100)
		for(int i=0; i<=num; i++) {
			System.out.print(i + " ");
		}
		*/
		
		
		
		// 번호를 입력한 횟수를 구하는 프로그램을 작성한다.
		// 번호(1~20)까지 무작위로 10번 입력받는다.
		// 입력받은 1~20까지의 수가 각각 몇번 입력되었는지를 출력한다.
		// 입력 : 1 5 7 10 15 5 1 7 7 2
		// 입력횟수 : 2 1 0 0 2 0 3 0 0 1 0 0 0 0 1 0 0 0 0 0
		
		/*
		int[] numCount = new int[20];
		int num;
		
		System.out.print("입력 : ");
		for(int i=0; i<numArr.length; i++) {
			num = s.nextInt();
			if(num < 0) num = 0;
			if(num > 20) num = 20;
			numCount[num - 1]++;
		}
		s.nextLine();
		
		System.out.print("입력횟수 : ");
		for(int n: numCount) {
			System.out.print(n+" ");
		}
		*/
		
		
		
		// 학생성적관리 프로그램을 만들고자 한다.
		// 학생 크래스를 정의해보자. Student class는 name(String), classRoom(int),
		// javaScore(double), sqlScore(double), practiceScore(double)값을 가진다.
		// 각 필드 데이터의 getter/setter, 기본생성자, 모든 필드 데이터를 초기화하는 생성자를 작성하고
		// 또한 toString : 학생의 정보를 "xx반 xxx학생 xx점 xx점 xx점" 으로 정보를 반환하는 메소드를 작성
		// 각 점수는 자바, sql, practice 순으로 작성
		// 	isPassed : 모든 점수가 50점 이상이면서 평균이 60점이상이면 true 아니면 false를 반환하는 메소드
		// 	reTest : 학생의 모든 점수를 랜덤(0~100)으로 다시부여하는 메소드 반환값 없음
		
		// 학생 10명을 생성하고, reTest를 실행한 후 모든 학생의 점수를 출력해라
		Student[] stArr = new Student[10];
		String[] stName = {"John","James","Alice","Grace","Michael",
							"Tomas","Chris","Alex","Jennifer","Jane"};
		for(int i=0; i<stArr.length; i++) {
			stArr[i] = new Student(stName[i],i+1,0,0,0);
			stArr[i].reTest();
			System.out.println(stArr[i].toString());
			System.out.println("isPassed : "+ stArr[i].isPassed()+"\n");
		}
		
		s.close();
	}
}
