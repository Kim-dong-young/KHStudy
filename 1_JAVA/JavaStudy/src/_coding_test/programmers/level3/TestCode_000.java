package _coding_test.programmers.level3;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/72413?language=java
// 작성중

public class TestCode_000 {
	public static final int INF = 100001;
	
	public static int[] dijkstra(int[][] graph, int s, int n) {
		int startNode = s-1;
		int minNode;
		int[] weightArr = new int[n];
		boolean[] isVisited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			weightArr[i] = graph[startNode][i];
		}
		isVisited[startNode] = true;
		weightArr[startNode] = 0;
		
		for(int i=0; i<n-2; i++) {
			int minNodeNum = -1;
			int minDist = INF;
			
			for(int j=0;j<n;j++) {
				if(!isVisited[j] && weightArr[j] < minDist) {
					minDist = weightArr[j];
					minNodeNum = j;
				}
			}
			
			if (minNodeNum == -1) {
                break; // 더 이상 방문할 노드가 없음
            }
			
			isVisited[minNodeNum] = true;
			
			for(int j=0; j<n; j++) {
				if(!isVisited[j]) {
					if(weightArr[j] > (weightArr[minNodeNum] + graph[minNodeNum][j])) {
						weightArr[j] = (weightArr[minNodeNum] + graph[minNodeNum][j]);
					}
				}
			}
		}
		
		return weightArr;
	}
	
	public static void main(String[] args) {
		int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
		int n = 7; // 그래프 노드 갯수
		int s = 3; // 탐색 시작 노드
		int a = 4; // A의 목적지
		int b = 1; // B의 목적지
		
		int[][] graph = new int[n][n];
		for(int[] row : graph) {
			Arrays.fill(row, INF);
		}
		
		for(int[] fare:fares) {
			graph[fare[0]-1][fare[1]-1] = fare[2];
			graph[fare[1]-1][fare[0]-1] = fare[2];
		}
		
		// 다익스트라 최소값 구하기
		int[] minDistS = dijkstra(graph,s,n);
		int[] minDistA = dijkstra(graph,a,n);
		int[] minDistB = dijkstra(graph,b,n);

		// 최소 비용 계산
        int minCost = INF;
        for (int i = 0; i < n; i++) {
            int cost = minDistS[i] + minDistA[i] + minDistB[i];
            if (cost < minCost) {
                minCost = cost;
            }
        }

        // 무지와 라이언이 각각 따로 갈 경우의 비용
        int separateCost = minDistS[a - 1] + minDistS[b - 1];

        // 두 경우 중 최소 비용 선택
        int result = Math.min(minCost, separateCost);
        System.out.println("최소 비용: " + result);
		
	}
}
