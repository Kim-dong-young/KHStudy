package _miniproject.vo;

import java.util.Objects;

public class Shares {
	private String stockName;
	private int quantity;
	private int purchasePrice;
	
	public Shares(String stockName, int quantity, int purchasePrice) {
		super();
		this.stockName = stockName;
		this.quantity = quantity;
		this.purchasePrice = purchasePrice;
	}
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public void updatePurchasePrice(int newQuantity, int newPrice) {
		int totalQuantity = this.quantity + newQuantity;
		int totalCost = (this.purchasePrice * this.quantity) + (newPrice * newQuantity);
		this.purchasePrice = totalCost / totalQuantity;
		this.quantity = totalQuantity;
	}

	@Override
	public String toString() {
		return String.format("종목 : %s / 수량 : %d / 매입가 : %d", stockName, quantity, purchasePrice);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockName);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Shares) {
			Shares other = (Shares)obj;
			if(other.stockName.equals(this.stockName))
				return true;
		}
		return false;
	}
	
}
