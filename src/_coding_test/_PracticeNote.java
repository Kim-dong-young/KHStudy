package _coding_test;

public class _PracticeNote {
	
	static void change(String[] arr) {
		arr[1] = "potato";
	}

	public static void main(String[] args) {
		String[] fruit = {"banana","apple","grape"};
		
		System.out.println(fruit[1]);
		change(fruit);
		System.out.println(fruit[1]);
	}

}
