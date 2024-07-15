package _coding_test;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12941
// 작성중
class QuickSort {
	int[] arr;
	int[] result;
	int pivot;
	int count;
	
	public QuickSort(int[] arr) {
		this.arr = arr;
		this.result = new int[arr.length];
		this.pivot = arr[0];
	}
	
	public int[] sort(int[] arr) {
		if(arr.length <= 1) {
			return arr;
		}
		
		int[] front = new int[arr.length];
		int[] back = new int[arr.length];
		
		int fIndex = 0;
		int bIndex = 0;
		pivot = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < pivot) {
				front[fIndex++] = arr[i];
			}
			else {
				back[bIndex++] = arr[i];
			}
		}
		
		front = Arrays.copyOf(front, fIndex);
		result = sort(front);
		back = Arrays.copyOf(back, bIndex);
		result = sort(back);
		
		return result;
	}
}

public class TestCode_017 {
	public static void main(String[] args) {
		int[] A = {1,4,2};
		int[] B = {5,4,4};
		int sum = 0;
		
		/*
		 * A를 오름차순, B를 내림차순으로 정렬한다.
		 */
		
		for(int i=0; i< A.length; i++) {
			sum += A[i] * B[i];
		}
		System.out.println(sum);
		
	}
}
