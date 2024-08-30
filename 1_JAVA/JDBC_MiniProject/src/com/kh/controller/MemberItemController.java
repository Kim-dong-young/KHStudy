package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dto.BuyItemRequest;
import com.kh.model.vo.Member;
import com.kh.model.vo.MemberItem;
import com.kh.model.vo.items.Item;
import com.kh.service.MemberItemService;

public class MemberItemController {
	private static MemberItemController ic;
	
	private MemberItemService is = MemberItemService.getInstance();
	
	private MemberItemController() {
		super();
	}
	
	public static MemberItemController getInstance() {
		if(ic == null)
			ic = new MemberItemController();
		return ic;
	}

	public ArrayList<Item> getMemberItemList(Member m) {
		ArrayList<Item> itemList = is.getMemberItemList(m);
		return itemList;
	}

	public boolean buyItem(Member member, Item item) {
		BuyItemRequest biRequest = new BuyItemRequest(member.getMemberUid(), item.getItemId());
		boolean isSuccess = is.buyItem(biRequest);
		
		return isSuccess;
	}

	public boolean useItem(MemberItem memberItem) {
		boolean isSuccess = is.useItem(memberItem);
		
		return isSuccess;
	}
}
