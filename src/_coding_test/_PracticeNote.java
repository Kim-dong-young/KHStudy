package _coding_test;

public class _PracticeNote {

	public static void main(String[] args) {
		String str = "[-1, -1], [-1, -1], [-1, -1], [-1, -1], [8, 5], [2, 10], [3, 0], [6, 1], [11, -1], [7, 4], [-1, -1], [-1, -1]";
		
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i) == '[') {
				System.out.print("{");
			}
			else if (str.charAt(i) == ']'){
				System.out.print("}");
			}
			else {
				System.out.print(str.charAt(i));
			}
		}
	}

}
