package _miniproject.vo;

import java.util.Date;
import java.util.Objects;

public class TradeLog {
	private Long uid;
	private Date tradeDate;
	private String stockName;
	private int quantity;
	private int price;
	private String status;

	public TradeLog(Long uid, Date tradeDate, String stockName, int quantity, int price, String status) {
		super();
		this.uid = uid;
		this.tradeDate = tradeDate;
		this.stockName = stockName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uid,tradeDate,stockName,quantity,price,status);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TradeLog) {
			TradeLog other = (TradeLog)obj;
			if(	this.uid == other.getUid() &&
				this.tradeDate.equals(other.getTradeDate()) &&
			    this.stockName.equals(other.getStockName()) &&
			    this.quantity == other.getQuantity() &&
	      	    this.price == other.getPrice() &&
			    this.status.equals(other.getStatus())
			) return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return uid + " " + tradeDate + " " + stockName + " " + quantity + " " + price + " " + status;
	}
	
	
}
