package _coding_test;

public class TestCode_006 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/131130

	public static void main(String[] args) {
		int[] cards = { 8, 6, 3, 7, 2, 5, 1, 4 }; // 전체 카드
		int[] scoreArr = new int[2]; // 회차 점수 기록

		boolean[] isPicked = new boolean[cards.length]; // 전체 게임에서 열린 상자 기록
		boolean[] isPickedInRound = new boolean[cards.length]; // 한 회차 내, 열린 상자 기록
		boolean[] maxScorePick = new boolean[cards.length]; // 최고 점수일 때, 고른 상자 기록
		
		int cardInBox; // 상자 안의 숫자
		int nextBox = 0; // 다음으로 열 상자 번호
		int score = 0; // 한 회차 내, 한 경우의 수의 점수 (= 연 상자 개수)
		int maxScore = 0; // 한 회차 내, 모든 경우의 수 중 최고 점수

		for (int round = 0; round < 2; round++) {
			isPicked = maxScorePick.clone();
			maxScore = 0;
			
			for (int i = 0; i < cards.length; i++) {
				isPickedInRound = isPicked.clone();
				nextBox = i;
				score = 0;

				for (int j = 0; j < cards.length; j++) {
					
					if (isPickedInRound[nextBox]) { // 이미 열린 상자면 카드뽑기를 종료한다
						if (score > maxScore) { // 현재 점수가 최고 점수보다 크면 
							maxScore = score;   // 최고점수 기록
							maxScorePick = isPickedInRound.clone();
						}
						break;
					}

					score++; // 열린 상자 1개 = 점수
					isPickedInRound[nextBox] = true; // i번째 상자 열기
					cardInBox = cards[nextBox]; // 상자 안 카드 꺼내기

					nextBox = cardInBox - 1; // 상자 안 카드번호를 다음으로 열 상자로 지정
				}
				scoreArr[round] = maxScore;
			}
		}
		System.out.println(scoreArr[0] * scoreArr[1]);
	}

}
