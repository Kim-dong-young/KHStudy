package test240711.object3;

import java.util.Scanner;

public class BookController {
	/*
	 * 우리는 도서관에 책을 관리하는 프로그램을 만들려고 한다.
	 * 해당 클래스는 도서관에 책을 등록할 때 사용하는 book객체를 생성할 Book클래스다.
	 * 필요하다고 생각하는 데이터와 기능들을 구현해보자
	 *
	 * 사용자로부터 제목, 장르, 저자, 책번호를 입력받아
	 * b1이라는 객체를 생성하고, 생성된 객체의 toString메소드를 호출하여 모든 정보를 확인하자
	 */
	
	private Book firstBook;
	private Scanner s;
	
	public BookController() {
		this.s = new Scanner(System.in);
	}

	public void regBook() {
		Book newBook;
		
		System.out.println("등록할 책의 정보를 입력하세요.");
		System.out.print("제목 : ");
		String bookName = s.nextLine();
		
		System.out.print("장르 : ");
		String genre = s.nextLine();
		
		System.out.print("저자 : ");
		String author = s.nextLine();
		
		System.out.print("책번호 : ");
		int bookNumber = s.nextInt();
		s.nextLine();
		
		newBook = new Book(bookName,genre,author,bookNumber);
		if(firstBook == null) {
			firstBook = newBook;
		}
		else {
			insertBook(firstBook, newBook);
		}
	}
	
	public void insertBook(Book currentBook, Book newBook) {
		if(currentBook.getNextBook() != null) { // 현재 책의 다음 책이 존재한다면
			insertBook(currentBook.getNextBook(), newBook); // 다음 책으로 이동
		}
		else { // 현재 책의 다음 책이 없다면 ( = 마지막 책이라면 )
			currentBook.setNextBook(newBook); // 새 책 삽입
			newBook.setPreviousBook(currentBook);
		}
	}
	
	public void showBookList() {
		if(firstBook != null) showBookList(firstBook);
		else System.out.println("등록된 책이 없습니다.");
	}
	
	private void showBookList(Book currentBook) {
		System.out.println(currentBook.toString());
		if(currentBook.getNextBook() != null) {
			showBookList(currentBook.getNextBook());
		}
	}
	
	public void findBook(String searchName) {
		if(firstBook != null) findBook(firstBook, searchName);
		else System.out.println("입력하신 제목의 책은 등록되어있지 않습니다.");
	}
	
	private void findBook(Book currentBook, String searchName) {
		if(currentBook.getName().equals(searchName)) { // 찾을 책 제목이 현재 탐색중이 책 제목과 일치할 경우
			System.out.println(currentBook.toString());
			return;
		}
		
		if(currentBook.getNextBook() == null) { // 현재 탐색중인 책이 마지막 책일 경우
			System.out.println("입력하신 제목의 책은 등록되어있지 않습니다.");
			return;
		}
		
		else{ // 현재 탐색중인 책의 다음책이 있을 경우, 계속 탐색
			findBook(currentBook.getNextBook(), searchName);
		}
	}
	
	public void delBook(int delBookNum) {
		if(firstBook != null) delBook(firstBook, delBookNum);
		else System.out.println("책장이 비어있습니다.");
	}
	
	private void delBook(Book currentBook, int delBookNum) {
		if(currentBook == firstBook) { // 찾을 책이 제일 첫번째 책일 경우
			if(currentBook.getNextBook() != null) { // 첫번째 책이 유일한 책일 경우
				currentBook.getNextBook().setPreviousBook(null);
				firstBook = currentBook.getNextBook();
			}
			System.out.println("다음 책이 삭제되었습니다. : "+currentBook.toString());
			currentBook = null;
			return;
		}
		
		// 찾을 책 제목이 현재 탐색중이 책 제목과 일치할 경우 && 다음 책이 존재할 경우
		else if(currentBook.getNumber() == delBookNum && currentBook.getNextBook() != null ) {
			//현재책의 이전책을 불러와, 이전책의 다음책을 현재책의 다음책으로 변경한다
			currentBook.getPreviousBook().setNextBook(currentBook.getNextBook());
			//현재책의 다음책을 불러와, 다음책의 이전책을 현재책의 이전책으로 변경한다
			currentBook.getNextBook().setPreviousBook(currentBook.getPreviousBook());
			System.out.println("다음 책이 삭제되었습니다. : "+currentBook.toString());
			currentBook = null; // 현재 책을 삭제 ( GC가 처리 )
			return;
		}
		// 찾을 책 제목이 현재 탐색중인 책 제목과 일치할 경우 && 이 책이 마지막 책일 경우
		else if (currentBook.getNumber() == delBookNum && currentBook.getNextBook() == null) {
			currentBook.getPreviousBook().setNextBook(null);
			System.out.println("다음 책이 삭제되었습니다. : "+currentBook.toString());
			currentBook = null; // 현재 책을 삭제 ( GC가 처리 )
			return;
		}
		
		if(currentBook.getNextBook() == null) { // 현재 탐색중인 책이 마지막 책일 경우
			System.out.println("삭제할 책이 존재하지 않습니다.");
			return;
		}
		
		else{ // 현재 탐색중인 책의 다음책이 있을 경우, 계속 탐색
			delBook(currentBook.getNextBook(), delBookNum);
		}
	}
	
}
