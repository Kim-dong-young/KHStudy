package test240715.object2;

import java.util.Scanner;

class Product{
	private String name;
	private int price;
	private int quantity;
	
	public Product() { }
	
	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String information() {
		return "상품명 : " + name + "\n가격 : " + price + " 원\n수량 : " + quantity +" 개";
	}

}

public class Practice4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name;
		int price;
		int quantity;
		
		System.out.print("상품명 : ");
		name = s.nextLine();
		
		System.out.print("가격 : ");
		price = s.nextInt();
		s.nextLine();
		
		System.out.print("수량 : ");
		quantity = s.nextInt();
		s.nextLine();
		
		Product p = new Product(name,price,quantity);
		System.out.println(p.information());
		System.out.println("총 구매 가격 : "+ (p.getPrice() * p.getQuantity()) + " 원");
		
		s.close();
	}
}
