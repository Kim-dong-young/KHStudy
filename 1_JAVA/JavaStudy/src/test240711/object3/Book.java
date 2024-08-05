package test240711.object3;

public class Book {
	/*
	 * 우리는 도서관에 책을 관리하는 프로그램을 만들려고 한다.
	 * 해당 클래스는 도서관에 책을 등록할 때 사용하는 book객체를 생성할 Book클래스다.
	 * 필요하다고 생각하는 데이터와 기능들을 구현해보자
	 *
	 * 사용자로부터 제목, 장르, 저자, 책번호를 입력받아
	 * b1이라는 객체를 생성하고, 생성된 객체의 toString메소드를 호출하여 모든 정보를 확인하자
	 */
	private Book nextBook;
	private Book previousBook;
	
	private String name;
	private String genre;
	private String author;
	private int number;
	
	public Book(String name, String genre, String author, int number) {
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book getNextBook() {
		return nextBook;
	}

	public void setNextBook(Book nextBook) {
		this.nextBook = nextBook;
	}

	public Book getPreviousBook() {
		return previousBook;
	}

	public void setPreviousBook(Book previousBook) {
		this.previousBook = previousBook;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "책 제목 : " + name + ", 장르 : " + genre + ", 저자 : " + author + ", 책번호 : " + number;
	}

	
}
