package test240709.object4;

public class Book {
	private String title;
	private String publisher;
	private String author;
	
	private int price;
	
	private double discountRate;
	
	public Book() { }
	
	public Book(String title, String publisher, String author) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}

	public Book(String title, String publisher, String author, int price, double discountRate) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public void inform() {
		System.out.println("제목 : " + this.getTitle());
		System.out.println("저자 : " + this.getAuthor());
		System.out.println("출판사 : " + this.getPublisher());
		System.out.println("원가 : " + this.getPrice());
		System.out.println("할인율 : " + this.getDiscountRate());
		System.out.println("판매가 : " + (int)(this.getPrice() * (1 - this.getDiscountRate() / 100)) );
	}
	
	
}
