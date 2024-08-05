package _coding_test.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951

public class TestCode_007 {
	public static void main(String[] args) {
		String s = "AAa AaA aaa AAA  ";
		char[] sArr = s.toCharArray();
		
		boolean isWordFirst = true;
		char ch;
		
		for(int i=0; i<s.length(); i++) {
			ch = sArr[i];
			
			if(isWordFirst && (ch >= 97 && ch <=122)) 
				sArr[i] -= 32;
			
			if(!isWordFirst && (ch >= 65 && ch <= 90)) 
				sArr[i] += 32;
			
			isWordFirst = false;
			
			if(ch == ' ') isWordFirst = true;
		}
		
		String answer = String.valueOf(sArr);
		System.out.println(answer);
	}
}
