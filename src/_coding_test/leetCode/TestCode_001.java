package _coding_test.leetCode;

// https://leetcode.com/problems/climbing-stairs/submissions/1325777772/

public class TestCode_001 {
	public static void main(String[] args) {
		int n=1;
		
		int dp[] = new int[n];
		dp[0] = 1;
		if(n>=2) dp[1] = 2;
		
		for(int i=2; i< dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n-1]);
		
		
	}
}
