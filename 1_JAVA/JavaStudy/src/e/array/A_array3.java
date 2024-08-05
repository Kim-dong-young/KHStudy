package e.array;

import java.util.Scanner;

public class A_array3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		/*
		// 1. 크기가 10인 정수형 배열을 생성해라
		int[] iArr = new int[10];
		
		// 2. 반복문을 통해서 0번 인덱스부터 마지막 인덱스 까지 모든 값을 1로 초기화해라
		for(int i=0;i<iArr.length;i++) {
			iArr[i] = 1;
		}
		
		// 3. 반복문을 통해서 0~마지막인덱스 까지 전부 출력해라
		for(int i=0;i<iArr.length;i++) {
			System.out.print(iArr[i]+" ");
		}
		*/
		
		/*
		// 4. 사용자에게 배열의 길이를 입력받아 해당 크기의 문자열 배열을 생성해라.
		// 길이 입력 : x
		
		System.out.print("길이 입력 : ");
		int sArrLength = s.nextInt();
		String[] sArr = new String[sArrLength];
		
		// 5. 반복문을 활용해서 매번 사용자에게 과일명을 입력받아 그 값을 strArr에 대입(0~마지막 인덱스)
		// 좋아하는 과일을 입력 : 바나나 (반복)
		
		for(int i=0;i<sArr.length;i++) {
			System.out.print("좋아하는 과일을 입력 : ");
			sArr[i]=s.next();
		}
		
		// 6. 반복문을 이용해서 strArr에 있는 모든값을 출력
		for(int i=0;i<sArr.length;i++) {
			System.out.print(sArr[i]+" ");
		}
		*/
		
		/*
		// 사용자에게 문자열 하나 입력받은 후
		// 각각의 인덱스에 있는 문자들을 char 배열에 옮겨담기
		
		// 1. 사용자에게 문자열 하나 입력받기
		System.out.print("문자열 입력 : ");
		String str = s.next();
		
		// 2. char배열 생성하기 (길이 => 문자열의 길이)
		char[] cArr = new char[str.length()];
		
		// 3. 반복문을 통해서 해당 문자열에서 각각 인덱스별 문자를 char배열의 각 인덱스 값에 대입
		for(int i=0;i<cArr.length;i++) {
			cArr[i]=str.charAt(i);
		}
		
		// 4. char배열의 모든 index값을 전체 출력
		for(int i=0;i<cArr.length;i++) {
			System.out.print(cArr[i]+" ");
		}
		*/
		
		// 사용자에게 배열의 길이를 입력받아 해당 길이의 정수형 배열 arr을 생성한다.
		// arr의 모든 인덱스값에 1~100사이의 랜덤값을 할당해주고
		// arr의 모든 값을 출력 한 후
		// 이 중 짝수인 값의 총 합을 구해서 출력
		
		int arrLength = s.nextInt();
		
		int[] arr = new int[arrLength];
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100 + 1);
			System.out.print(arr[i]+" ");
			sum+= ( arr[i] % 2 == 0 ) ? arr[i] : 0;
		}
		System.out.println("\n짝수 총 합 : "+sum);
		
	}

}
