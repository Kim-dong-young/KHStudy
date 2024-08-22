package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
import com.kh.model.vo.items.Item;

public class ItemController {
	private static ItemController ic;
	
	private ItemController() {
		super();
	}
	
	public static ItemController getInstance() {
		if(ic == null)
			ic = new ItemController();
		return ic;
	}

	public ArrayList<Item> getMemberItemList(Member m) {
		
		return null;
	}
}
