package a.basic;
import java.util.Scanner;

public class Practice3 {
	/*
	 * 문자열 클래스에는 여러가지 기능이 있다.
	 * ex ) 문자열 비교시 -> 문자열.equals(비교문자열)
	 * 
	 * 문자열.charAt(index) : 문자열에서 내가 원하는 index의 글자를 가져온다.
	 * index : 순서를 지칭할 때 사용하는 것
	 * 
	 * 영어 단어를 키보드로 입력받아, 단어의 앞에서부터 3개를 출력하세요.
	 * ex ) apple -> app
	 * 
	 * 단어를 입력하세요 : (키보드로 입력)
	 * 첫 번째 문자 : a
	 * 두 번째 문자 : p
	 * 세 번째 문자 : p
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("단어를 입력하세요 : ");
		String word = s.next();
		System.out.println("첫 번째 문자 : "+ word.charAt(0));
		System.out.println("두 번째 문자 : "+ word.charAt(1));
		System.out.println("세 번째 문자 : "+ word.charAt(2));
	}
}
