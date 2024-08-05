package _coding_test.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12924

public class TestCode_009 {
	public static void main(String[] args) {
		int n = 15;
		
		boolean isPossible;
		int result = 1;
		int sum = 0;
		
		for(int i=1; i<=n/2; i++) {
			sum = 0;
			sum += i;
			isPossible = true;
			for(int j=i+1; j<=n/2+1; j++) {
				sum += j;
				if(sum > n) {
					isPossible = false;
					break;
				}
				else if(sum == n) {
					isPossible = true;
					break;
				}
			}
			if(isPossible) result++;
		}
		
		System.out.println(result);
	}
}
