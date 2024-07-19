package _coding_test.programmers.level1;

public class TestCode_004 {
	// https://school.programmers.co.kr/learn/courses/30/lessons/12906

	public static void main(String[] args) {
		int[] arr = {4,4,4,3,3};
		int[] temp = new int[arr.length];
		int top=0;
		
		for(int i=0; i<temp.length; i++) {
			temp[i] = -1;
		}
		
		temp[0]=arr[0];
		for(int i=1; i<arr.length;i++) {
			if(temp[top]!= arr[i]) {
				temp[top+1] = arr[i];
				top++;
			}
		}
		
		int[] answer = new int [top+1];
		for(int i=0; i<=top; i++) {
			answer[i]=temp[i];
			System.out.print(answer[i]+" ");
		}
		
	}
}
