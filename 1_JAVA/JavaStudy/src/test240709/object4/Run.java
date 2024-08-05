package test240709.object4;

public class Run {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book("어린 왕자", "A사", "생 텍쥐페리");
		Book book3 = new Book("인어 공주", "W사", "안데르센", 9000, 30);
		
		book1.inform(); System.out.println();
		book2.inform(); System.out.println();
		book3.inform(); System.out.println();
	}

}
