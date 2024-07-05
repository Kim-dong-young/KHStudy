package _coding_test;

public class TestCode_008 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/120868
	
	public static void main(String[] args) {
		int[] sides = { 3,6 };
		int sideSum;	// 가장 긴 변을 제외한 나머지 변의 길이 합
		int longSide;	// sides 내에서 긴 변
		int shortSide;	// sides 내에서 짧은 변
		int answer = 0;
		
		sideSum = sides[0] + sides[1];
		longSide = (sides[0] > sides[1]) ? sides[0] : sides[1];
		shortSide = (sides[0] < sides[1]) ? sides[0] : sides[1];
		
		// 가장 긴 변이 longSide일 경우
		int minSide = (longSide - shortSide) + 1; // 나머지 한 변의 최소 길이

		for(int i=0; (minSide + i) <= longSide; i++) { // 최소 변의 길이부터 1씩 더해본다
			answer++;
		}
		
		//가장 긴 변이 미지수일 경우
		for(int i=longSide + 1; i<(longSide + shortSide); i++) { // 가장 긴 변의 길이는 다른 두 변의 합보다 작아야 한다
			answer++;
		}
		
		System.out.println(answer);

	}

}
