package com.kh.model.vo;

import java.util.Objects;

public class MemberItem {
	private int memberUid;
	private int itemId;
	private int itemQty;

	public MemberItem() {
		super();
	}
	
	public MemberItem(int memberUid, int itemId) {
		super();
		this.memberUid = memberUid;
		this.itemId = itemId;
	}

	public MemberItem(int memberUid, int itemId, int itemQty) {
		super();
		this.memberUid = memberUid;
		this.itemId = itemId;
		this.itemQty = itemQty;
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
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemQty
	 */
	public int getItemQty() {
		return itemQty;
	}

	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(memberUid, itemId);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MemberItem) {
			MemberItem other = (MemberItem)obj;
			if(other.getMemberUid() == this.memberUid &&
			   other.getItemId() == this.itemId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "MemberItem [memberUid=" + memberUid + ", itemId=" + itemId + ", itemQty=" + itemQty + "]";
	}
	
	
}
