package com.kh.service;

public class ItemService {
	private static ItemService is;
	
	private ItemService() {
		super();
	}
	
	public static ItemService getInstance() {
		if(is == null)
			is = new ItemService();
		return is;
	}
}
