package test240708;

public class Test9 {
	// 2차원 배열에 들어있는 데이터중 가장 큰 값과 가장 작은 값을 구한다
	// int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
	public static void main(String[] args) {
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		
		int max = array[0][0];
		int min = array[0][0];
		
		
		for(int[] arr:array) {
			for(int num:arr) {
				if(num > max) max = num;
				if(num < min) min = num;
			}
		}
		
		System.out.println("가장 큰 값 : " + max);
		System.out.println("가장 작은 값 : " + min);
	}
}
