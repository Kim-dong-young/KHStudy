package com.kh.model.vo;

import java.util.Objects;

public class Share {
	private int memberUid;
	private int stockId;
	private int shareQty;
	private int sharePrice;
	private double shareFluct;
	
	public Share() {
		super();
	}
	
	public Share(int memberUid, int stockId, int shareQty, int sharePrice, double shareFluct) {
		super();
		this.memberUid = memberUid;
		this.stockId = stockId;
		this.shareQty = shareQty;
		this.sharePrice = sharePrice;
		this.shareFluct = shareFluct;
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
	 * @return the shareQty
	 */
	public int getShareQty() {
		return shareQty;
	}
	/**
	 * @param shareQty the shareQty to set
	 */
	public void setShareQty(int shareQty) {
		this.shareQty = shareQty;
	}
	/**
	 * @return the sharePrice
	 */
	public int getSharePrice() {
		return sharePrice;
	}
	/**
	 * @param sharePrice the sharePrice to set
	 */
	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}
	/**
	 * @return the shareFluct
	 */
	public double getShareFluct() {
		return shareFluct;
	}
	/**
	 * @param shareFluct the shareFluct to set
	 */
	public void setShareFluct(double shareFluct) {
		this.shareFluct = shareFluct;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(memberUid,stockId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Share) {
			Share other = (Share) obj;
			if (other.getMemberUid() == this.memberUid && 
				other.getStockId() == this.stockId)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Share [memberUid=" + memberUid + ", stockId=" + stockId + ", shareQty=" + shareQty + ", sharePrice="
				+ sharePrice + ", shareFluct=" + shareFluct + "]";
	}
	
	
}
