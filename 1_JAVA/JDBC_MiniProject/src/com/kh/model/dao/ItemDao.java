package com.kh.model.dao;

public class ItemDao {
	private static ItemDao itd;
	
	private ItemDao() {
		super();
	}
	
	public static ItemDao getInstance() {
		if(itd == null)
			itd = new ItemDao();
		return itd;
	}
}
