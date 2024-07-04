package test01.t240704;

import java.util.Scanner;

public class T_07 {

	public static void main(String[] args) {
		/*
		 * 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
		 * 개수와 몇 번쨰 인덱스에 위치하는지 인덱스를 출력하세요.
		 * 
		 * ex)
		 * 문자열 : application
		 * 문자 : i
		 * 
		 * application에 i가 존재하는 위치(인덱스) : 4 8
		 * i 개수 : 2
		 */

		Scanner s = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String word = s.next();
		
		System.out.print("문자 : ");
		char alpha = s.next().charAt(0);
		
		int alphaCnt = 0;
		char[] arr = new char[word.length()];
		
		System.out.print("\n"+word+"에 "+alpha+"가 존재하는 위치(인덱스) : ");
		for(int i=0; i<word.length();i++) {
			arr[i] = word.charAt(i);
			
			if(arr[i]==alpha) System.out.print(i+" ");
			alphaCnt += (arr[i] == alpha)? 1 : 0;
		}
		System.out.println("\n"+alpha+" 개수 : "+alphaCnt);
	}

}
