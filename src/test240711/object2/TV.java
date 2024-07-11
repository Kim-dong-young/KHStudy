package test240711.object2;

public class TV {
	// 다음과 같은 코드를 실행했을 때, 예시와 같은 결과가 출력되도록 TV 클래스를 작성하세요.
	/*
	TV myTV = new TV("삼성", 2020, 65, 100000);
	myTV.show();
	TV myTV2 = new TV("LG", 2024, 85, 500000);
	myTV2.show();
	 * 
	 * => 결과 :
	 * 삼성에서 만든 2020년형 65인치 TV 가격 : 100000;
	 * LG에서 만든 2024년형 85인치 TV 가격 : 500000;	 
	 * 
	*/
	private String brand;
	private int releaseYear;
	private int size;
	private int price;
	
	public TV(String brand, int releaseYear, int size, int price) {
		super();
		this.brand = brand;
		this.releaseYear = releaseYear;
		this.size = size;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void show() {
		System.out.println(this.getBrand() + "에서 만든 "+this.getReleaseYear()+"년형 "+
							this.getSize()+"인치 TV 가격 : "+ this.getPrice());
	}
	
	
}
