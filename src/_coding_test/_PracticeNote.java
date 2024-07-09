package _coding_test;

public class _PracticeNote {

	public static void main(String[] args) {
		char c1 = 'j';
		char c2 = 'k';
		// ---g --- k ----
		int r1 = (c1 - c2 + 26) % 26;
		System.out.println("left distance : " + r1);

		int r2 = (c2 - c1 + 26) % 26;
		System.out.println("right distance : " + r2);
		
		System.out.println( ((r1 % 26) < (r2 % 26) ) ? (r1 % 26) : (r2 % 26) );
		
	}

}
