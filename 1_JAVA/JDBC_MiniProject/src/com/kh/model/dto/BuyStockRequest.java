package com.kh.model.dto;

import java.util.Objects;

import com.kh.model.vo.Member;

public class BuyStockRequest {
	private Member member;
	private int buyQuantity;
	private int stockid;
	private int price;

	public BuyStockRequest() {
		super();
	}

	public BuyStockRequest(Member member, int buyQuantity, int stockid, int price) {
		super();
		this.member = member;
		this.buyQuantity = buyQuantity;
		this.stockid = stockid;
		this.price = price;
	}

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}
	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}
	/**
	 * @return the buyQuantity
	 */
	public int getBuyQuantity() {
		return buyQuantity;
	}
	/**
	 * @param buyQuantity the buyQuantity to set
	 */
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	/**
	 * @return the stockid
	 */
	public int getStockid() {
		return stockid;
	}
	/**
	 * @param stockid the stockid to set
	 */
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(member,buyQuantity,stockid);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BuyStockRequest) {
			BuyStockRequest other = (BuyStockRequest)obj;
			if(other.getMember().equals(this.member) &&
					other.getBuyQuantity() == this.buyQuantity &&
					other.getStockid() == this.stockid ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "BuyStockRequest [member=" + member + ", buyQuantity=" + buyQuantity + ", stockid=" + stockid + "]";
	}
	
}
