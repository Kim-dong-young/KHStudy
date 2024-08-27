package com.kh.controller;

import java.util.ArrayList;
import java.util.HashSet;

import com.kh.model.vo.items.Item;
import com.kh.service.ItemService;

public class ItemController {
	private static ItemController ic;
	
	private ItemService is;
	
	private ItemController() {
		super();
		this.is = ItemService.getInstance();
	}
	
	public static ItemController getInstance() {
		if(ic == null) {
			ic = new ItemController();
		}
		return ic;
	}

	public ArrayList<Item> getItemList() {
		ArrayList<Item> itemList = is.getItemList();
		
		return itemList;
	}
	
}
