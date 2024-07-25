package _miniproject.vo;

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
		return String.format("종목 : %s / 가격 : %d원 / 수량 : %d주", stockName, stockPrice, stockQuantity);
	}
	
	
}
