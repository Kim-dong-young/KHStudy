package _coding_test;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860?language=java
// 작성중

public class TestCode_015 {

	public static void main(String[] args) {
		String name = "JZZAAAAZ";
		char[] nameArr = name.toCharArray();

		int moveCount = 0;

		// 1. 단어를 바꾸는 조이스틱 조작횟수
		for (int i = 0; i < nameArr.length; i++) {
			int leftDistance = ('A' - nameArr[i] + 26) % 26;
			int rightDistance = (nameArr[i] - 'A' + 26) % 26;
			int minDistance = (leftDistance < rightDistance) ? leftDistance : rightDistance;

			moveCount += minDistance;
		}

		// 2. 최소로 움직이는 횟수 ( 왼쪽 vs 오른쪽 )
        int minCursorMove = nameArr.length - 1; // 초기값 : 모든 문자를 순차적으로 가는 경우

        for (int i = 0; i < nameArr.length; i++) {
            int nextChar = i + 1;
            while (nextChar < nameArr.length && nameArr[nextChar] == 'A') {
                nextChar++;
            }
            // i는 현재 탐색중인 문자, 처음부터 끝까지 모든 문자를 탐색한다.
            // math.min ( 현 시점 최선 vs i 부터 다음으로 바꿔야할 문자로 갈때 왼쪽으로 갈 때의 거리 + Math.min(i, i 부터 다음으로 바꿔야할 문자로 갈 때 오른쪽으로 갈 때의 거리)
            minCursorMove = Math.min(minCursorMove, i + nameArr.length - nextChar + Math.min(i, nameArr.length - nextChar));
        }

        moveCount += minCursorMove;
        System.out.println(moveCount);
	}
}
