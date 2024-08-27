package com.kh.model.dto;

public class BuyItemRequest {
	private int memberUid;
	private int itemId;

	public BuyItemRequest() {
		super();
	}

	public BuyItemRequest(int memberUid, int itemId) {
		super();
		this.memberUid = memberUid;
		this.itemId = itemId;
	}

	public int getMemberUid() {
		return memberUid;
	}

	public void setMemberUid(int memberUid) {
		this.memberUid = memberUid;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "BuyItemRequest [memberUid=" + memberUid + ", itemId=" + itemId + "]";
	}

}
