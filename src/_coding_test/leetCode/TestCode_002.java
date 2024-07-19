package _coding_test.leetCode;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/pascals-triangle/description/

public class TestCode_002 {
	public static void main(String[] args) {
		int numRows = 5;
		
		// create 2-Dimension List
		List<List<Integer>> pascalTri = new ArrayList<List<Integer>>(numRows);
		
		// set first row as 1
		List<Integer> firstRow = new ArrayList<Integer>(1);
		firstRow.add(Integer.valueOf(1));
		pascalTri.add(firstRow);
		
		for(int i=1; i< numRows; i++) {
			
			List<Integer> prevRow = pascalTri.get(i-1);
			List<Integer> currentRow = new ArrayList<Integer>(i);
			
			for(int j=0; j<= i; j++) {
				if(j == 0 || j == i) // value of pascal triangle's edge is 1
					currentRow.add(Integer.valueOf(1));
				else
					currentRow.add(prevRow.get(j-1) + prevRow.get(j));
			}
			
			pascalTri.add(currentRow);
		}
		
	}
}
