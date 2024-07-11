package test240711.object1;

import java.util.Scanner;

public class T_02 {
	public static void main(String[] args) {
		// 정수 num을 입력받아 크키가 num인 정수형 배열을 만들고
		// 1~100 사이의 랜덤값을 모든 배열의 인덱스에 대입합니다.
		// 이후 모든 배열의 값을 출력하고, 홀수 인덱스의 값을 더한 값을 출력하세요.
		
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		
		int[] arr = new int[num];
		int oddSum = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 100 + 1);
			System.out.print(arr[i] + " ");
			if(i % 2 == 1) oddSum += arr[i];
		}
		System.out.println("\n홀수 인덱스의 합 : "+oddSum);
		
	}
}
