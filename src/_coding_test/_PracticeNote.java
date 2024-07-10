package _coding_test;

public class _PracticeNote {

    public static void main(String[] args) {
        String name = "JAZAAAAZ";
        char[] nameArr = name.toCharArray();
        int moveCount = 0;
        
        // 1. 단어를 바꾸는 조이스틱 조작 횟수
        for (int i = 0; i < nameArr.length; i++) {
            int leftDistance = ('A' - nameArr[i] + 26) % 26;
            int rightDistance = (nameArr[i] - 'A' + 26) % 26;
            int minDistance = Math.min(leftDistance, rightDistance);
            
            moveCount += minDistance;
        }

        // 2. 최소로 움직이는 횟수 (왼쪽 vs 오른쪽)
        int n = nameArr.length;
        int minMove = n - 1; // 모든 문자를 순차적으로 가는 경우 초기값

        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && nameArr[next] == 'A') {
                next++;
            }
            // 좌우로 이동하여 최소 이동 거리 계산
            minMove = Math.min(minMove, i + n - next + Math.min(i, n - next));
        }

        moveCount += minMove;
        System.out.println(moveCount);
    }

}
