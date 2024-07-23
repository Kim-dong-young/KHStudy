package _coding_test.leetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/triangle/

public class TestCode_003 {
	static int[][] memo;
	
	public static int getMinValue(int level, int index, List<List<Integer>> triangle) {
		memo = new int[triangle.size()][triangle.size()];
		for(int i=0; i< memo.length; i++) {
			for(int j=0; j< memo[i].length; j++) {
				memo[i][j] = -10001;
			}
		}
		return dfs(0,0,triangle);
	}
	
	public static int dfs(int level, int index, List<List<Integer>> triangle) {
		if(level == triangle.size() - 1) // 기저조건 = 상향식 접근
			return triangle.get(level).get(index);
		
		// 왼쪽경로와 오른쪽 경로중, 작은 값을 택한다. 최종적으로는 최소값이 된다
		if(memo[level][index] == -10001) {
			int minValue = Math.min(dfs(level+1,index,triangle), dfs(level+1,index+1,triangle));
			memo[level][index] = Integer.valueOf(minValue) + Integer.valueOf(triangle.get(level).get(index));
		}
		
		return memo[level][index];
	}
	
    public static void main(String[] args) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	
    	List<Integer> row1 = new ArrayList<Integer>(1);
    	row1.add(Integer.valueOf(2));
    	
    	List<Integer> row2 = new ArrayList<Integer>(2);
    	row2.add(Integer.valueOf(3));
    	row2.add(Integer.valueOf(4));
    	
    	List<Integer> row3 = new ArrayList<Integer>(3);
    	row3.add(Integer.valueOf(6));
    	row3.add(Integer.valueOf(5));
    	row3.add(Integer.valueOf(7));
    	
    	
    	List<Integer> row4 = new ArrayList<Integer>(4);
    	row4.add(Integer.valueOf(4));
    	row4.add(Integer.valueOf(1));
    	row4.add(Integer.valueOf(8));
    	row4.add(Integer.valueOf(3));
    	
    	triangle.add(row1);
    	triangle.add(row2);
    	triangle.add(row3);
    	triangle.add(row4);

    	System.out.println(getMinValue(0,0,triangle));
    }
}
