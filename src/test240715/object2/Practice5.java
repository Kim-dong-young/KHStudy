package test240715.object2;

class Book{
	private String title;
	private String author;
	private String publisher;
	private int price;
	private double discountRate;
	
	public Book() { }
	
	public Book(String title, String author, String publisher, int price, double discountRate) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.discountRate = discountRate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	
}

public class Practice5 {
	public static void main(String[] args) {
		Book[] bArray = new Book[3];
		
		bArray[0] = new Book("자바의 정석","남궁성","도우출판",30000,0.1);
		bArray[1] = new Book("열형강의 자바","구정은","프리랙",29000,0.1);
		bArray[2] = new Book("객체지향 JAVA8","금영옥","북스홈",30000,0.1);
		
		for(Book b : bArray) {
			System.out.println(b.getTitle()+", "+ b.getAuthor()+", " + b.getPublisher()+", " 
		+ b.getPrice() + "원, "+ (int)(b.getDiscountRate()*100) +"% 할인");
			System.out.println("할인된 가격 : " + (int)(b.getPrice() * (1 - b.getDiscountRate())) + "원" );
		}
	}
}
