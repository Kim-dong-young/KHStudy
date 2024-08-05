package _algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

class QuickSort {
	static int[] result = new int[0];
	static int index;
	static int pivot;
	
	public static int[] sort(int[] arr) {
		if(arr.length <= 1) {
			return arr;
		}
		
		int[] front = new int[arr.length];
		int[] back = new int[arr.length];
		
		int fIndex = 0;
		int bIndex = 0;
		pivot = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > pivot) {
				front[fIndex++] = arr[i];
			}
			else {
				back[bIndex++] = arr[i];
			}
		}	
		
		front = Arrays.copyOf(front, fIndex);
		front = sort(front);
		
		pivot = arr[0];
		int[] pivotArr = {pivot};
		
		back = Arrays.copyOf(back, bIndex);
		back = sort(back);
		
		result = IntStream.concat(Arrays.stream(front), Arrays.stream(pivotArr)).toArray();
		result = IntStream.concat(Arrays.stream(result), Arrays.stream(back)).toArray();
		
		return result;
	}
}

public class Sort {
	public static void main(String[] args) {
		int[] arr = { 3, 9, 4, 7, 1 ,7 ,2, 5, 8, 6 };
		int[] sortedArr;
		
		sortedArr = QuickSort.sort(arr);
		
		for(int i : sortedArr) {
			System.out.print(i + " ");
		}
		
	}
}
