package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.ItemDao;
import com.kh.model.vo.items.Item;

public class ItemService {
	private static ItemService is;
	
	private ItemDao id;
	
	private ItemService() {
		super();
		this.id = ItemDao.getInstance();
	}
	
	public static ItemService getInstance() {
		if(is == null) {
			is = new ItemService();
		}
		return is;
	}

	public ArrayList<Item> getItemList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Item> itemList = id.getItemList(conn);
		
		JDBCTemplate.close(conn);
		return itemList;
	}

}
