package _coding_test.programmers.level2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12941

public class TestCode_006 {
	public static void main(String[] args) {
		int[] A = {1,4,2};
		int[] B = {5,4,4};
		int[] reverseB = new int[B.length];
		int sum = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int index=0;
		for(int i = B.length-1; i>=0; i--) {
			reverseB[index++] = B[i];
		}
		
		for(int i=0; i< A.length; i++) {
			sum += A[i] * reverseB[i];
		}
		System.out.println(sum);
		
	}
}
