package _miniproject.vo;

import java.util.Objects;

public class Stock {
	private String stockName;
	private int stockPrice;
	private int stockQuantity;
	private int maxQuantity;
	
	public Stock() {
		super();
	}

	public Stock(String stockName, int stockPrice, int stockQuantity) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockQuantity = stockQuantity;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	@Override
	public String toString() {
		return String.format("종목 : %s / 가격 : %d / 수량 : %d", stockName, stockPrice, stockQuantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockName);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Stock) {
			Stock other = (Stock)obj;
			if(this.getStockName().equals(other.getStockName()))
				return true;
		}
		return false;
	}
	
	
	
	
}
