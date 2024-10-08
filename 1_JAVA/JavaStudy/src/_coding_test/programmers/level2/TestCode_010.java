package _coding_test.programmers.level2;

public class TestCode_010 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/68645?language=java

	public static void main(String[] args) {
		int n = 6;
		
		int[][] arr = new int[n][];
		for(int i=1; i<=arr.length; i++) {
			arr[i-1] = new int[i];
		}
		
		int num = 1;
		int count = 0;
		int i=0;
		
		while(true){
			
			// 가로
			for(int y=count; y < arr.length - count ; y++) {
				if(arr[y][count] != 0) continue;
				arr[y][count] = num++;
			}
			if(++i > n) break; 
			
			// 세로
			for(int x=count; x < arr.length - count ; x++) {
				if(arr[arr.length-1-count][x] != 0) continue;
				arr[arr.length-1-count][x] = num++;
			}
			if(++i > n) break; 
			
			// 대각선
			for(int xy= arr.length -1; xy > 0 ; xy-- ) {
				if( xy - count <= 0 || arr[xy][xy-count] != 0 ) continue;
				arr[xy][xy-count] = num++;
			}
			if(++i > n) break;
			
			count++;
			
		}
		
		int[] answer = new int[num - 1];
		int index = 0;
		for(int x=0; x< arr.length; x++) {
			for(int y=0; y< arr[x].length; y++) {
				answer[index] = arr[x][y];
				System.out.printf("%3d",answer[index]);
				index++;
			}
			System.out.println();
		}
	}
}
