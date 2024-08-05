package _algorithm;

public class Dijkstra {
	public static void main(String[] args) {
		int[][] graph = {
				{0,2,5,999,3},
				{999,0,999,4,10},
				{999,999,0,6,2},
				{999,999,999,0,999},
				{999,999,1,2,0}
		};
		int n = graph.length;
		
		// 그래프 출력
		System.out.println("그래프 구성");
		for(int[] line : graph) {
			for(int fare : line) {
				System.out.printf("%3d", fare);
			}
			System.out.println();
		}
		
		// 다익스트라 최소값 구하기
		int startNode = 0;
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
			int minDist = 999;
			
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
		
		
		System.out.println("최소 가중치 : ");
		for(int w : weightArr) {
			System.out.print(w + " ");
		}

		
		
	}
}
