package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class TradeLog {
	private int tradeId;
	private int memberId;
	private Date tradeDate;
	private int stockId;
	private String stockName;
	private int tradeQty;
	private int tradePrice;
	private String status; // 판매 or 구매 여부
	
	public TradeLog() {
		super();
	}
	
	public TradeLog(int memberId, int stockId, int tradeQty, int tradePrice, String status) {
		super();
		this.memberId = memberId;
		this.stockId = stockId;
		this.tradeQty = tradeQty;
		this.tradePrice = tradePrice;
		this.status = status;
	}

	public TradeLog(int tradeId, int memberId, Date tradeDate, int stockId, String stockName, int tradeQty, int tradePrice,
			String status) {
		super();
		this.tradeId = tradeId;
		this.memberId = memberId;
		this.tradeDate = tradeDate;
		this.stockId = stockId;
		this.stockName = stockName;
		this.tradeQty = tradeQty;
		this.tradePrice = tradePrice;
		this.status = status;
	}
	
	/**
	 * @return the tradeId
	 */
	public int getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the tradeDate
	 */
	public Date getTradeDate() {
		return tradeDate;
	}
	/**
	 * @param tradeDate the tradeDate to set
	 */
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
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
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * @return the tradeQty
	 */
	public int getTradeQty() {
		return tradeQty;
	}
	/**
	 * @param tradeQty the tradeQty to set
	 */
	public void setTradeQty(int tradeQty) {
		this.tradeQty = tradeQty;
	}
	/**
	 * @return the tradePrice
	 */
	public int getTradePrice() {
		return tradePrice;
	}
	/**
	 * @param tradePrice the tradePrice to set
	 */
	public void setTradePrice(int tradePrice) {
		this.tradePrice = tradePrice;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tradeId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TradeLog) {
			TradeLog other = (TradeLog)obj;
			if(other.getTradeId() == this.tradeId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "TradeLog [tradeId=" + tradeId + ", memberId=" + memberId + ", tradeDate=" + tradeDate + ", stockId="
				+ stockId + ", stockName=" + stockName + ", tradeQty=" + tradeQty + ", tradePrice=" + tradePrice
				+ ", status=" + status + "]";
	}
	
	
}
