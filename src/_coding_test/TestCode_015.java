package _coding_test;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860?language=java
// 작성중
public class TestCode_015 {

    public static void main(String[] args) {
        String name = "JAZ";
        char[] nameArr = name.toCharArray();
        
        int moveCount = 0;
        
        // 1. 단어를 바꾸는 조이스틱 조작횟수
        for(int i=0; i < nameArr.length; i++) {
        	int leftDistance = ('A' - nameArr[i] + 26) % 26;
			int rightDistance = (nameArr[i] - 'A' + 26) % 26;
			int minDistance = (leftDistance < rightDistance) ? leftDistance : rightDistance;
			
			moveCount += minDistance;
        }
        
        // 2. 최소로 움직이는 횟수 ( 왼쪽 vs 오른쪽 )
        int cursor=0;
        for(int i=0; i< nameArr.length; i++) {
        	/*
        	 * 현재 커서 기준으로 왼쪽, 오른쪽을 탐색
        	 * 둘 중 현재 커서와의 거리가 더 짧은 쪽으로 이동하면 된다
        	 * 다 바뀔때까지 반복
        	 */
        }

        System.out.println(moveCount);
    }
}
