package com.kh.model.vo;

import java.util.Objects;

public class Stock {
	private int stockId;
	private String stockName;
	private boolean isDelist;
	
	public Stock() {
		super();
	}
	
	public Stock(int stockId, String stockName) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
	}

	public Stock(int stockId, String stockName, boolean isDelist) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.isDelist = isDelist;
	}
	
	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}
	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * @return the isDelist
	 */
	public boolean isDelist() {
		return isDelist;
	}

	/**
	 * @param isDelist the isDelist to set
	 */
	public void setDelist(boolean isDelist) {
		this.isDelist = isDelist;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(stockId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Stock) {
			Stock other = (Stock)obj;
			if(other.getStockId() == this.stockId)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", isDelist=" + isDelist + "]";
	}
	
	
}
