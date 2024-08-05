package _miniproject.vo.items;

import java.util.Objects;

public class Item {
	private String itemNum;
	private String name;
	private int price;
	
	public Item(String itemNum, String name, int price) {
		super();
		this.itemNum = itemNum;
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
	
	public String getItemNum() {
		return itemNum;
	}
	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}
	
	@Override
	public String toString() {
		return itemNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemNum);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item other = (Item)obj;
			return this.name.equals(other.getName());
		}
		return false;
	}
	
	public void use() {
		// TODO Auto-generated method stub
		
	}
}
