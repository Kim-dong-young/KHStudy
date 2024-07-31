package _miniproject.vo.items;

import java.util.Objects;

public class PredictPrice implements Item{
	private String name;
	private int price;
	
	public PredictPrice(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PredictPrice) {
			PredictPrice other = (PredictPrice)obj;
			return this.name.equals(other.getName());
		}
		return false;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
