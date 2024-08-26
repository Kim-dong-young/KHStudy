package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
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
}
