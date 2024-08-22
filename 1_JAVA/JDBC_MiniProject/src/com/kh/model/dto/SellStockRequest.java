package com.kh.model.dto;

import java.util.Objects;

import com.kh.model.vo.Member;

public class SellStockRequest {
	private Member member;
	private int sellQuantity;
	private int stockid;
	private int price;
	
	public SellStockRequest() {
		super();
	}
	
	public SellStockRequest(Member member, int sellQuantity, int stockid, int price) {
		super();
		this.member = member;
		this.sellQuantity = sellQuantity;
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
	 * @return the sellQuantity
	 */
	public int getSellQuantity() {
		return sellQuantity;
	}

	/**
	 * @param sellQuantity the sellQuantity to set
	 */
	public void setSellQuantity(int sellQuantity) {
		this.sellQuantity = sellQuantity;
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
		return Objects.hash(member,sellQuantity,stockid);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SellStockRequest) {
			SellStockRequest other = (SellStockRequest)obj;
			if(other.getMember().equals(this.member) &&
					other.getSellQuantity() == this.sellQuantity &&
					other.getStockid() == this.stockid ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "SellStockRequest [member=" + member + ", sellQuantity=" + sellQuantity + ", stockid=" + stockid
				+ ", price=" + price + "]";
	}
	
	
}
