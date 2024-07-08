package _coding_test;

import java.util.Arrays;

public class TestCode_014 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/42862
	// 작성중
	public static void main(String[] args) {
		
		/*
		 * test case : 
		 * 5 / { 1 } / { 5 } => 4
		 * 5 / { 4, 5 } / { 3, 4 } => 4
		 * 5 / { 4, 2 } / { 3 ,5 } => 5
		 * 10 / { 1, 2, 3, 4, 5, 6 } / { 1, 2, 3 } => 7
		 * 
		 */
		
		// 전체 학생 수, 2 <= n <= 30
		int n = 10;
		// 체육복을 도난당한 학생 번호
		int[] lost = { 1, 2, 3, 4, 5, 6 };
		// 여벌의 체육복을 가진 학생 번호
		int[] reserve = { 1, 2, 3 };
		boolean[] isLent = new boolean[reserve.length];

		int answer = n - lost.length; // 현재 체육복을 가진 학생 수
		
		// 자기자신이 잃어버린 경우는 빌려주지 않는다.
		for(int lostStudentNum : lost) {
			for(int i=0; i < reserve.length; i++) {
				if(lostStudentNum == reserve[i]) {
					isLent[i] = true;
					answer++;
				}
			}
		}
		
		// 전제 : 자료들은 내림차순으로 정렬되어 있어야 한다.
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		// 여벌 체육복을 가져온 학생이 체육복을 도난 당했을 경우??
		for(int lostStudentNum : lost) { // 도난당한 학생 탐색
			for(int i=0; i < reserve.length; i++) { // 빌려줄 수 있는 학생 확인
				if(isLent[i]) continue; // 만약 이미 빌려줬다면 넘어간다
				
				if( lostStudentNum == reserve[i]+1 ) isLent[i] = true; // 한 사이즈 큰 체육복을 빌려준다
				else if( lostStudentNum == reserve[i]-1 ) isLent[i] = true; // 한 사이즈 작은 체육복을 빌려준다
				else continue; // 사이즈가 안맞아 빌려줄 수 없으면 넘어간다
				
				answer++; // 빌려줬다면, 체육복을 가진 학생 수 증가
				break;
			}
		}
		
		System.out.println(answer);

	}

}
