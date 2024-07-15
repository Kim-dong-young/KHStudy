package _coding_test;

public class _ChangeParenthesis {
	public static void main(String[] args) {
		
		String s = "[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]";
		
		for(char ch:s.toCharArray()) {
			if(ch == '[') ch = '{';
			else if (ch==']') ch = '}';
			System.out.print(ch);
		}
	}
}
