package _coding_test.programmers.level2;

public class TestCode_004 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=java

	static boolean isDevEnd(int[] progresses) {
		for(int i=0;i < progresses.length; i++) {
			if(progresses[i] < 100) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		int[] temp = new int[progresses.length]; // 임시로 답을 기록해둘 배열
		int[] answer;
		
		int top = 0;
		int count = 0; // 릴리즈 시점에서 배포된 작업 개수를 샌다
		int temp_index = 0;
		
		while(!isDevEnd(progresses)) {
			count = 0;
			// 매일 진척도 증가
			for(int i=0; i< progresses.length; i++) {
				if(progresses[i] < 100) progresses[i] += speeds[i];
			}
			
			// 현재 우선순위가 가장 높은 작업이 끝났다면
			if(progresses[top] >= 100) {
				count++; // 우선순위가 가장 높은 작업 +1
				// 나머지 작업들 탐색
				for(int i=top+1; i< progresses.length; i++) {
					// 나머지 작업들 중 100 미만인 작업을 탐색하면
					// = 뒤에 작업물 완성과 관계없이 출시지연
					if(progresses[i] < 100) {
						top = i;
						break;
					}
					count++; // 나머지 끝난 작업들만큼 추가
				}
				temp[temp_index++] = count; // 한 릴리즈에 배포된 기능개수 기록
			}
		}
		
		//temp에서 값 불러와 return 형식 맞추기
		answer = new int[temp_index];
		for(int i=0;i<temp_index;i++) {
			answer[i] = temp[i];
		}
		
		
	}
}
