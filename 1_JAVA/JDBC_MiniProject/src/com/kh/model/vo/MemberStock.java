package com.kh.model.vo;

import java.util.Objects;

public class MemberStock {
	private int stockId;
	private int memberUid;
	private int maxQty;
	private int stockQty;
	private int stockPrice;
	private double nextFluct;
	private String stockName;
	private boolean isDelist;

	public MemberStock() {
		super();
	}

	public MemberStock(int stockId, int memberUid, int maxQty, int stockQty, int stockPrice, double nextFluct,
			String stockName, boolean isDelist) {
		super();
		this.stockId = stockId;
		this.memberUid = memberUid;
		this.maxQty = maxQty;
		this.stockQty = stockQty;
		this.stockPrice = stockPrice;
		this.nextFluct = nextFluct;
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
	 * @return the memberUid
	 */
	public int getMemberUid() {
		return memberUid;
	}

	/**
	 * @param memberUid the memberUid to set
	 */
	public void setMemberUid(int memberUid) {
		this.memberUid = memberUid;
	}

	/**
	 * @return the maxQty
	 */
	public int getMaxQty() {
		return maxQty;
	}

	/**
	 * @param maxQty the maxQty to set
	 */
	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	/**
	 * @return the stockQty
	 */
	public int getStockQty() {
		return stockQty;
	}

	/**
	 * @param stockQty the stockQty to set
	 */
	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	/**
	 * @return the stockPrice
	 */
	public int getStockPrice() {
		return stockPrice;
	}

	/**
	 * @param stockPrice the stockPrice to set
	 */
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	/**
	 * @return the nextFluct
	 */
	public double getNextFluct() {
		return nextFluct;
	}

	/**
	 * @param nextFluct the nextFluct to set
	 */
	public void setNextFluct(double nextFluct) {
		this.nextFluct = nextFluct;
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
		return Objects.hash(stockId, memberUid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MemberStock) {
			MemberStock other = (MemberStock)obj;
			if(other.getStockId() == this.stockId &&
			   other.getMemberUid() == this.memberUid)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "MemberStock [stockId=" + stockId + ", memberUid=" + memberUid + ", maxQty=" + maxQty + ", stockQty="
				+ stockQty + ", stockPrice=" + stockPrice + ", nextFluct=" + nextFluct + ", stockName=" + stockName
				+ ", isDelist=" + isDelist + "]";
	}
	
	
}
