package test01.t240704;

public class T_09 {

	public static void main(String[] args) {
		/*
		 * 4행 4열짜리 정수형 배열을 선언 및 할당하고
		 * 		1) 1 ~ 16 까지 값을 차례대로 저장하세요
		 * 		2) 저장된 값들을 차례대로 출력하세요.
		 * 
		 * ex)
		 * 	1  2  3  4
		 *  5  6  7  8
		 *  9 10 11 12
		 * 13 14 15 16
		 */
		
		int[][] arr = new int[4][4];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = i * arr.length + j + 1;
				System.out.printf("%2d ",arr[i][j]);
			}
			System.out.println();
		}

	}

}
