package _coding_test;

public class _ChangeParenthesis {
	public static void main(String[] args) {
		
		String s = "[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]";
		
		for(char ch:s.toCharArray()) {
			if(ch == '[') ch = '{';
			else if (ch==']') ch = '}';
			System.out.print(ch);
		}
	}
}
