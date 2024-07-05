package _coding_test;

public class TestCode4 {
	//https://school.programmers.co.kr/learn/courses/30/lessons/12909
	
	public static void main(String[] args) {
		String s = ")()(";
		char[] stack = new char[s.length()];
		int top = -1;
		boolean answer = true;
		
		for(int i=0;i<stack.length;i++) {
			stack[i] = ' ';
		}
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '(') {
				top++;
				stack[top] = '(';
			}
			else {
				answer = (top >= 0) && (stack[top] != ' ') ? true : false;
				if(answer == false) break;
				
				stack[i] = ' ';
				top--;
			}
		}
		
		if(top != -1) answer = false;
		
		System.out.println(answer);
	}

}
