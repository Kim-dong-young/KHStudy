package _miniproject.vo;

import java.util.Objects;

public class Item {
	private String name;
	private int price;
	private int amount;
	
	public Item(String name, int price, int amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item other = (Item)obj;
			return this.getName().equals(other.getName());
		}
		return false;
	}
	
	
}
