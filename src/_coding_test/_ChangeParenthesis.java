package _coding_test;

public class _ChangeParenthesis {
	public static void main(String[] args) {
		
		String s = "[\"...D..R\", \".D.G...\", \"....D.D\", \"D....D.\", \"..D....\"]";
		
		for(char ch:s.toCharArray()) {
			if(ch == '[') ch = '{';
			else if (ch==']') ch = '}';
			System.out.print(ch);
		}
	}
}
