package _coding_test;

public class TestCode_011 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/120866

	static int countSafeArea(int[][] board, boolean[][] isChecked, int i, int j) {
		int count = 0;
		
		/*
		 * i-1,j-1	i-1,j	i-1,j+1
		 * 
		 * i, j-1	i, j	i,j+1
		 * 
		 * i+1,j-1	i+1,j	i+1,j+1
		 */
		
		for(int y=i-1; y <= i+1; y++) {
			for(int x=j-1; x <= j+1; x++) {
				try {
					if(!isChecked[y][x]) {
						isChecked[y][x] = true;
						count++;
					}
				}catch(IndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[][] board = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0 } 
		};
		
		boolean[][] isChecked = new boolean[board.length][board.length];
		
		int safeArea = board.length * board.length;
		
		for(int i=0; i< board.length; i++) {
			for(int j=0; j< board[i].length; j++) {
				if(board[i][j] == 1) {
					safeArea -= countSafeArea(board, isChecked, i,j);
				}
			}
		}
		
		System.out.println(safeArea);

	}

}
