package _coding_test.leetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/description/

public class TestCode_003 {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1); // Initialize the row with all 1s
        }

        for (int i = 1; i <= rowIndex; i++) {
            int prev = 1;
            for (int j = 1; j < i; j++) {
                int temp = result.get(j); // Store the current value to update it in the next iteration
                result.set(j, prev + temp);
                prev = temp; // Update prev for the next iteration
            }
        }

        return result;
    }

    public static void main(String[] args) {
    	TestCode_003 sol = new TestCode_003();
        int rowIndex = 5;
        List<Integer> row = sol.getRow(rowIndex);
        System.out.println(row); // Output the 5th row of Pascal's Triangle
    }
}
