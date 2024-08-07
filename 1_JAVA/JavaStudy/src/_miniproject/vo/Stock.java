package _miniproject.vo;

import java.util.Objects;

public class Stock {
	private String stockName;
	private int stockPrice;
	private int priceFluct; // 전날 대비 가격 변동폭
	private int stockQuantity;
	private int maxQuantity;
	private double nextFluct; // 다음날 주식 변동비율
	
	public Stock() {
		super();
	}

	public Stock(String stockName, int stockPrice, int stockQuantity) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockQuantity = stockQuantity;
		this.priceFluct = 0;
		this.nextFluct = 0.8 + (Math.random() * 0.4);
	}

	public Stock(String stockName, int stockPrice, int previousPrice, int stockQuantity, double nextFluct) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.priceFluct = previousPrice;
		this.stockQuantity = stockQuantity;
		this.nextFluct = nextFluct;
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

	public int getPriceFluct() {
		return priceFluct;
	}

	public void setPriceFluct(int priceFluct) {
		this.priceFluct = priceFluct;
	}

	public double getNextFluct() {
		return nextFluct;
	}

	public void setNextFluct(double nextFluct) {
		this.nextFluct = nextFluct;
	}

	@Override
	public String toString() {
		return String.format("종목 : %s / 가격 : %d / 수량 : %d / 변동폭 : %d / 변동률 : %.2f", stockName, stockPrice, stockQuantity, priceFluct, nextFluct);
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
