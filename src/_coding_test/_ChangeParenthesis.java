package _coding_test;

public class _ChangeParenthesis {
	public static void main(String[] args) {
		
		String s = "[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]";
		
		for(char ch:s.toCharArray()) {
			if(ch == '[') ch = '{';
			else if (ch==']') ch = '}';
			System.out.print(ch);
		}
	}
}
