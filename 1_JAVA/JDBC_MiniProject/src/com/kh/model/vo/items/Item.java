package com.kh.model.vo.items;

import java.util.Objects;

public class Item {
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemDesc;
	
	public Item() {
		super();
	}
	
	public Item(int itemId, String itemName, int itemPrice, String itemDesc) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDesc = itemDesc;
	}
	
	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemPrice
	 */
	public int getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the itemDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}
	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(itemId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item other = (Item)obj;
			if(other.getItemId() == this.itemId)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDesc="
				+ itemDesc + "]";
	}
	
	public void use() {
		
	}
	
}
