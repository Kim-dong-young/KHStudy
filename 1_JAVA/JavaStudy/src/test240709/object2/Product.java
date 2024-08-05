package test240709.object2;

public class Product {
	private String pName;
	private String brand;
	private int price;

	public Product() { }

	public Product(String pName, String brand, int price) {
		super();
		this.pName = pName;
		this.brand = brand;
		this.price = price;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void information() {
		System.out.println("상품명 : " + this.getpName());
		System.out.println("가격 : " + this.getPrice());
		System.out.println("제조사 : " + this.getBrand());
	}

}
